package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Poetry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoetryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poetry record);

    int insertSelective(Poetry record);

    Poetry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poetry record);

    int updateByPrimaryKey(Poetry record);
}