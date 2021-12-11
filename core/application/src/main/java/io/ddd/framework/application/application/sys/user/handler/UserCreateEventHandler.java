package io.ddd.framework.application.application.sys.user.handler;

import io.ddd.framework.application.common.event.EventHandler;
import io.ddd.framework.application.common.event.EventHandlerI;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.user.event.UserCreateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EventHandler
public class UserCreateEventHandler implements EventHandlerI<Response, UserCreateEvent> {

    public Response execute(UserCreateEvent event) {
        log.debug("Handling Event:{}",event);
        return Response.success();
    }
}
