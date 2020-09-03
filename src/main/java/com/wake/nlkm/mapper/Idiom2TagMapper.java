package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Idiom2Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Idiom2TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Idiom2Tag record);

    int insertSelective(Idiom2Tag record);

    Idiom2Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Idiom2Tag record);

    int updateByPrimaryKey(Idiom2Tag record);
}