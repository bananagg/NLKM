package com.wake.nlkm.error;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class BaseException extends Exception {

    private int code;
    private String msg;

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
