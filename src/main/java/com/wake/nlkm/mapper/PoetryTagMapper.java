package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.PoetryTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoetryTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoetryTag record);

    int insertSelective(PoetryTag record);

    PoetryTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoetryTag record);

    int updateByPrimaryKey(PoetryTag record);
}