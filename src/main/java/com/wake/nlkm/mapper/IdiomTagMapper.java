package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.IdiomTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdiomTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdiomTag record);

    int insertSelective(IdiomTag record);

    IdiomTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IdiomTag record);

    int updateByPrimaryKey(IdiomTag record);
}