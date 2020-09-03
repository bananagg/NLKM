package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.GoodSentenceMapper;
import com.wake.nlkm.service.GoodSentenceService;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/24
 * @Des
 */

@Service
public class GoodSentenceServiceImpl implements GoodSentenceService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodSentenceMapper goodSentenceMapper;

    /**
     * 批量查询优美语句
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryGoodSentenceByBatch(Integer page, Integer limit) throws Exception {
        Integer total = goodSentenceMapper.selectCount();
        Integer offset = 0;
        if(page > 0) {
            offset = (page-1) * limit;
        }
        List<GoodSentence> goodSentenceList = goodSentenceMapper.selectByBatch(offset, limit);
        Integer totalPage = (int)Math.ceil(total/limit);
        RespPageBean respPageBean = new RespPageBean(page, total, limit, totalPage, goodSentenceList);

        return respPageBean;
    }

    /**
     * 查询指定优美语句
     *
     * @param goodSentenceId
     * @return
     */
    @Override
    public GoodSentence queryGoodSentenceInfo(Integer goodSentenceId) throws Exception {

        GoodSentence goodSentence = goodSentenceMapper.selectByPrimaryKey(goodSentenceId);

        return goodSentence;
    }

    /**
     * 新增优美语句
     *
     * @param goodSentenceInfo
     * @return
     */
    @Override
    public int addGoodSentenceInfo(GoodSentence goodSentenceInfo) throws Exception {

        if (goodSentenceInfo.getCreatetime() == null) {
            Date time = new Date();
            goodSentenceInfo.setCreatetime(time);
            goodSentenceInfo.setCreatetime(time);
        }
        int flag = goodSentenceMapper.insert(goodSentenceInfo);
        if (flag == 0 || goodSentenceInfo.getId() == null || goodSentenceInfo.getId() == 0) {
            throw new FailException("失败");
        }

        return goodSentenceInfo.getId();
    }

    /**
     * 更新优美语句信息
     *
     * @param goodSentenceInfo
     * @return
     */
    @Override
    public int updateGoodSentenceInfo(GoodSentence goodSentenceInfo) throws Exception {
        int flag = goodSentenceMapper.updateByPrimaryKey(goodSentenceInfo);
        if (flag == 0) {
            throw new FailException("优美语句更新失败");
        }

        return flag;
    }

    /**
     * 删除成语
     *
     * @param goodSentenceId
     * @return
     */
    @Override
    public int deleteGoodSentenceById(Integer goodSentenceId) throws Exception {
        int flag = goodSentenceMapper.updateDelete(goodSentenceId, Constant.DELETEFLAG, new Date());
        return flag;
    }

    /**
     * 更新成语审核状态
     *
     * @param goodSentenceId
     * @param state
     * @return
     */
    @Override
    public int updateGoodSentenceCheckState(Integer goodSentenceId, Integer state) throws Exception {
        int flag = goodSentenceMapper.updateCheckState(goodSentenceId, state, new Date());

        return flag;
    }
}
