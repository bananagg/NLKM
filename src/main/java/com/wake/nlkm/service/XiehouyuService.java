package com.wake.nlkm.service;

import com.wake.nlkm.entity.GoodSentence;
import com.wake.nlkm.entity.Xiehouyu;
import com.wake.nlkm.utils.RespPageBean;

public interface XiehouyuService {
    /**
     * 批量查询歇后语
     *
     * @param text
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryXiehouyuByBatch(String text, Integer page, Integer limit) throws Exception;

    /**
     * 查询指定优美语句
     *
     * @param xiehouyuId
     * @return
     */
    Xiehouyu queryXiehouyuInfo(Integer xiehouyuId) throws Exception;

    /**
     * 新增优美语句
     *
     * @param xiehouyuInfo
     * @return
     */
    int addXiehouyuInfo(Xiehouyu xiehouyuInfo) throws Exception;

    /**
     * 更新优美语句信息
     *
     * @param xiehouyuInfo
     * @return
     */
    int updateXiehouyuInfo(Xiehouyu xiehouyuInfo) throws Exception;

    /**
     * 删除成语
     *
     * @param xiehouyuId
     * @return
     */
    int deleteXiehoyuById(Integer xiehouyuId) throws Exception;

    /**
     * 更新成语审核状态
     *
     * @param xiehouyuId
     * @param state
     * @return
     */
    int updateXiehouyuCheckState(Integer xiehouyuId, Integer state) throws Exception;
}
