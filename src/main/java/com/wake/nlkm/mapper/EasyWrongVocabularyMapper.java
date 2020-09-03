package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.EasyWrongVocabulary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EasyWrongVocabularyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EasyWrongVocabulary record);

    int insertSelective(EasyWrongVocabulary record);

    EasyWrongVocabulary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasyWrongVocabulary record);

    int updateByPrimaryKey(EasyWrongVocabulary record);
}