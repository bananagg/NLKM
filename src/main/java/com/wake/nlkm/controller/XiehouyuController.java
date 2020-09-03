package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.StateBean;
import com.wake.nlkm.entity.Xiehouyu;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.GoodSentenceService;
import com.wake.nlkm.service.XiehouyuService;
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
@RequestMapping("/api/v1/xiehouyu")
@Slf4j
@Api(value = "歇后语Api文档", tags = "歇后语Api接口")
public class XiehouyuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private XiehouyuService xiehouyuService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "分页查询歇后语")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "text", value = "歇后语的上句或下句", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数（默认：1）", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度（默认：20）", required = false, dataType = "Integer")
    })
    public RespBean getXiehouyuList(@RequestParam(defaultValue = "") String text,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "20") Integer size) throws Exception{
        logger.info("分页查询歇后语 page = "+ page + "   size = " + size);

        RespPageBean respPageBean = xiehouyuService.queryXiehouyuByBatch(text, page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "指定查询", notes = "根据id查询歇后语信息")
    public RespBean queryInfoById(@RequestParam Integer id) throws Exception{
        logger.info("通过id 查找歇后语。 id = " + id);
        if (id == null){
            throw new RequestParamIsEmptyException();
        }
        Xiehouyu xiehouyu = xiehouyuService.queryXiehouyuInfo(id);
        RespBean respBean = RespBean.ok(xiehouyu);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增歇后语")
    public RespBean add(@RequestBody Xiehouyu sentenceInfo) throws Exception{
        logger.info("新增 歇后语 = " + JSONObject.toJSONString(sentenceInfo));
        Integer pkId = xiehouyuService.addXiehouyuInfo(sentenceInfo);
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
    @ApiOperation(value = "删除", notes = "根据id删除歇后语")
    public RespBean delGoodSentence(@RequestParam Integer id) throws Exception{
        logger.info("删除 歇后语 id = " + id);
        if (id == null || id == 0){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = xiehouyuService.deleteXiehoyuById(id);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    public RespBean updateInfo(@RequestBody Xiehouyu xiehouyu) throws Exception{
        logger.info("更新歇后语信息 = " + JSONObject.toJSONString(xiehouyu));
        int res = xiehouyuService.updateXiehouyuInfo(xiehouyu);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    @ApiOperation(value = "更新审核状态", notes = "更新审核状态")
    public RespBean updateCheckState(@RequestBody StateBean stateBean) throws Exception{
        logger.info("更新歇后语审核状态  text = " + JSONObject.toJSONString(stateBean));
        if (stateBean.getId() == null || stateBean.getState() == null){
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        Integer id = stateBean.getId();
        Integer state = stateBean.getState();
        if ( id == null|| state == null){
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = xiehouyuService.updateXiehouyuCheckState(id, state);
        RespBean respBean ;
        if(res == 0){
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

}
