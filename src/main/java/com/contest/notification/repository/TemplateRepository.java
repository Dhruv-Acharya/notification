package com.contest.notification.repository;

import com.contest.notification.entity.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends MongoRepository<Template,String> {

    Template findByTemplateName(int templateName);
}
