package com.contest.notification.service;

import com.contest.notification.entity.Template;

public interface TemplateService {

    Template addTemplate(Template template) throws Exception;
    Template updateTemplate(Template template);
    void deleteTemplate(String templateId);
    Template findOneTemplate(String templateId);
    Template findByTemplateName(int templateName);

}
