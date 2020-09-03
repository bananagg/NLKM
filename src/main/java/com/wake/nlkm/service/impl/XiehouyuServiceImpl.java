package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Xiehouyu;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.XiehouyuMapper;
import com.wake.nlkm.service.XiehouyuService;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/26
 * @Des
 */

@Service
public class XiehouyuServiceImpl implements XiehouyuService {

    @Autowired
    private XiehouyuMapper xiehouyuMapper;

    /**
     * 批量查询歇后语
     * @param text
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryXiehouyuByBatch(String text , Integer page, Integer limit) throws Exception {
        Integer total = xiehouyuMapper.selectCount(text);
        Integer offset = page * limit - limit;
        List<Xiehouyu> xiehouyus = xiehouyuMapper.selecetByBatch(text, offset, limit);
        RespPageBean respPageBean = new RespPageBean(xiehouyus);
        respPageBean.setProperty(total, page, limit);
        return respPageBean;
    }

    /**
     * 查询指定优美语句
     *
     * @param xiehouyuId
     * @return
     */
    @Override
    public Xiehouyu queryXiehouyuInfo(Integer xiehouyuId) throws Exception {

        return xiehouyuMapper.selectByPrimaryKey(xiehouyuId);
    }

    /**
     * 新增优美语句
     *
     * @param xiehouyuInfo
     * @return
     */
    @Override
    public int addXiehouyuInfo(Xiehouyu xiehouyuInfo) throws Exception {
        int flag = xiehouyuMapper.insertSelective(xiehouyuInfo);
        if (flag == 0){
            throw new FailException("新增歇后语失败");
        }
        return xiehouyuInfo.getId();
    }

    /**
     * 更新优美语句信息
     *
     * @param xiehouyuInfo
     * @return
     */
    @Override
    public int updateXiehouyuInfo(Xiehouyu xiehouyuInfo) throws Exception {
        int flag = xiehouyuMapper.updateByPrimaryKeySelective(xiehouyuInfo);

        return flag;
    }

    /**
     * 删除成语
     *
     * @param xiehouyuId
     * @return
     */
    @Override
    public int deleteXiehoyuById(Integer xiehouyuId) throws Exception {
        int flag = xiehouyuMapper.updateDelete(xiehouyuId, Constant.DELETEFLAG, new Date());
        return flag;
    }

    /**
     * 更新成语审核状态
     *
     * @param xiehouyuId
     * @param state
     * @return
     */
    @Override
    public int updateXiehouyuCheckState(Integer xiehouyuId, Integer state) throws Exception {
        int flag = xiehouyuMapper.updateCheckState(xiehouyuId, state, new Date());
        return flag;
    }
}
