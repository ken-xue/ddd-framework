package io.ddd.framework.application.common.event;

import io.ddd.framework.coreclient.dto.common.event.EventI;
import io.ddd.framework.coreclient.dto.common.response.Response;

import java.util.concurrent.ExecutorService;

/**
 * 事件处理器顶层接口
 * @param <R>
 * @param <E>
 */
public interface EventHandlerI<R extends Response, E extends EventI> {

    default ExecutorService getExecutor(){
        return null;
    }

    R execute(E e);
}
