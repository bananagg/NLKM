package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.Guwen;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.ModernWriter;
import com.wake.nlkm.entity.StateBean;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GuwenService;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@ResponseBody
@RequestMapping("/api/v1/modernwriter")
@Slf4j
@Api(value = "现代作家Api文档", tags = "现代作家操作接口")
public class ModernWriterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ModernWriterService modernWriterService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询现在作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "作家名字", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数(默认1)", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度(默认20)", required = false, dataType = "Integer")
    })
    public RespBean getModerWriterList(@RequestParam(defaultValue = "") String name,
                                       @RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "20") Integer size) throws Exception{
        logger.info("getModerWriterList    page = "+ page + "   size = " + size);
        RespPageBean respPageBean = modernWriterService.queryWriterBatch(name, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据id查询现代作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "作家id", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoById(@RequestParam(required = false) Integer id) throws Exception{
        logger.info("queryInfoById  guwen id = " + id);
        if (id == null){
            throw new RequestParamIsEmptyException();
        }
        ModernWriter modernWriter = modernWriterService.queryWriterInfoById(id);
        RespBean respBean = RespBean.ok(modernWriter);

        return respBean;
    }

    @RequestMapping(value = "/get/info/bytitle", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询现在作家")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "名字", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoByName(@RequestParam() String name) throws Exception{
        logger.info("queryInfoByname  modern writer name = " + name);
        if (name == null || name.equals("")){
            throw new RequestParamIsEmptyException();
        }
        RespPageBean idiomRes = modernWriterService.queryWriterInfoByName(name);
        RespBean respBean = RespBean.ok(idiomRes);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增现代作家")
    public RespBean add(@RequestBody ModernWriter writerInfo) throws Exception{
        logger.info("add moder writer = " + JSONObject.toJSONString(writerInfo));
        int pkId = modernWriterService.addWriterInfo(writerInfo);
        RespBean respBean ;
        if(pkId == 0){
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(pkId);
            respBean = RespBean.ok(idBean);
        }

        return respBean;
    }

    @RequestMapping(value = "/del/word", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据id删除现代作家")
    public RespBean delWriter(@RequestParam Integer id) throws Exception{
        if (id == null || id == 0){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = modernWriterService.deleteWriterById(id);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "根据id更新作者信息")
    public RespBean updateInfo(@RequestBody ModernWriter writerInfo) throws Exception{
        logger.info("updateInfo  guwen = " + JSONObject.toJSONString(writerInfo));
        int res = modernWriterService.updateWriterInfo(writerInfo);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "根据id 更新审核状态")
    public RespBean updateCheckState(@RequestBody StateBean stateBean) throws Exception{
        logger.info("modern writer updateCheckState  text = " + JSONObject.toJSONString(stateBean));
        if (stateBean.getId()==null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = stateBean.getId();
        Integer state = stateBean.getState();
        if ( id == null|| state == null){
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = modernWriterService.updateWriterCheckState(id, state);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

}
