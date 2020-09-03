package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.entity.StateBean;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GoodSentenceService;
import com.wake.nlkm.service.GuwenWriterService;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.RespPageBean;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@ResponseBody
@RequestMapping("/api/v1/goodsentence")
@Slf4j
@Api(value = "优美语句Api文档", tags = {"优美语句操作接口"})
public class GoodSentenceController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GoodSentenceService goodSentenceService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询优美语句")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)", required = false, dataType = "Integer")
    })
    public RespBean getGuwenList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                 @RequestParam(name = "size", defaultValue = "20") Integer size) throws Exception {
        logger.info("get goodsentence List    page = " + page + "   size = " + size);
        RespPageBean respPageBean = goodSentenceService.queryGoodSentenceByBatch(page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询", notes = "根据id查询优美语句详情")
    public RespBean queryInfoById(@RequestParam Integer id) throws Exception {
        logger.info("query guwen writer InfoById wirter id = " + id);
        if (id == null) {
            throw new RequestParamIsEmptyException();
        }
        GoodSentence goodSentence = goodSentenceService.queryGoodSentenceInfo(id);
        RespBean respBean = RespBean.ok(goodSentence);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增优美语句")
    public RespBean add(@RequestBody GoodSentence sentenceInfo) throws Exception {
        logger.info("add good sentence = " + JSONObject.toJSONString(sentenceInfo));
        Integer pk_id = goodSentenceService.addGoodSentenceInfo(sentenceInfo);
        RespBean respBean;
        if (pk_id == null || pk_id == 0) {
            throw new FailException();
        } else {
            JSONObject data_json = new JSONObject();
            data_json.put("sentence_id", pk_id);
            respBean = RespBean.ok(data_json);
        }

        return respBean;
    }

    @RequestMapping(value = "/del/word", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据id删除优美语句")
    public RespBean delGoodSentence(@RequestParam Integer id) throws Exception {
        logger.info("del GoodSentence = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException();
        }
        int res = goodSentenceService.deleteGoodSentenceById(id);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新信息", notes = "根据id更新信息")
    public RespBean updateInfo(@RequestBody GoodSentence sentenceInfo) throws Exception {
        logger.info("updateInfo  sentenceInfo = " + JSONObject.toJSONString(sentenceInfo));
        int res = goodSentenceService.updateGoodSentenceInfo(sentenceInfo);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "根据id更新审核状态")
    public RespBean updateCheckState(@RequestBody StateBean stateBean) throws Exception {
        logger.info("goodSentence updateCheckState  text = " + JSONObject.toJSONString(stateBean));
        if (stateBean.getId() == null || stateBean.getState() == null) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = stateBean.getId();
        Integer state = stateBean.getState();
        if (id == null || state == null) {
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = goodSentenceService.updateGoodSentenceCheckState(id, state);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
