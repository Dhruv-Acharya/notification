package com.contest.notification.dto;

import com.contest.notification.notificationEnum.PostComment;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY
)
@JsonSubTypes({

        @JsonSubTypes.Type(value = Contest.class,name="Contest"),
        @JsonSubTypes.Type(value = Comment.class,name="Comment"),
        @JsonSubTypes.Type(value = Follow.class,name="Follow"),
        @JsonSubTypes.Type(value = Generic.class,name="Generic"),
        @JsonSubTypes.Type(value = Like.class,name="Like"),
        @JsonSubTypes.Type(value = QuestionsAdded.class,name="QuestionsAdded"),
        @JsonSubTypes.Type(value = Result.class,name="Result"),
        @JsonSubTypes.Type(value = Share.class,name="Share"),
        @JsonSubTypes.Type(value = SubscriptionNotice.class,name="SubscriptionNotice"),
        @JsonSubTypes.Type(value = Welcome.class,name="Welcome")
})
public abstract class NotificationBodyAbstractClass {

}
