package com.wake.nlkm.error;

import com.wake.nlkm.utils.StateType;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */
public class DataNotExitException extends BaseException {

    public DataNotExitException(){
        super(StateType.DATANOTEXIT.getCode(),StateType.DATANOTEXIT.getValue());
    }

    public DataNotExitException(int code, String msg) {
        super(code, msg);
    }
}
