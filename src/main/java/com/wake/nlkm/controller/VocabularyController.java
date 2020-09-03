package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.wake.nlkm.entity.*;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.VocabularyService;
import com.wake.nlkm.service.WordService;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.RespPageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.plaf.nimbus.State;

@RestController
@RequestMapping("/api/v1/vocabulary")
@Api(value = "词汇api文档", tags = "词汇操作接口")
public class VocabularyController {

    Logger logger = LoggerFactory.getLogger(VocabularyController.class);

    @Resource
    VocabularyService vocabularyService;


    @RequestMapping(value = "/get_list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询词汇")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "需要查询的词汇", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)", required = false, dataType = "Integer")
    })
    public RespBean getList(@RequestParam(defaultValue = "") String word,
                            @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "20") Integer size) throws Exception {
        logger.info("get list  page = "+ page+"。size = " + size);
        RespPageBean respPageBean = vocabularyService.queryVocabularyByBatch(word, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);

        return respBean;
    }

    @RequestMapping(value = "/getByname", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据 word")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "词语", required = false, dataType = "String"),
    })
    public RespBean query(@RequestParam String word) throws Exception {
        logger.info("query word = " + word);
        if (word.equals("")) {
            throw new RequestParamIsEmptyException();
        }
        Vocabulary vocabulary = vocabularyService.queryVocabularyInfo(word);
        RespBean respBean = RespBean.ok(vocabulary);
        return respBean;
    }
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @RequestMapping(value = "/getByid", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据 id 查词汇")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "词语 id", required = false, dataType = "Integer"),
    })
    public RespBean queryById(@RequestParam Integer id) throws Exception {
        logger.info("query word  id = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException();
        }
        Vocabulary vocabulary = vocabularyService.queryVocabularyInfoById(id);
        RespBean respBean = RespBean.ok(vocabulary);
        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增词汇")
    public RespBean addVocabulary(@RequestBody Vocabulary vocabulary) throws Exception {
        logger.info("add text:"+ JSONObject.toJSONString(vocabulary));
        RespBean respBean;
        if (vocabulary.getWord().equals("")) {
            throw new RequestParamIsEmptyException();
        }
        int pkId = vocabularyService.addVocabularyInfo(vocabulary);
        if (pkId != 0) {
            IdBean idBean = new IdBean(pkId);
            respBean = RespBean.ok(pkId);
        } else {
            respBean = RespBean.error("新增词汇失败");
        }
        return respBean;
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新词汇")
    public RespBean updateVocabularyInfo(@RequestBody Vocabulary vocabulary) throws Exception {
        RespBean respBean;
        if (vocabulary.getWord().equals("") || vocabulary.getId() == null) {
            throw new RequestParamIsEmptyException("必要参数为空");
        }
        int flag = vocabularyService.updateVocabularyInfo(vocabulary);
        if (flag != 0) {
            respBean = RespBean.ok();
        } else {
            respBean = RespBean.error("更新词汇失败");
        }
        return respBean;
    }

    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "更新审核状态")
    public RespBean updateVocabularyState(@RequestBody StateBean stateBean) throws Exception {
        RespBean respBean;
        if (stateBean.getId() == null || stateBean.getState() == null) {
            throw new RequestParamIsEmptyException("必要参数为空");
        }
        int flag = vocabularyService.updateVocabularyCheckStateById(stateBean.getId(), stateBean.getState());
        if (flag != 0) {
            respBean = RespBean.ok();
        } else {
            respBean = RespBean.error("更新词汇审核状态失败");
        }
        return respBean;
    }

    @RequestMapping(value = "/updateLevel", method = RequestMethod.POST)
    @ApiOperation(value = "更新词汇级别", notes = "更新词汇级别")
    public RespBean updateVocabularyLevel(@RequestBody LevelBean levelBean) throws Exception {
        RespBean respBean;
        if (levelBean.getId() == null || levelBean.getLevel() == null) {
            throw new RequestParamIsEmptyException("必要参数为空");
        }
        int flag = vocabularyService.updateVocabularyLevelById(levelBean.getId(), levelBean.getLevel());
        if (flag != 0) {
            respBean = RespBean.ok();
        } else {
            respBean = RespBean.error("更新词汇等级失败");
        }
        return respBean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除词汇", notes = "根据id删除词汇")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "词汇id", required = false, dataType = "Integer")
    })
    public RespBean delVocabulary(@RequestParam Integer id) throws Exception {
        RespBean respBean;
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException("必要参数为空");
        }
        int flag = vocabularyService.deleteVocabulary(id);
        if (flag != 0) {
            respBean = RespBean.ok();
        } else {
            respBean = RespBean.error("删除词汇等级失败");
        }
        return respBean;
    }


}
