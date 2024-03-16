package model;

import api.ISubscriber;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {

    private ISubscriber subscriber;

    private AtomicInteger offset;

    public TopicSubscriber(@NonNull ISubscriber subscriber) {

        this.subscriber = subscriber;
        offset = new AtomicInteger(0);

    }
}
