package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Radical;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface RadicalMapper {

    Integer selectCount();

    List<Radical> selectByBatch(Integer offset, Integer limit);

    int deleteByPrimaryKey(Integer id);

    int insert(Radical record);

    int insertSelective(Radical record);

    Radical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Radical record);

    int updateByPrimaryKey(Radical record);

    int updateCheckState(Integer id, Integer state, Date updatetime);

    int updateDelete(Integer id, Integer state, Date updatetime);
}