package io.ddd.framework.application.common.event;


import io.ddd.framework.coreclient.dto.common.event.EventI;
import io.ddd.framework.coreclient.dto.common.response.Response;

public interface EventBusI {
    /**
     * 发送事件
     * @param event
     * @return
     */
    Response publish(EventI event);
    /**
     * 发送事件
     * @param event
     * @return Response
     */
    void publishAll(EventI event);
    /**
     * 异步发送事件
     * @param event
     */
    void asyncPublish(EventI event);
}

