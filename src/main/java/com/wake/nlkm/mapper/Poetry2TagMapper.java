package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Poetry2Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Poetry2TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poetry2Tag record);

    int insertSelective(Poetry2Tag record);

    Poetry2Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poetry2Tag record);

    int updateByPrimaryKey(Poetry2Tag record);
}