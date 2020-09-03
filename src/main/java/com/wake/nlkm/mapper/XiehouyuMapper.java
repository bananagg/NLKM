package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Xiehouyu;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface XiehouyuMapper {

    Integer selectCount(String text);

    List<Xiehouyu> selecetByBatch(String text, Integer offset, Integer limit);

    int deleteByPrimaryKey(Integer id);

    int insert(Xiehouyu record);

    int insertSelective(Xiehouyu record);

    Xiehouyu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiehouyu record);

    int updateByPrimaryKey(Xiehouyu record);

    int updateCheckState(Integer xiehouyuId, Integer state, Date updatetime);

    int updateDelete(Integer xiehouyuId, Integer state, Date updatetime);
}