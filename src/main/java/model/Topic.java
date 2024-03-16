package model;


import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Topic {

    private String topicName;
    private String topicId;
    private List<Message> messages;
    private List<TopicSubscriber>  topicSubscribers;


    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
    }

    public void addMessage(@NonNull Message message) {
        messages.add(message);

    }

    public void addSubscriber(@NonNull TopicSubscriber topicSubscriber) {
        topicSubscribers.add(topicSubscriber);
    }


}
