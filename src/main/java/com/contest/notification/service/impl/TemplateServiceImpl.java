package com.contest.notification.service.impl;

import com.contest.notification.entity.Template;
import com.contest.notification.repository.TemplateRepository;
import com.contest.notification.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository templateRepository;

    @Override
    public Template addTemplate(Template template) {
            return templateRepository.save(template);
    }

    @Override
    public Template updateTemplate(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public void deleteTemplate(String templateId) {
        templateRepository.delete(templateId);
    }

    @Override
    public Template findOneTemplate(String templateId) {
        return templateRepository.findOne(templateId);
    }
}
