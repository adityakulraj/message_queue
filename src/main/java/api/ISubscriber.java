package api;

import model.Message;

public interface ISubscriber {

    public void consume(Message message) throws InterruptedException;

    public String getId();
}
