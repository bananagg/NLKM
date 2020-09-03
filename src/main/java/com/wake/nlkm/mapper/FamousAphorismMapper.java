package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.FamousAphorism;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamousAphorismMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FamousAphorism record);

    int insertSelective(FamousAphorism record);

    FamousAphorism selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FamousAphorism record);

    int updateByPrimaryKey(FamousAphorism record);
}