package com.wake.nlkm.service;

import com.wake.nlkm.entity.Guwen;
import com.wake.nlkm.utils.RespPageBean;

public interface GuwenService {
    /**
     *  批量查询古文
     *
     * @param title
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryGuwenByBatch(String title, Integer page, Integer limit) throws Exception;

    /**
     * 通过古文id查询古文详情
     * @param guwenId
     * @return
     * @throws Exception
     */
    Guwen queryGuwenById(Integer guwenId) throws Exception;

    /**
     * 通过标题查询古文
     * @param title
     * @return
     */
    RespPageBean queryGuwenInfoByTitle(String title) throws Exception;

    /**
     * 新增古文
     * @param guwenInfo
     * @return
     */
    int addGuwenInfo(Guwen guwenInfo) throws Exception;

    /**
     * 更新古文信息
     * @param guwenInfo
     * @return
     */
    int updateGuwenInfo(Guwen guwenInfo) throws Exception;

    /**
     * 删除古文
     * @param guwenId
     * @return
     */
    int deleteGuwen(Integer guwenId) throws Exception;

    /**
     * 更新古文审核状态
     * @param id
     * @param state
     * @return
     */
    int updateGuwenCheckState(Integer id, Integer state) throws Exception;
}
