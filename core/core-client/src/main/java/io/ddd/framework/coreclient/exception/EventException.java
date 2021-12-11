package io.ddd.framework.coreclient.exception;

import io.ddd.framework.coreclient.exception.code.EventErrorCode;

public class EventException extends BaseException{

    public EventException(String message){
        super(message);
        this.setCode(EventErrorCode.EVENT_ERROR);
    }

    public EventException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setCode(EventErrorCode.EVENT_ERROR);
    }
}
