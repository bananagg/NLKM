package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.Idiom;
import com.wake.nlkm.entity.Word;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.mapper.IdiomMapper;
import com.wake.nlkm.service.IdiomService;
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

@RestController
@ResponseBody
@RequestMapping("/api/v1/idiom")
@Api(value = "成语Api文档", tags = {"成语操作接口"})
public class IdiomController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    IdiomService idiomService;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询优美语句")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "成语", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)", required = false, dataType = "Integer")
    })
    public RespBean getIdiomList(@RequestParam(defaultValue = "") String word,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "20") Integer size) throws Exception{
        logger.info("getIdiomList  page = "+ page + "   size = " + size);

        RespPageBean respPageBean = idiomService.queryIdiomByBatch(word,page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "根据成语查询成语详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "word", value = "成语", required = true, dataType = "string"),
    })
    public RespBean getByWord(@RequestParam(required = false) String word) throws Exception{
        logger.info("getByWord  word = " + word);
        if (word == null || word.equals("")){
            throw new RequestParamIsEmptyException();
        }
        Idiom idiomRes = idiomService.queryIdiomInfo(word);
        RespBean respBean = RespBean.ok(idiomRes);

        return respBean;
    }

    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "根据id查询成语详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "成语id", required = true, dataType = "Integer"),
    })
    public RespBean getByWordById(@RequestParam(required = false) Integer id) throws Exception{
        logger.info("getByWord  word id = " + id);
        if (id == null || id == 0){
            throw new RequestParamIsEmptyException();
        }
        Idiom idiomRes = idiomService.queryIdiomById(id);
        RespBean respBean = RespBean.ok(idiomRes);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增成语" )
    public RespBean addIdiom(@RequestBody Idiom idiom) throws Exception{
        logger.info("addIdiom = " + JSONObject.toJSONString(idiom));
        int pk_id = idiomService.addIdiomInfo(idiom);
        RespBean respBean ;
        if(pk_id == 0){
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(pk_id);
            respBean = RespBean.ok(idBean);
        }
        return respBean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "成语id", required = true, dataType = "Integer"),
    })
    public RespBean delIdiom(@RequestParam(name = "id") Integer id) throws Exception{
        logger.info("delIdiom id = " + id);
        if (id == null || id == 0){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = idiomService.deleteIdiomById(id);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "根据id更新成语信息")
    public RespBean updateInfo(@RequestBody Idiom idiom) throws Exception{
        logger.info("updateInfo  idiom = " + JSONObject.toJSONString(idiom));
        int res = idiomService.updateIdiomInfo(idiom);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "根据id更新审核状态")
    public RespBean updateCheckState(@RequestBody String text) throws Exception{
        logger.info("updateCheckState  text = " + text);
        JSONObject paramJson= JSONObject.parseObject(text);
        if (!paramJson.containsKey("word") || !paramJson.containsKey("state")){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        String word = paramJson.getString("word");
        Integer state = paramJson.getInteger("state");
        if ( word.equals("")|| state == null){
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = idiomService.updateIdiomCheckState(word, state);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
