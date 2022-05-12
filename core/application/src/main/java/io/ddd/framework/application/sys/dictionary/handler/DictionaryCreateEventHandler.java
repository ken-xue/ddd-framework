package io.ddd.framework.application.sys.dictionary.handler;

import io.ddd.framework.application.common.event.EventHandler;
import io.ddd.framework.application.common.event.EventHandlerI;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.dictionary.event.DictionaryCreateEvent;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Slf4j
@EventHandler
public class DictionaryCreateEventHandler implements EventHandlerI<Response, DictionaryCreateEvent> {

    public Response execute(DictionaryCreateEvent event) {
        log.debug("Handling Event:{}",event);
        return Response.success();
    }
}
