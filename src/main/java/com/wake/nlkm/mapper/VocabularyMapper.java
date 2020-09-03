package com.wake.nlkm.mapper;

import com.wake.nlkm.entity.Vocabulary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.Date;
import java.util.List;

@Mapper
public interface VocabularyMapper {

    Integer selectCount(String word);

    List<Vocabulary> selecetByOffset(String word, Integer offset, Integer limit);

    Vocabulary selectByWord(String word);

    int deleteByPrimaryKey(Integer id);

    int insert(Vocabulary record);

    int insertSelective(Vocabulary record);

    Vocabulary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vocabulary record);

    int updateByPrimaryKey(Vocabulary record);

    int updateCheckState(String word, Integer state, Date updatetime);

    int updateCheckStateById(Integer id, Integer state, Date updatetime);

    int updateLevel(String word, String level, Date updatetime);

    int updateLevelById(Integer id, String level, Date updatetime);

    int updateDelete(Integer id, Integer state, Date updatetime);
}