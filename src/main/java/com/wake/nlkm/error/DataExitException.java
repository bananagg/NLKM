package com.wake.nlkm.error;

import com.wake.nlkm.utils.StateType;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class DataExitException extends BaseException {

    public DataExitException(){
        super(StateType.DATAEXIT.getCode(),StateType.DATAEXIT.getValue());
    }

    public DataExitException(int code, String msg) {
        super(code, msg);
    }
}
