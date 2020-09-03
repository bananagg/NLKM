package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.ModernWriter;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ModernWriterMapper {

    Integer selectCount(String name);

    List<ModernWriter> selectByBatch(String name, Integer offset, Integer limit);

    List<ModernWriter> selectByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(ModernWriter record);

    int insertSelective(ModernWriter record);

    ModernWriter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModernWriter record);

    int updateByPrimaryKey(ModernWriter record);

    int updateCheckState(Integer writerId, Integer state, Date updatetime);

    int updateDelete(Integer writerId, Integer state, Date updatetime);
}