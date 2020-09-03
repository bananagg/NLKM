package com.wake.nlkm.error;

import com.wake.nlkm.utils.StateType;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class FailException extends BaseException {

    public FailException(){
        super(StateType.ERROR.getCode(),StateType.ERROR.getValue());
    }

    public FailException(String msg){
        super(StateType.ERROR.getCode(), msg);
    }

    public FailException(int code, String msg) {
        super(code, msg);
    }
}
