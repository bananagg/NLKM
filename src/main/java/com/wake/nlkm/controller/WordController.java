package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.StateBean;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.RespPageBean;
import com.wake.nlkm.entity.Word;
import com.wake.nlkm.service.WordService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@Api(value="单字 controller",tags={"单字操作接口"})
@RequestMapping("/api/v1/word")
public class WordController {

    Logger logger = LoggerFactory.getLogger(WordController.class);

    @Resource
    WordService wordService;


    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询字列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "词汇", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页码(默认1)", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "长度(默认20)", dataType = "Integer")
    })
    public RespBean getWord(@RequestParam(defaultValue = "") String word,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "20") Integer size) throws Exception{
        logger.info("get Word list 。 word = " + word+"  page = "+ page + " ;size = "+ size);
        RespPageBean respPageBean = wordService.queryWordByBatch(word, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/infobyname", method = RequestMethod.GET)
    @ApiOperation(value = "根据字查询", notes = "根据字查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "待查询的字", dataType = "String"),
    })
    public RespBean query(@RequestParam String word) throws Exception{
        if (word == null || word.equals("")){
            throw new RequestParamIsEmptyException();
        }
        Word wordRes = wordService.queryWordInfo(word);
        RespBean respBean = RespBean.ok(wordRes);

        return respBean;
    }

    @RequestMapping(value = "/get/infobyid", method = RequestMethod.GET)
    @ApiOperation(value = "根据字查询", notes = "根据字id查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "wordId", value = "待查询的字id", dataType = "Integer"),
    })
    public RespBean query(@RequestParam Integer wordId) throws Exception{
        if (wordId == null){
            throw new RequestParamIsEmptyException();
        }
        Word wordRes = wordService.queryWordInfoById(wordId);
        RespBean respBean = RespBean.ok(wordRes);

        return respBean;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增字对象")
    public RespBean add(@RequestBody @ApiParam(required = true)  Word word) throws Exception{

        int pkId = wordService.addWordInfo(word);
        RespBean respBean ;
        if(pkId == 0){
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(pkId);
            respBean = RespBean.ok(idBean);
        }

        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "修改", notes = "修改字内容信息")
    public RespBean updateInfo(@RequestBody @ApiParam(name = "字对象",value = "传入json对象", required = true) Word word) throws Exception{

        int res = wordService.updateWordInfo(word);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }



    @RequestMapping(value = "/update/huiyizi", method = RequestMethod.POST)
    @ApiOperation(value = "修改会意字标记", notes = "修改会意字标记")
    public RespBean updateHuiyizi(@RequestBody @ApiParam(name = "状态更新对象",value = "传入json对象", required = true)
                                              StateBean stateBean) throws Exception{
        if (stateBean.getId() == null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException();
        }
        int res = wordService.updateHuiyiziState(stateBean.getId(), stateBean.getState());
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/xingshengzi", method = RequestMethod.POST)
    @ApiOperation(value = "修改形声字标记", notes = "修改形声字标记")
    public RespBean updateXingshengzi(@RequestBody @ApiParam(name = "状态更新对象",value = "传入json对象", required = true) StateBean stateBean) throws Exception{
        if (stateBean.getId() == null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException();
        }
        int res = wordService.updateXingshengziState(stateBean.getId(), stateBean.getState());
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/rate", method = RequestMethod.POST)
    @ApiOperation(value = "修改生僻字标记", notes = "修改生僻字标记")
    public RespBean updateRate(@RequestBody @ApiParam(name = "状态更新对象",value = "传入json对象", required = true) StateBean stateBean) throws Exception{
        if (stateBean.getId() == null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException();
        }
        int res = wordService.updateRateWordState(stateBean.getId(), stateBean.getState());
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }


    @RequestMapping(value = "/update/level", method = RequestMethod.POST)
    @ApiOperation(value = "修改字级别", notes = "修改字级别")
    public RespBean updateLeve(@RequestBody @ApiParam(name = "状态更新对象",value = "传入json对象", required = true) StateBean stateBean) throws Exception{
        if (stateBean.getId() == null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException();
        }
        int res = wordService.updateWordLevel(stateBean.getId(), stateBean.getState());
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @ApiOperation(value = "删除", notes = "根据id删除字")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "字id", dataType = "Integer"),
    })
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public RespBean deleteWord(@RequestParam Integer id) throws Exception{
        int res = wordService.delectWord(id);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
