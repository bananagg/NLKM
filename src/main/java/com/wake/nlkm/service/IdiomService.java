package com.wake.nlkm.service;

import com.wake.nlkm.entity.Idiom;
import com.wake.nlkm.utils.RespPageBean;

public interface IdiomService {
    /**
     *  批量查询成语
     *
     * @param word
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryIdiomByBatch(String word, Integer page, Integer limit) throws Exception;

    /**
     * 查询指定成语详情
     * @param word
     * @return
     */
    Idiom queryIdiomInfo(String word) throws Exception;

    /**
     * 根据id查询成语信息
     * @param Id
     * @return
     * @throws Exception
     */
    Idiom queryIdiomById(Integer Id) throws Exception;

    /**
     * 新增成语
     * @param idiomInfo
     * @return
     */
    int addIdiomInfo(Idiom idiomInfo) throws Exception;

    /**
     * 更新成语信息
     * @param idiomInfo
     * @return
     */
    int updateIdiomInfo(Idiom idiomInfo) throws Exception;

    /**
     * 删除成语
     * @param idiomName
     * @return
     */
    int deleteIdiom(String idiomName) throws Exception;

    /**
     * 删除成语
     * @param id
     * @return
     */
    int deleteIdiomById(Integer id) throws Exception;

    /**
     * 更新成语审核状态
     * @param word
     * @param state
     * @return
     */
    int updateIdiomCheckState(String word, Integer state) throws Exception;
}
