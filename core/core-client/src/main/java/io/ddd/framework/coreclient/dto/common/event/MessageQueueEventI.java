package io.ddd.framework.coreclient.dto.common.event;

public interface MessageQueueEventI extends EventI {
    String getEventType();
    String getEventTopic();
}
