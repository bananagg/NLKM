package com.wake.nlkm.service;

import com.wake.nlkm.utils.RespPageBean;
import com.wake.nlkm.entity.Word;

public interface WordService {

    /**
     * 单字分页查询
     * @param word
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    RespPageBean queryWordByBatch(String word, Integer page, Integer limit) throws Exception;
    Word queryWordInfo(String word) throws Exception;

    /**
     * 通过id查询字详情
     * @param wordId
     * @return
     * @throws Exception
     */
    Word queryWordInfoById(Integer wordId) throws Exception;

    int addWordInfo(Word wordInfo) throws Exception;
    int updateWordInfo(Word wordInfo) throws Exception;
    int delectWord(Integer wordId) throws Exception;

    /**
     * 更新会意字状态
     * @param wordId
     * @param state
     * @return
     */
    int updateHuiyiziState(Integer wordId, Integer state) throws Exception;

    /**
     * 更新形声字状态
     * @param wordId
     * @param state
     * @return
     */
    int updateXingshengziState(Integer wordId, Integer state) throws Exception;

    /**
     * 更新生僻字状态
     * @param wordId
     * @param state
     * @return
     */
    int updateRateWordState(Integer wordId, Integer state) throws Exception;

    /**
     * 修改字的等级
     * @param wordId
     * @param leve
     * @return
     */
    int updateWordLevel(Integer wordId, Integer leve) throws Exception;

    /**
     * 更新字审核状态
     * @param wordId
     * @param state
     * @return
     * @throws Exception
     */
    int updateCheckState(Integer wordId, Integer state) throws Exception;
}
