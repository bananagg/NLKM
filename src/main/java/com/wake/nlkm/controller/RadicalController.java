package com.wake.nlkm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.entity.IdBean;
import com.wake.nlkm.entity.Radical;
import com.wake.nlkm.entity.StateBean;
import com.wake.nlkm.entity.Xiehouyu;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.error.RequestParamIsEmptyException;
import com.wake.nlkm.service.RadicalService;
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
@RequestMapping("/api/v1/radical")
@Slf4j
@Api(value = "偏旁说法Api文档", tags = "偏旁说法操作接口")
public class RadicalController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RadicalService radicalService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "分页查询偏旁说法")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数（默认：1）", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "查询长度（默认：20）", required = false, dataType = "Integer")
    })
    public RespBean getRadicalList(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "20") Integer size) throws Exception {
        logger.info("查询偏旁叫法 page = " + page + "   size = " + size);
        RespPageBean respPageBean = radicalService.queryRadicalByBatch(page, size);
        RespBean respBean = RespBean.ok("sucess", respPageBean);
        return respBean;
    }

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "查询", notes = "根据id查询偏旁信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "偏旁id", required = false, dataType = "Integer"),
    })
    public RespBean queryInfoById(@RequestParam Integer id) throws Exception {
        logger.info("通过id 查找偏旁叫法 id = " + id);
        if (id == null) {
            throw new RequestParamIsEmptyException();
        }
        Radical radical = radicalService.queryRadicalInfo(id);
        RespBean respBean = RespBean.ok(radical);

        return respBean;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "新增偏旁说法")
    public RespBean add(@RequestBody Radical radicalInfo) throws Exception {
        logger.info("新增 部首叫法 = " + JSONObject.toJSONString(radicalInfo));
        Integer pkId = radicalService.addRadicalInfo(radicalInfo);
        RespBean respBean;
        if (pkId == null || pkId == 0) {
            throw new FailException();
        } else {
            IdBean idBean = new IdBean(pkId);
            respBean = RespBean.ok(idBean);
        }

        return respBean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据id 删除")
    public RespBean delGoodSentence(@RequestParam Integer id) throws Exception {
        logger.info("删除 部首叫法 id = " + id);
        if (id == null || id == 0) {
            throw new RequestParamIsEmptyException("缺少必要参数");
        }
        int res = radicalService.deleteRadicalById(id);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "根据id，更新部首信息")
    public RespBean updateInfo(@RequestBody Radical radical) throws Exception {
        logger.info("更新部首叫法 = " + JSONObject.toJSONString(radical));
        int res = radicalService.updateRadicalInfo(radical);
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }

        return respBean;
    }

    @RequestMapping(value = "/update/checkstate", method = RequestMethod.POST)
    public RespBean updateCheckState(@RequestBody StateBean stateBean) throws Exception {
        logger.info("更新部首审核状态  text = " + JSONObject.toJSONString(stateBean));

        if (stateBean.getId() == null || stateBean.getState() == null) {
            throw new RequestParamIsEmptyException("参数值为空");
        }
        int res = radicalService.updateRadicalCheckState(stateBean.getId(), stateBean.getState());
        RespBean respBean;
        if (res == 0) {
            throw new FailException();
        } else {
            respBean = RespBean.ok();
        }
        return respBean;
    }

}
