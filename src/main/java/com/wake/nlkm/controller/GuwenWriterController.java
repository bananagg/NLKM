package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.ModernWriter;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GuwenService;
import com.wake.nlkm.service.GuwenWriterService;
import com.wake.nlkm.service.ModernWriterService;
import com.wake.nlkm.utils.RespBean;
import com.wake.nlkm.utils.RespPageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@ResponseBody
@RequestMapping("/api/v1/guwenwriter")
@Slf4j
@Api(value = "古文作家Api文档", tags = {"古文作家操作"})
public class GuwenWriterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private GuwenWriterService guwenWriterService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询古文作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "古文作家", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)", required = false, dataType = "int")
    })
    public RespBean getGuwenList(@RequestParam(defaultValue = "") String name,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "20") Integer size) throws Exception {
//        List<Word> wordList = wordService.queryWordByBatch(page,size);
        logger.info("get guwenWriterList    page = " + page + "   size = " + size);
        RespPageBean respPageBean = guwenWriterService.queryWriterBatch(name, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据id指定查询古文作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "作家id", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoById(@RequestParam Integer id) throws Exception {
        logger.info("query guwen writer InfoById wirter id = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException();
        }
        Author modernWriter = guwenWriterService.queryWriterInfoById(id);
        RespBean respBean = RespBean.ok(modernWriter);

        return respBean;
    }

    @RequestMapping(value = "/get/info/byname", method = RequestMethod.GET)
    @ApiOperation(value = "名称查询", notes = "根据名称查询古文作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "作家名字", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoByTitle(@RequestParam String name) throws Exception {
        logger.info("query Info Byname  modern writer name = " + name);
        if (name == null || name.equals("")) {
            throw new RequestParamIsEmptyException();
        }
        RespPageBean idiomRes = guwenWriterService.queryWriterInfoByName(name);
        RespBean respBean = RespBean.ok(idiomRes);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增作家信息")
    public RespBean add(@RequestBody Author writerInfo) throws Exception {
        logger.info("add guwen writer = " + JSONObject.toJSONString(writerInfo));
        int res = guwenWriterService.addWriterInfo(writerInfo);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(res);
            respBean = RespBean.ok(idBean);
        }

        return respBean;
    }

    @RequestMapping(value = "/del/word", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据id删除作者")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "作者id", required = true, dataType = "Integer"),
    })
    public RespBean delWriter(@RequestParam Integer id
    ) throws Exception {
        logger.info("del id = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = guwenWriterService.deleteWriterById(id);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新作家信息")
    public RespBean updateInfo(@RequestBody Author writerInfo) throws Exception {
        logger.info("updateInfo  guwen = " + JSONObject.toJSONString(writerInfo));
        if (writerInfo.getId() == null || writerInfo.getId() == 0) {
            throw new RequestParamIsEmptyException("作者id为空");
        }
        int res = guwenWriterService.updateWriterInfo(writerInfo);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "更新审核状态")
    public RespBean updateCheckState(@RequestBody String text) throws Exception {
        logger.info("guwen writer updateCheckState  text = " + text);
        JSONObject paramJson = JSONObject.parseObject(text);
        if (!paramJson.containsKey("id") || !paramJson.containsKey("state")) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = paramJson.getInteger("id");
        Integer state = paramJson.getInteger("state");
        if (id == null || state == null) {
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = guwenWriterService.updateWriterCheckState(id, state);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
