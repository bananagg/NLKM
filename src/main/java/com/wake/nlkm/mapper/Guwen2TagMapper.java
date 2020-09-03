package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Guwen2Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Guwen2TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guwen2Tag record);

    int insertSelective(Guwen2Tag record);

    Guwen2Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guwen2Tag record);

    int updateByPrimaryKey(Guwen2Tag record);
}