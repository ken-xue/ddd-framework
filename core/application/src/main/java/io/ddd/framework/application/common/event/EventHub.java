package io.ddd.framework.application.common.event;


import io.ddd.framework.coreclient.dto.common.event.EventI;
import io.ddd.framework.coreclient.dto.common.response.Response;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件控制中枢
 */
@Component
public class EventHub {

    private HashMap<Class, List<EventHandlerI>> eventRepository = new HashMap<>();

    private Map<Class, Class> responseRepository = new HashMap<>();

    public HashMap<Class, List<EventHandlerI>> getEventRepository() {
        return eventRepository;
    }

    public void setEventRepository(HashMap<Class, List<EventHandlerI>> eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Map<Class, Class> getResponseRepository() {
        return responseRepository;
    }

    @SneakyThrows
    public List<EventHandlerI> getEventHandler(Class eventClass) {
        List<EventHandlerI> eventHandlerIList = findHandler(eventClass);
        if (eventHandlerIList == null || eventHandlerIList.size() == 0) {
            throw new Exception(eventClass + " is not registered in eventHub, please register first");
        }
        return eventHandlerIList;
    }

    /**
     * 注册事件
     * @param eventClz
     * @param executor
     */
    public void register(Class<? extends EventI> eventClz, EventHandlerI executor){
        List<EventHandlerI> eventHandlerIS = eventRepository.get(eventClz);
        if(eventHandlerIS == null){
            eventHandlerIS = new ArrayList<>();
            eventRepository.put(eventClz, eventHandlerIS);
            //executor.getClass().getMethod("execute").getReturnType().getClass();//获取当前事件处理器的响应结果
            responseRepository.put(executor.getClass(), Response.class);//默认先使用Response
        }
        eventHandlerIS.add(executor);

    }

    private List<EventHandlerI> findHandler(Class<? extends EventI> eventClass){
        List<EventHandlerI> eventHandlerIIList = null;
        Class cls = eventClass;
        eventHandlerIIList = eventRepository.get(cls);
        return eventHandlerIIList;
    }

}

