package com.wake.nlkm.service.impl;

import com.wake.nlkm.error.DataExitException;
import com.wake.nlkm.error.DataNotExitException;
import com.wake.nlkm.error.FailException;
import com.wake.nlkm.utils.Constant;
import com.wake.nlkm.utils.RespPageBean;
import com.wake.nlkm.entity.Word;
import com.wake.nlkm.mapper.WordMapper;
import com.wake.nlkm.service.WordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Resource
    WordMapper wordMapper;

    @Override
    public RespPageBean queryWordByBatch(String word, Integer page, Integer limit) {
        Integer total = wordMapper.queryWordCount(word);
        Integer offset = limit * page - limit;
        List<Word> wordList = wordMapper.queryWordByBatch(word, offset, limit);
        RespPageBean respPageBean = new RespPageBean(wordList);
        respPageBean.setProperty(total, page, limit);

        return respPageBean;
    }

    @Override
    public Word queryWordInfo(String wordname) throws Exception {
        Word wordInfo = wordMapper.queryWordByWordname(wordname);
        if (wordInfo == null) {
            throw new DataNotExitException();
        }
        return wordInfo;
    }

    /**
     * 通过id查询字详情
     *
     * @param wordId
     * @return
     * @throws Exception
     */
    @Override
    public Word queryWordInfoById(Integer wordId) throws Exception {
        Word wordInfo = wordMapper.queryWordByWordId(wordId);

        return wordInfo;
    }

    @Override
    public int updateWordInfo(Word wordInfo) throws Exception {
        Word wordtmp = wordMapper.queryWordByWordname(wordInfo.getWord());
        int flag = 0;
        if (wordtmp != null) {
            flag = wordMapper.updateWordInfo(wordInfo);
        } else {
            throw new DataExitException();
        }
        return flag;
    }


    @Override
    @Transactional
    public int addWordInfo(Word wordInfo) throws Exception {
        Word wordInfotmp = wordMapper.queryWordByWordname(wordInfo.getWord());
        int flag = 0;
        if (wordInfotmp == null) {
            wordInfo.setCreatetime(new Date());
            wordInfo.setUpdatetime(new Date());
            flag = wordMapper.addWrodInfo(wordInfo);
            if (flag == 0) {
                throw new FailException("新增数据失败");
            }
        } else {
            throw new DataExitException();
        }
        return wordInfo.getId();
    }

    /**
     * 删除字
     * @param wordId
     * @return
     * @throws Exception
     */
    @Override
    public int delectWord(Integer wordId) throws Exception {
        Word wordInfo = wordMapper.queryWordByWordId(wordId);
        int flag;
        if (wordInfo != null) {
            flag = wordMapper.updateWordDelete(wordId, Constant.DELETEFLAG, new Date());
        } else {
            throw new DataNotExitException();
        }
        return flag;
    }

    /**
     * 更新会意字状态
     *
     * @param wordId
     * @param state
     * @return
     */
    @Override
    public int updateHuiyiziState(Integer wordId, Integer state) throws Exception {
        int flag = 0;
        Word wordtmp = wordMapper.queryWordByWordId(wordId);
        if (wordtmp != null) {
            Date updatetime = new Date();
            flag = wordMapper.updateHuiyiziStateByWordName(wordId, state, updatetime);
        } else {
            throw new DataExitException();
        }
        return flag;
    }

    /**
     * 更新形声字状态
     *
     * @param wordId
     * @param state
     * @return
     */
    @Override
    public int updateXingshengziState(Integer wordId, Integer state) throws DataExitException {
        int flag = 0;
        Word wordtmp = wordMapper.queryWordByWordId(wordId);
        if (wordtmp != null) {
            Date updatetime = new Date();
            flag = wordMapper.updateXingshengziStateByWordName(wordId, state, updatetime);
        } else {
            throw new DataExitException();
        }
        return flag;
    }

    /**
     * 更新生僻字状态
     *
     * @param wordId
     * @param state
     * @return
     */
    @Override
    public int updateRateWordState(Integer wordId, Integer state) {
        int flag = 0;
        Word wordtmp = wordMapper.queryWordByWordId(wordId);
        if (wordtmp != null) {
            Date updatetime = new Date();
            flag = wordMapper.updateRateWordStateByWordName(wordId, state, updatetime);
        }
        return flag;
    }

    /**
     * 修改字的等级
     *
     * @param wordId
     * @param leve
     * @return
     */
    @Override
    public int updateWordLevel(Integer wordId, Integer leve) {
        int flag = 0;
        Word wordtmp = wordMapper.queryWordByWordId(wordId);
        if (wordtmp != null) {
            Date updatetime = new Date();
            flag = wordMapper.updateWordLevelStateByWordName(wordId, leve, updatetime);
        }
        return flag;
    }

    /**
     * 更新字审核状态
     *
     * @param wordId
     * @param state
     * @return
     * @throws Exception
     */
    @Override
    public int updateCheckState(Integer wordId, Integer state) throws Exception {
        Word wordInfo = wordMapper.queryWordByWordId(wordId);
        int flag;
        if (wordInfo != null) {
            flag = wordMapper.updateWordCheckState(wordId, state, new Date());
        } else {
            throw new DataNotExitException();
        }
        return flag;
    }

    public Integer boolean2int(Boolean state) {
        Integer myInt = state ? 1 : 0;
        return myInt;
    }
}
