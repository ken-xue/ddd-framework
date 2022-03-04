package io.ddd.framework.coreclient.dto.common.response;

import java.util.HashMap;
import java.util.Map;

public class MapResponse extends Response {

    private static final long serialVersionUID = 1L;

    private Map<String,Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return data == null || data.size() == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static MapResponse success() {
        MapResponse response = new MapResponse();
        return response;
    }

    public static MapResponse error(Integer code, String message) {
        MapResponse response = new MapResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public MapResponse of(String key,Object value) {
        this.data.put(key,value);
        return this;
    }
}
