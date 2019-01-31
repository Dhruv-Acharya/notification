package com.contest.notification.controller;

import com.contest.notification.dto.UserDTO;
import com.contest.notification.entity.User;
import com.contest.notification.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser.getUserId(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(value = "userId") String userId) throws Exception {
        return new ResponseEntity<User>(userService.findOne(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable(value = "userId") String userId, @RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<String>(updatedUser.getUserId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/setAndroidDeviceId/{userId}/{androidDeviceId}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> setAndroidDeviceId(@PathVariable(value = "userId") String userId, @PathVariable(value = "androidDeviceId") String androidDeviceId) throws Exception {
        User user = userService.findOne(userId);
        UserDTO response = new UserDTO();
        if (user == null) {
            response.setStatus("failure");
            response.setMessage("User not found.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        User updatedUser = userService.setAndroidDeviceId(user, androidDeviceId);
        if (updatedUser == null) {
            response.setStatus("failure");
            response.setMessage("Android device id could not be updated.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        BeanUtils.copyProperties(updatedUser,response);
        response.setStatus("success");
        response.setMessage("Android Id updated");
        return new ResponseEntity<UserDTO>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "/setBrowserDeviceId/{userId}/{browserDeviceId}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> setBrowserDeviceId(@PathVariable(value = "userId") String userId, @PathVariable(value = "browserDeviceId") String browserDeviceId) throws Exception {
        User user = userService.findOne(userId);
        UserDTO response = new UserDTO();
        if (user == null) {
            response.setStatus("failure");
            response.setMessage("User not found.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        User updatedUser = userService.setBrowserDeviceId(user, browserDeviceId);
        if (updatedUser == null) {
            response.setStatus("failure");
            response.setMessage("Browser device id could not be updated.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        BeanUtils.copyProperties(updatedUser,response);
        response.setStatus("success");
        response.setMessage("Browser Id updated");
        return new ResponseEntity<UserDTO>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "/setFacebookPreference/{userId}/{facebookPreference}", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> setFacebookPreference(@PathVariable(value = "userId") String userId, @PathVariable(value = "facebookPreference") int facebookPreference) throws Exception {
        User user = userService.findOne(userId);
        UserDTO response = new UserDTO();
        if (user == null) {
            response.setStatus("failure");
            response.setMessage("User not found.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        User updatedUser = userService.setFacebookPreference(user, facebookPreference);
        if (updatedUser == null) {
            response.setStatus("failure");
            response.setMessage("Facebook preference could not be updated.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        BeanUtils.copyProperties(updatedUser,response);
        response.setStatus("success");
        response.setMessage("Facebook preference updated");
        return new ResponseEntity<UserDTO>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "/setContestPreference/{userId}/{contestPreference}", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> setContestPreference(@PathVariable(value = "userId") String userId, @PathVariable(value = "contestPreference") int contestPreference) throws Exception {
        User user = userService.findOne(userId);
        UserDTO response = new UserDTO();
        if (user == null) {
            response.setStatus("failure");
            response.setMessage("User not found.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        User updatedUser = userService.setContestPreference(user, contestPreference);
        if (updatedUser == null) {
            response.setStatus("failure");
            response.setMessage("Contest preference could not be updated.");
            return new ResponseEntity<UserDTO>(response, HttpStatus.OK);
        }
        BeanUtils.copyProperties(updatedUser,response);
        response.setStatus("success");
        response.setMessage("Contest preference updated");
        return new ResponseEntity<UserDTO>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUsers() throws Exception {
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

}
