package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Guwen;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface GuwenMapper {

    int selectCount(String title);

    List<Guwen> selectByBatch(String title, Integer offset, Integer limit);

    List<Guwen> selectBytitle(String title);

    int deleteByPrimaryKey(Integer id);

    int insert(Guwen record);

    int insertSelective(Guwen record);

    Guwen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guwen record);

    int updateByPrimaryKey(Guwen record);

    int updateCheckState(Integer id, Integer state, Date updatetime);

    int updateDelete(Integer id);
}