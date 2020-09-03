package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.Guwen;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.Idiom;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GuwenService;
import com.wake.nlkm.service.IdiomService;
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
@RequestMapping("/api/v1/guwen")
@Slf4j
@Api(value = "古文管理Api文档", tags = "古文操作接口")
public class GuwenController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    GuwenService guwenService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询古文")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "title", value = "诗词标题", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)",  dataType = "int")
    })
    public RespBean getGuwenList(@RequestParam(defaultValue = "") String title,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "20") Integer size) throws Exception {
//        List<Word> wordList = wordService.queryWordByBatch(page,size);
        logger.info("getGuwenList  title = " + title+ "  page = " + page + "   size = " + size);
        RespPageBean respPageBean = guwenService.queryGuwenByBatch(title, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据id查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "古文id", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoById(@RequestParam(required = false) Integer id) throws Exception {
        logger.info("queryInfoById  guwen id = " + id);
        if (id == null) {
            throw new RequestParamIsEmptyException();
        }
        Guwen guwen = guwenService.queryGuwenById(id);
        RespBean respBean = RespBean.ok(guwen);

        return respBean;
    }

    @RequestMapping(value = "/get/info/bytitle", method = RequestMethod.GET)
    @ApiOperation(value = "模糊查询", notes = "根据输入模糊查询")
    public RespBean queryInfoByTitle(@RequestParam String title) throws Exception {
        logger.info("queryInfoById  guwen title = " + title);
        if (title == null || title.equals("")) {
            throw new RequestParamIsEmptyException();
        }
        RespPageBean idiomRes = guwenService.queryGuwenInfoByTitle(title);
        RespBean respBean = RespBean.ok(idiomRes);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增")
    public RespBean add(@RequestBody Guwen guwenInfo) throws Exception {
        logger.info("add guwen = " + JSONObject.toJSONString(guwenInfo));
        int res = guwenService.addGuwenInfo(guwenInfo);
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
    @ApiOperation(value = "删除", notes = "根据id 删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "id", required = true, dataType = "Integer")
    })
    public RespBean delword(@RequestParam(required = false) Integer id) throws Exception {
        logger.info("id = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = guwenService.deleteGuwen(id);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "根据id 更新")
    public RespBean updateInfo(@RequestBody Guwen guwen) throws Exception {
        logger.info("updateInfo  guwen = " + JSONObject.toJSONString(guwen));
        int res = guwenService.updateGuwenInfo(guwen);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新审核状态")
    public RespBean updateCheckState(@RequestBody String text) throws Exception {
        logger.info("guwen updateCheckState  text = " + text);
        JSONObject paramJson = JSONObject.parseObject(text);
        if (!paramJson.containsKey("id") || !paramJson.containsKey("state")) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = paramJson.getInteger("id");
        Integer state = paramJson.getInteger("state");
        if (id == null || state == null) {
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = guwenService.updateGuwenCheckState(id, state);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
