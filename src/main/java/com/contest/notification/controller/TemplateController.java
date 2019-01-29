package com.contest.notification.controller;

import com.contest.notification.dto.TemplateDTO;
import com.contest.notification.entity.Template;
import com.contest.notification.service.TemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @PostMapping
    public ResponseEntity<String> addTemplate(TemplateDTO templateDTO){
        Template template = new Template();
        BeanUtils.copyProperties(templateDTO, template);
        Template templateCreated = templateService.addTemplate(template);
        return new ResponseEntity<>(templateCreated.getTemplateId(),HttpStatus.CREATED);
    }


}
