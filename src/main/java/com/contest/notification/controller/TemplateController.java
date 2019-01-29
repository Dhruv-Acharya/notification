package com.contest.notification.controller;

import com.contest.notification.dto.TemplateDTO;
import com.contest.notification.entity.Template;
import com.contest.notification.service.TemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @PostMapping
    public ResponseEntity<String> addTemplate(@RequestBody TemplateDTO templateDTO){
        Template template = new Template();
        BeanUtils.copyProperties(templateDTO, template);
        Template templateCreated = templateService.addTemplate(template);
        return new ResponseEntity<>(templateCreated.getTemplateId(),HttpStatus.OK);
    }

    @PutMapping("/{templateId}")
    public ResponseEntity<String> updateTemplate(@PathVariable("templateId") String templateId,@RequestBody TemplateDTO templateDTO){
        Template template = new Template();
        BeanUtils.copyProperties(templateDTO, template);
        template.setTemplateId(templateId);
        Template templateCreated = templateService.updateTemplate(template);
        return new ResponseEntity<>(templateCreated.getTemplateId(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{templateId}",method = RequestMethod.GET)
    public ResponseEntity<TemplateDTO>  getOnetemplate(@PathVariable("templateId") String templateId){
        Template template = templateService.findOneTemplate(templateId);
        TemplateDTO templateDTO = new TemplateDTO();
        BeanUtils.copyProperties(template, templateDTO);
        return  new ResponseEntity<>(templateDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{templateId}")
    public ResponseEntity<Boolean> deleteTemplate(@PathVariable("templateId") String templateId){
        templateService.deleteTemplate(templateId);
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }


}
