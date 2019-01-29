package com.contest.notification.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document(collection = Template.COLLECTION_NAME)
public class Template {

    public static final String COLLECTION_NAME = "template";

    @Id
    private String templateId;
    @NotNull
    private String templateName;
    @NotNull
    private String template;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "Template{" +
                "templateId='" + templateId + '\'' +
                ", templateName='" + templateName + '\'' +
                ", template='" + template + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Template)) return false;
        Template template1 = (Template) o;
        return Objects.equals(getTemplateId(), template1.getTemplateId()) &&
                Objects.equals(getTemplateName(), template1.getTemplateName()) &&
                Objects.equals(getTemplate(), template1.getTemplate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTemplateId(), getTemplateName(), getTemplate());
    }
}
