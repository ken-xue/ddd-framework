package io.ddd.framework.coreclient.dto.common.event;

public interface MessageQueueEventI extends EventI {
    public String getEventType();
    public String getEventTopic();
}
