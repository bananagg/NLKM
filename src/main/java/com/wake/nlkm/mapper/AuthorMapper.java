package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Author;
import com.wake.nlkm.entity.ModernWriter;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface AuthorMapper {

    Integer selectCount(String name);

    List<Author> selectByBatch(String name, Integer offset, Integer limit);

    List<Author> selectByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    int updateCheckState(Integer id, Integer state, Date updatetime);

    int updateDelete(Integer id, Integer state, Date updatetime);
}