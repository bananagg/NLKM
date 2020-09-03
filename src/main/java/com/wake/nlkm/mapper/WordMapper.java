package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface WordMapper {

    Integer queryWordCount(String word);

    List<Word> queryWordByBatch(String word, Integer offset,Integer limit);

    Word queryWordByWordname(String wordname);

    Word queryWordByWordId(Integer id);

    int addWrodInfo(Word wordInfo);
    int updateWordInfo(Word wordInfo);

    int updateHuiyiziStateByWordName(Integer wordId, Integer state, Date updatetime);
    int updateXingshengziStateByWordName(Integer wordId, Integer state, Date updatetime);
    int updateRateWordStateByWordName(Integer wordId, Integer state, Date updatetime);
    int updateWordLevelStateByWordName(Integer wordId, Integer level, Date updatetime);

    int updateWordCheckState(Integer id, Integer state, Date updatetime);

    int updateWordDelete(Integer id, Integer state, Date updatetime);
}
