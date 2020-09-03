package com.wake.nlkm.service;

import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.ModernWriter;
import com.wake.nlkm.utils.RespPageBean;

public interface GuwenWriterService {
    /**
     *  批量查询现代作家
     *
     * @param name
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryWriterBatch(String name, Integer page, Integer limit) throws Exception;

    /**
     * 通过名字，查询指定作家详情
     * @param name
     * @return
     */
    RespPageBean queryWriterInfoByName(String name) throws Exception;
    /**
     * 通过作家ID， 查询指定作家详情
     * @param writerid
     * @return
     */
    Author queryWriterInfoById(Integer writerid) throws Exception;

    /**
     * 新增作家及信息
     * @param writerInfo
     * @return
     */
    int addWriterInfo(Author writerInfo) throws Exception;

    /**
     * 更新作家信息
     * @param writerInfo
     * @return
     */
    int updateWriterInfo(Author writerInfo) throws Exception;

    /**
     * 删除作家
     * @param writerId
     * @return
     */
    int deleteWriterById(Integer writerId) throws Exception;

    /**
     * 更新作家信息审核状态
     * @param writerId
     * @return
     */
    int updateWriterCheckState(Integer writerId, Integer state) throws Exception;
}
