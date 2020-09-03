package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Idiom;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface IdiomMapper {

    Integer selecetCount(String word);

    List<Idiom> selectByBatch(String word, Integer offset, Integer limit);

    Idiom selectByWord(String word);

    int deleteByPrimaryKey(Integer id);

    int deleteByWord(String word);

    int insert(Idiom record);

    int insertSelective(Idiom record);

    Idiom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Idiom record);

    int updateByPrimaryKey(Idiom record);

    int updataByWord(Idiom idiom);

    int updateCheckState(String word, Integer state, Date updatetime);
}