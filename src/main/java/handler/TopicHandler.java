package handler;

import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private  Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {

        this.topic = topic;
        subscriberWorkers = new HashMap<>();
    }

    public void publish() {

        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }

    }

    private void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        final String subkey = topicSubscriber.getSubscriber().getId();

        if(!subscriberWorkers.containsKey(subkey)) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subkey, subscriberWorker);
            new Thread(subscriberWorker).start();

        }
        else {
            subscriberWorkers.get(subkey).wakeUpIfNeeded();
        }
    }


}
