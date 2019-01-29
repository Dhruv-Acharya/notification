package com.contest.notification.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = NotificationData.COLLECTION_NAME )
public class NotificationData {

    public static final String COLLECTION_NAME = "notificationdata";

}
