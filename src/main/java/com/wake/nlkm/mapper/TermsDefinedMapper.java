package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.TermsDefined;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface TermsDefinedMapper {

    Integer selectCount(String name);

    List<TermsDefined> selectByBatch(String name, Integer offset, Integer limit);

    List<TermsDefined> selectByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(TermsDefined record);

    int insertSelective(TermsDefined record);

    TermsDefined selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TermsDefined record);

    int updateByPrimaryKey(TermsDefined record);

    int updateCheckState(Integer id, Integer state, Date updatetime);

    int updateDelete(Integer id, Integer state, Date updatetime);


}