package com.hlw.noteservice.model;

import java.io.Serializable;

/**
 * 统一响应处理
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this.code = 500;
        this.msg = "系统内部错误";
    }

    /**
     * 成功
     *
     * @param data
     */
    public Result(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "OK";
    }

    /**
     * 失败
     *
     * @param msg
     * @param code
     */
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result fail(String msg){
        return new Result(503,msg);
    }

    public static <T> Result<T> success(T t) {
        return new Result<>(t);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
