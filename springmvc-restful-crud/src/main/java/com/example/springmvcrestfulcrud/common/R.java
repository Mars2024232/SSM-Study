package com.example.springmvcrestfulcrud.common;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> ok(T data) {
        R<Object> objectR = new R<>();
        objectR.setCode(200);
        objectR.setMsg("成功");
        objectR.setData(data);
        return (R<T>) objectR;
    }

    public static R ok() {
        R<Object> objectR = new R<>();
        objectR.setCode(200);
        objectR.setMsg("成功");
        return R.ok();
    }

    public static R error(Integer code, String msg, Object data) {
        R<Object> objectR = new R<>();
        objectR.setCode(500);//默认失败码
        objectR.setMsg("error");
        return objectR;
    }

    public static R error(Integer code, String msg) {
        R<Object> objectR = new R<>();
        objectR.setCode(code);
        objectR.setMsg("error");
        return objectR;
    }

    public static R error() {
        R<Object> objectR = new R<>();
        objectR.setCode(500);
        objectR.setMsg("error");
        return objectR;
    }

}
