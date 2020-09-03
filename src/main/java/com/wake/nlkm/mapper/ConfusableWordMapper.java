package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.ConfusableWord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfusableWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfusableWord record);

    int insertSelective(ConfusableWord record);

    ConfusableWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfusableWord record);

    int updateByPrimaryKey(ConfusableWord record);
}