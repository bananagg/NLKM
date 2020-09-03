package com.wake.nlkm.controller;

import com.wake.nlkm.error.BaseException;
import com.wake.nlkm.error.DataExitException;
import com.wake.nlkm.error.DataNotExitException;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.StateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Ganty
 * @Date 2020/8/20
 * @Des
 */

//捕捉工程所有异常
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    //拦截Exception类型异常
    @ExceptionHandler(value = DataExitException.class)
    @ResponseBody
    public RespBean DataExitExceptionHandler(HttpServletRequest request, DataExitException ex){
        logger.error(ex.getStackTrace().toString());
        RespBean respBean =  new RespBean(StateType.DATAEXIT.getCode(),StateType.DATAEXIT.getValue());
        return respBean;
    }

    @ExceptionHandler(value = DataNotExitException.class)
    @ResponseBody
    public RespBean DataNotExitExceptionHandler(HttpServletRequest request, DataNotExitException ex){
        logger.error(ex.getStackTrace().toString());
        RespBean respBean =  new RespBean(StateType.DATANOTEXIT.getCode(),StateType.DATANOTEXIT.getValue());
        return respBean;
    }

    @ExceptionHandler(value = FailException.class)
    @ResponseBody
    public RespBean FailExceptionHandler(HttpServletRequest request, FailException ex){
        ex.printStackTrace();
        logger.error(ex.getStackTrace().toString());
        RespBean respBean =  new RespBean(ex.getCode(), ex.getMsg());
        return respBean;
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public RespBean defaultBaseExceptionHandler(HttpServletRequest request, BaseException ex){
        ex.printStackTrace();
        logger.error(ex.getStackTrace().toString());

        RespBean respBean =  RespBean.error(ex.getCode(),ex.getMsg());
        return respBean;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespBean defaultExceptionHandler(HttpServletRequest request, Exception ex){
        ex.printStackTrace();
        logger.error(ex.getStackTrace().toString());

        RespBean respBean =  RespBean.error("error");
        return respBean;
    }


}
