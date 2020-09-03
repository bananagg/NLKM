package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.TermsDefined;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GoodSentenceService;
import com.wake.nlkm.service.TermsDefinedService;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.RespPageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@ResponseBody
@RequestMapping("/api/v1/termsdefined")
@Slf4j
@Api(value = "术语定义Api文档", tags = "术语定义操作接口")
public class TermsDefinedController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TermsDefinedService termsDefinedService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询优美语句")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "术语名称", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数（默认：1）", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度（默认：20）", required = false, dataType = "Integer")
    })
    public RespBean getTermsDefinedList(@RequestParam(defaultValue = "0") String name,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "20") Integer size) throws Exception{
        logger.info("get getTermsDefined List page = "+ page + "   size = " + size);
        RespPageBean respPageBean = termsDefinedService.queryTermsDefinedBatch(name, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "通过id查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "术语id", required = true, dataType = "Integer")
    })
    public RespBean queryInfoById(@RequestParam(required = false) Integer id) throws Exception{
        logger.info("query Terms Defined InfoById。 id = " + id);
        if (id == null){
            throw new RequestParamIsEmptyException();
        }
        TermsDefined termsDefined = termsDefinedService.queryTermsDefinedById(id);
        RespBean respBean = RespBean.ok(termsDefined);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增语文术语定义")
    public RespBean add(@RequestBody TermsDefined termsDefined) throws Exception{
        logger.info("add terms Defined = " + JSONObject.toJSONString(termsDefined));
        Integer pkId = termsDefinedService.addTermsDefined(termsDefined);
        RespBean respBean ;
        if(pkId == null || pkId == 0){
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(pkId);
            respBean = RespBean.ok(idBean);
        }

        return respBean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "通过id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "术语id", required = true, dataType = "Integer")
    })
    public RespBean delTermsDefined(@RequestParam(required = false) Integer id) throws Exception{
        logger.info("del TermsDefined = " + id);
        if (id == null){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = termsDefinedService.deleteTermsDefinedById(id);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "通过id更新术语定义的信息")
    public RespBean updateInfo(@RequestBody TermsDefined termsDefined) throws Exception{
        logger.info("updateInfo  termsDefined = " + JSONObject.toJSONString(termsDefined));
        int res = termsDefinedService.updateTermsDefined(termsDefined);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "通过id更新术语定义的审核状态")
    public RespBean updateCheckState(@RequestBody String text) throws Exception{
        logger.info("termsDefined updateCheckState  text = " + text);
        JSONObject paramJson= JSONObject.parseObject(text);
        if (!paramJson.containsKey("id") || !paramJson.containsKey("state")){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = paramJson.getInteger("id");
        Integer state = paramJson.getInteger("state");
        if ( id == null|| state == null){
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = termsDefinedService.updateTermsDefinedCheckState(id, state);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
