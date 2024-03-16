package api;

import model.Message;
import model.Topic;

public interface Queue {

    public Topic createTopic(String topicName);

    public void addSubscriber(ISubscriber subscriber, Topic topic);

    public void publish(Topic topic, Message message);


}
