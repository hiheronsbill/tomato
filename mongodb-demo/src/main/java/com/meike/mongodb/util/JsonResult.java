package com.meike.mongodb.util;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class JsonResult {

    public static final int NO_LOGIN = 400;
    public static final int LOGIN_FAILED = 401;
    public static final int TOKEN_EXPIRED = 402;
    public static final int NO_PERMISSION = 403;


    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public JsonResult(Boolean success) {
        this.success = success;
    }

    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResult(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public JsonResult(Boolean success, Integer code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void put(String key,Object value){
        if(data == null){
            data = new HashMap<>();
        }
        ((Map)data).put(key,value);
    }

    public void putAll(Map<String,Object> map){
        if(data == null){
            data = new HashMap<>();
        }
        ((Map)data).putAll(map);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
