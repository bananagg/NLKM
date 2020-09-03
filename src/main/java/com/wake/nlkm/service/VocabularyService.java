package com.wake.nlkm.service;

import com.wake.nlkm.entity.Vocabulary;
import com.wake.nlkm.utils.RespPageBean;

public interface VocabularyService {
    /**
     *  批量查询词汇
     * @param name
     * @param page
     * @param limit
     * @return
     */
    RespPageBean queryVocabularyByBatch(String name, Integer page, Integer limit) throws Exception;

    /**
     * 查询制定词汇详情
     * @param word
     * @return
     */
    Vocabulary queryVocabularyInfo(String word) throws Exception;

    /**
     * 更具id查询词汇
     * @param id
     * @return
     */
    Vocabulary queryVocabularyInfoById(Integer id) throws Exception;
    /**
     * 新增词汇
     * @param vocabularyInfo
     * @return
     */
    int addVocabularyInfo(Vocabulary vocabularyInfo) throws Exception;

    /**
     * 更新词汇信息
     * @param vocabularyInfo
     * @return
     */
    int updateVocabularyInfo(Vocabulary vocabularyInfo) throws Exception;

    /**
     * 删除词汇
     * @param vocabularyName
     * @return
     */
    int deleteVocabulary(String vocabularyName) throws Exception;

    /**
     * 更新词汇审核状态
     * @param vocabularyName
     * @param state
     * @return
     */
    int updateVocabularyCheckState(String vocabularyName, Integer state) throws Exception;

    /**
     * 更新词汇审核状态
     * @param id
     * @param state
     * @return
     */
    int updateVocabularyCheckStateById(Integer id, Integer state) throws Exception;


    /**
     * 更新词汇等级
     * @param vocabularyName
     * @param level
     * @return
     */
    int updateVocabularyLevel(String vocabularyName, String level) throws Exception;

    /**
     * 更新词汇等级
     * @param vocabularyId
     * @param level
     * @return
     */
    int updateVocabularyLevelById(Integer vocabularyId, Integer level) throws Exception;

    /**
     * 删除词汇
     * @param id
     * @return
     */
    int deleteVocabulary(Integer id);

}
