package io.ddd.framework.application.sys.user.handler;

import io.ddd.framework.application.common.event.EventHandler;
import io.ddd.framework.application.common.event.EventHandlerI;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.user.event.UserUpdateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EventHandler
public class UserUpdateEventHandler implements EventHandlerI<Response, UserUpdateEvent> {
    
    public Response execute(UserUpdateEvent event) {
        log.debug("Handling Event:{}",event);
        return Response.success();
    }
}
