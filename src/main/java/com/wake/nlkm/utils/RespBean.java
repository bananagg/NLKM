package com.wake.nlkm.utils;

/**
 * bbb
 * @Author Ganty
 * @Date 2020/8/18
 * @Des 返回消息
 */
public class RespBean {
    private Integer code;
    private String msg;
    private Object data;

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok() {
        return new RespBean(StateType.OK.getCode(), StateType.OK.getValue(), null);
    }
    public static RespBean ok(String msg) {
        return new RespBean(StateType.OK.getCode(), msg, null);
    }

    public static RespBean ok(Object obj){
        return new RespBean(StateType.OK.getCode(), StateType.OK.getValue(),obj);
    }
    public static RespBean ok(String msg, Object obj) {
        return new RespBean(StateType.OK.getCode(), msg, obj);
    }


    public static RespBean error(String msg) {
        return new RespBean(StateType.ERROR.getCode(), msg, null);
    }

    public static RespBean error(Integer code, String msg){
        return new RespBean(code, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(StateType.ERROR.getCode(), msg, obj);
    }

    public static RespBean notLogin() {
        return new RespBean(StateType.UNAUTHORIZED.getCode(), StateType.UNAUTHORIZED.getValue());
    }

    public RespBean() {
    }

    public RespBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public RespBean(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public Integer getCode() {
        return code;
    }

    public RespBean setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RespBean setData(Object data) {
        this.data = data;
        return this;
    }
}
