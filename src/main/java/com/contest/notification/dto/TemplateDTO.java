package com.contest.notification.dto;

import javax.validation.constraints.NotNull;

public class TemplateDTO {

    private String templateId;
    private int templateName;
    private String template;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public int getTemplateName() {
        return templateName;
    }

    public void setTemplateName(int templateName) {
        this.templateName = templateName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
