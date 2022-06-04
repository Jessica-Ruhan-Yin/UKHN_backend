package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.IntroEnroll;
import com.UKHN_backend.server.domain.IntroEnrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroEnrollMapper {
    long countByExample(IntroEnrollExample example);

    int deleteByExample(IntroEnrollExample example);

    int deleteByPrimaryKey(String id);

    int insert(IntroEnroll record);

    int insertSelective(IntroEnroll record);

    List<IntroEnroll> selectByExample(IntroEnrollExample example);

    IntroEnroll selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IntroEnroll record, @Param("example") IntroEnrollExample example);

    int updateByExample(@Param("record") IntroEnroll record, @Param("example") IntroEnrollExample example);

    int updateByPrimaryKeySelective(IntroEnroll record);

    int updateByPrimaryKey(IntroEnroll record);
}