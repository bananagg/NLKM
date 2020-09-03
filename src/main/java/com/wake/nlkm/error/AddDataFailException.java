package com.wake.nlkm.error;

import com.wake.nlkm.utils.StateType;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class AddDataFailException extends BaseException {

    public AddDataFailException(){
        super(StateType.DATAEXIT.getCode(),StateType.DATAEXIT.getValue());
    }

    public AddDataFailException(int code, String msg) {
        super(code, msg);
    }
}
