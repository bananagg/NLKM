package com.wake.nlkm.service;

import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.entity.Idiom;
import com.wake.nlkm.utils.RespPageBean;

public interface GoodSentenceService {
    /**
     * 批量查询优美语句
     *
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryGoodSentenceByBatch(Integer page, Integer limit) throws Exception;

    /**
     * 查询指定优美语句
     *
     * @param goodSentenceId
     * @return
     */
    GoodSentence queryGoodSentenceInfo(Integer goodSentenceId) throws Exception;

    /**
     * 新增优美语句
     *
     * @param goodSentenceInfo
     * @return
     */
    int addGoodSentenceInfo(GoodSentence goodSentenceInfo) throws Exception;

    /**
     * 更新优美语句信息
     *
     * @param goodSentenceInfo
     * @return
     */
    int updateGoodSentenceInfo(GoodSentence goodSentenceInfo) throws Exception;

    /**
     * 删除成语
     *
     * @param goodSentenceId
     * @return
     */
    int deleteGoodSentenceById(Integer goodSentenceId) throws Exception;

    /**
     * 更新成语审核状态
     *
     * @param goodSentenceId
     * @param state
     * @return
     */
    int updateGoodSentenceCheckState(Integer goodSentenceId, Integer state) throws Exception;
}
