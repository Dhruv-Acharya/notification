package com.contest.notification.controller;

import com.contest.notification.dto.UserDTO;
import com.contest.notification.entity.User;
import com.contest.notification.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO : Exception handling

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
    public ResponseEntity<User> getUser(@PathVariable(value = "userId") String userId) {
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
    public ResponseEntity<String> setAndroidDeviceId(@PathVariable(value = "userId") String userId, @PathVariable(value = "androidDeviceId") String androidDeviceId) {
        User user = userService.findOne(userId);
        User updatedUser = userService.setAndroidDeviceId(user, androidDeviceId);
        return new ResponseEntity<String>(updatedUser.getUserId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/setBrowserDeviceId/{userId}/{browserDeviceId}", method = RequestMethod.PUT)
    public ResponseEntity<String> setBrowserDeviceId(@PathVariable(value = "userId") String userId, @PathVariable(value = "browserDeviceId") String browserDeviceId) {
        User user = userService.findOne(userId);
        User updatedUser = userService.setBrowserDeviceId(user, browserDeviceId);
        return new ResponseEntity<String>(updatedUser.getUserId(), HttpStatus.OK);
    }
}
