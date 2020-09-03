package com.wake.nlkm.service;

import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.TermsDefined;
import com.wake.nlkm.utils.RespPageBean;

public interface TermsDefinedService {
    /**
     *  批量查询术语
     * @param name
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryTermsDefinedBatch(String name, Integer page, Integer limit) throws Exception;

    /**
     * 通过名字，查询指定术语详情
     * @param name
     * @return
     */
    RespPageBean queryTermsDefinedIByName(String name) throws Exception;
    /**
     * 通过ID， 查询指定术语定义详情
     * @param writerid
     * @return
     */
    TermsDefined queryTermsDefinedById(Integer writerid) throws Exception;

    /**
     * 新增术语定义
     * @param termsDefinedInfo
     * @return
     */
    int addTermsDefined(TermsDefined termsDefinedInfo) throws Exception;

    /**
     * 更新作家信息
     * @param termsDefinedInfo
     * @return
     */
    int updateTermsDefined(TermsDefined termsDefinedInfo) throws Exception;

    /**
     * 删除作家
     * @param termsDefinedId
     * @return
     */
    int deleteTermsDefinedById(Integer termsDefinedId) throws Exception;

    /**
     * 更新作家信息审核状态
     * @param termsDefinedId
     * @param state
     * @return
     */
    int updateTermsDefinedCheckState(Integer termsDefinedId, Integer state) throws Exception;
}
