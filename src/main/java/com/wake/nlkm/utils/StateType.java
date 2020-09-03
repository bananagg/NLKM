package com.wake.nlkm.utils;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public enum StateType {
    /**
     * 成功返回状态
     */
    OK(0,"成功"),
    ERROR(10001,"失败"),
    DATAADDFAIL(10001, "新增数据失败"),


    DATAEXIT(20001,"数据已存在"),
    DATANOTEXIT(20002, "数据不存在"),

    PAEAMEMPTY(30001, "请求参数为空"),





    /**
     * 请求格式错误
     */
    BAD_REQUEST(400,"bad request"),
    /**
     * 未授权
     */
    UNAUTHORIZED(401,"未登录"),
    /**
     * 没有权限
     */
    FORBIDDEN(403,"forbidden"),

    /**
     * 请求的资源不存在
     */
    NOT_FOUND(404,"not found"),
    /**
     * 该http方法不被允许
     */
    NOT_ALLOWED(405,"method not allowed"),
    /**
     * 请求处理发送异常
     */
    PROCESSING_EXCEPTION(406,"Handling Exceptions"),
    /**
     *
     * 请求处理未完成
     */
    PROCESSING_UNFINISHED(407,"To deal with unfinished"),

    /**
     * 登录过期
     */
    BEOVERDUE(408,"Be overdue"),

    /**
     * 用户未登录
     */
    NOT_LOGIN(409,"Not logged in"),

    /**
     * 这个url对应的资源现在不可用
     */
    GONE(410,"gone"),
    /**
     * 请求类型错误
     */
    UNSUPPORTED_MEDIA_TYPE(415,"unsupported media type"),
    /**
     * 校验错误时用
     */
    UNPROCESSABLE_ENTITY(422,"unprocessable entity"),
    /**
     * 请求过多
     */
    TOO_MANY_REQUEST(429,"too many request");

    private int code;
    private String value = null;

    private StateType(int code,String value) {
        this.code = code;
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public int getCode() {
        return code;
    }
    public String getValue(){
        return value;
    }



    public static Boolean isValidateStateType(String... stateType) {
        for (int i = 0; i < stateType.length; i++) {
            StateType [] value = StateType.values();
            boolean falg = false;
            for(StateType type : value) {
                if(type.value.equals(stateType[i])) {
                    falg = true;
                }

            }
            if(!falg) {
                return falg;
            }
        }
        return true;
    }


}



