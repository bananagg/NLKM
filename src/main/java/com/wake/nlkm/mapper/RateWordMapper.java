package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.RateWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RateWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RateWord record);

    int insertSelective(RateWord record);

    RateWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RateWord record);

    int updateByPrimaryKey(RateWord record);
}