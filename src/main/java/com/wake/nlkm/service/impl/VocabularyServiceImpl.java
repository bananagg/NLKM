package com.wake.nlkm.service.impl;

import com.wake.nlkm.entity.Vocabulary;
import com.wake.nlkm.error.DataExitException;
import com.wake.nlkm.error.DataNotExitException;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.mapper.VocabularyMapper;
import com.wake.nlkm.service.VocabularyService;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Ganty
 * @Date 2020/8/19
 * @Des
 */
@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired
    VocabularyMapper vocabularyMapper;

    /**
     * 批量查询词汇
     *
     * @param word
     * @param page
     * @param limit
     * @return
     */
    @Override
    public RespPageBean queryVocabularyByBatch(String word, Integer page, Integer limit) throws Exception {
        Integer total = vocabularyMapper.selectCount(word);
        Integer offset = page * limit -limit;
        List<Vocabulary> vocabularyList = vocabularyMapper.selecetByOffset(word, offset, limit);
        RespPageBean respPageBean = new RespPageBean(vocabularyList);
        respPageBean.setProperty(total, page, limit);
        return respPageBean;
    }

    /**
     * 查询制定词汇详情
     *
     * @param word
     * @return
     */
    @Override
    public Vocabulary queryVocabularyInfo(String word) throws Exception {
        Vocabulary vocabularyInfo = vocabularyMapper.selectByWord(word);
        return vocabularyInfo;
    }

    /**
     * 更具id查询词汇
     *
     * @param id
     * @return
     */
    @Override
    public Vocabulary queryVocabularyInfoById(Integer id) throws Exception {
        Vocabulary vocabularyInfo = vocabularyMapper.selectByPrimaryKey(id);
        return vocabularyInfo;
    }

    /**
     * 新增词汇
     *
     * @param vocabularyInfo
     * @return
     */
    @Override
    public int addVocabularyInfo(Vocabulary vocabularyInfo) throws Exception{
        int flag ;
        Vocabulary vocabularytmp = vocabularyMapper.selectByWord(vocabularyInfo.getWord());
        if(vocabularytmp == null){
            flag = vocabularyMapper.insertSelective(vocabularyInfo);
            if(flag != Constant.UPDATEOK){
                throw new FailException("新增词汇失败");
            }
        } else {
            throw new DataExitException();
        }
        return vocabularyInfo.getId();
    }

    /**
     * 更新词汇信息
     *
     * @param vocabularyInfo
     * @return
     */
    @Override
    public int updateVocabularyInfo(Vocabulary vocabularyInfo) throws Exception{
        Vocabulary vocabularytmp = vocabularyMapper.selectByWord(vocabularyInfo.getWord());
        int flag = 0;
        if(vocabularytmp != null){
            flag = vocabularyMapper.updateByPrimaryKeySelective(vocabularyInfo);
            if(flag != Constant.UPDATEOK){
                throw new FailException("更新词汇信息失败");
            }
        } else {
            throw new DataNotExitException();
        }

        return flag;
    }

    /**
     * 删除词汇
     *
     * @param vocabularyName
     * @return
     */
    @Override
    public int deleteVocabulary(String vocabularyName) {
//        vocabularyMapper.
        return 0;
    }

    /**
     * 更新词汇审核状态
     *
     * @param vocabularyName
     * @param state
     * @return
     */
    @Override
    public int updateVocabularyCheckState(String vocabularyName, Integer state) throws Exception{
        int flag;
        Vocabulary vocabulary = vocabularyMapper.selectByWord(vocabularyName);
        if(vocabulary != null){
            Date updatetime = new Date();
            flag = vocabularyMapper.updateCheckState(vocabularyName, state, updatetime);
            if(flag != Constant.UPDATEOK){
                throw new FailException("词汇审核状态更新失败");
            }
        } else
            throw new DataNotExitException();
        return flag;
    }

    /**
     * 更新词汇审核状态
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public int updateVocabularyCheckStateById(Integer id, Integer state) throws Exception {
        int flag = vocabularyMapper.updateCheckStateById(id,state, new Date());
        return flag;
    }

    /**
     * 更新词汇等级
     * @param vocabularyName
     * @param level
     * @return
     */
    @Override
    public int updateVocabularyLevel(String vocabularyName, String level) throws Exception{
        int flag;
        Vocabulary vocabulary = vocabularyMapper.selectByWord(vocabularyName);
        if(vocabulary != null){
            Date updatetime = new Date();
            flag = vocabularyMapper.updateLevel(vocabularyName, level, updatetime);
            if(flag != Constant.UPDATEOK){
                throw new FailException("词汇等级更新失败");
            }
        } else
            throw new DataNotExitException();
        return flag;
    }

    /**
     * 更新词汇等级
     *
     * @param vocabularyId
     * @param level
     * @return
     */
    @Override
    public int updateVocabularyLevelById(Integer vocabularyId, Integer level) throws Exception {
        int flag;
        Vocabulary vocabulary = vocabularyMapper.selectByPrimaryKey(vocabularyId);
        if(vocabulary != null){
            String levelStr = "其他";
            switch (level){
                case 1:{
                    levelStr = "甲";
                    break;
                }
                case 2: {
                    levelStr = "乙";
                    break;
                }
                case 3:{
                    levelStr = "丙";
                    break;
                }
                case 4: {
                    levelStr = "丁";
                    break;
                }
            }
            Date updatetime = new Date();
            flag = vocabularyMapper.updateLevelById(vocabularyId, levelStr, updatetime);
            if(flag != Constant.UPDATEOK){
                throw new FailException("词汇等级更新失败");
            }
        } else
            throw new DataNotExitException();
        return flag;
    }

    /**
     * 删除词汇
     *
     * @param id
     * @return
     */
    @Override
    public int deleteVocabulary(Integer id) {
        int flag = vocabularyMapper.updateDelete(id, Constant.DELETEFLAG, new Date());
        return flag;
    }
}
