package com.wake.nlkm.error;

import com.wake.nlkm.utils.StateType;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class RequestParamIsEmptyException extends BaseException {

    public RequestParamIsEmptyException(){
        super(StateType.PAEAMEMPTY.getCode(),StateType.PAEAMEMPTY.getValue());
    }

    public RequestParamIsEmptyException(String msg){
        super(StateType.PAEAMEMPTY.getCode(), msg);
    }

    public RequestParamIsEmptyException(int code, String msg) {
        super(code, msg);
    }
}
