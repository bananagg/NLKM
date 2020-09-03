package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.GoodSentence;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface GoodSentenceMapper {

    Integer selectCount();

    List<GoodSentence> selectByBatch(Integer offset, Integer limit);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodSentence record);

    int insertSelective(GoodSentence record);

    GoodSentence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodSentence record);

    int updateByPrimaryKey(GoodSentence record);

    int updateCheckState(Integer id, Integer state, Date updatetime);

    int updateDelete(Integer id, Integer state, Date updatetime);
}