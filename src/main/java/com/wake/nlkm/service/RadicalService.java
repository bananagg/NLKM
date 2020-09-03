package com.wake.nlkm.service;

import com.wake.nlkm.entity.Radical;
import com.wake.nlkm.entity.Xiehouyu;
import com.wake.nlkm.utils.RespPageBean;

public interface RadicalService {
    /**
     * 批量查询部首及叫法
     *
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryRadicalByBatch(Integer page, Integer limit) throws Exception;

    /**
     * 查询指定部首
     *
     * @param radicalId
     * @return
     */
    Radical queryRadicalInfo(Integer radicalId) throws Exception;

    /**
     * 新增部首及叫法
     *
     * @param radicalInfo
     * @return
     */
    int addRadicalInfo(Radical radicalInfo) throws Exception;

    /**
     * 更新部首叫法
     *
     * @param radicalInfo
     * @return
     */
    int updateRadicalInfo(Radical radicalInfo) throws Exception;

    /**
     * 删除部首叫法
     *
     * @param radicalId
     * @return
     */
    int deleteRadicalById(Integer radicalId) throws Exception;

    /**
     * 更新部首叫法的审核状态
     *
     * @param radicalId
     * @param state
     * @return
     */
    int updateRadicalCheckState(Integer radicalId, Integer state) throws Exception;
}
