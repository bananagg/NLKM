package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.SimilarWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SimilarWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SimilarWord record);

    int insertSelective(SimilarWord record);

    SimilarWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SimilarWord record);

    int updateByPrimaryKey(SimilarWord record);
}