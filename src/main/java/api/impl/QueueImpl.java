package api.impl;

import api.ISubscriber;
import api.Queue;
import handler.TopicHandler;
import model.Message;
import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QueueImpl implements Queue {


    private  Map<String, TopicHandler> topicProcessors;



    public QueueImpl() {
        topicProcessors = new HashMap<>();
    }
    @Override
    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId() , topicHandler);
        return topic;

    }

    @Override
    public void addSubscriber(ISubscriber subscriber, Topic topic) {
        TopicSubscriber topicSubscriber = new TopicSubscriber(subscriber);
        topic.addSubscriber(topicSubscriber);
    }

    @Override
    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }
}
