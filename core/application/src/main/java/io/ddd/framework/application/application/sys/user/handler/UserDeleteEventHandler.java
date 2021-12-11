package io.ddd.framework.application.application.sys.user.handler;

import io.ddd.framework.application.common.event.EventHandler;
import io.ddd.framework.application.common.event.EventHandlerI;
import io.ddd.framework.coreclient.api.sys.UserOfRoleAppService;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.user.event.UserDeleteEvent;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRoleDeleteCmd;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@Slf4j
@EventHandler
public class UserDeleteEventHandler implements EventHandlerI<Response, UserDeleteEvent> {

    @Resource
    private UserOfRoleAppService userOfRoleAppService;
    
    public Response execute(UserDeleteEvent event) {
        log.debug("Handling Event:{}",event);
        UserOfRoleDeleteCmd cmd = new UserOfRoleDeleteCmd();
        cmd.setUserUuids(new String[]{event.getUserUuid()});
        userOfRoleAppService.delete(cmd);
        return Response.success();
    }
}
