package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.IntroActivityContent;
import com.UKHN_backend.server.domain.IntroActivityContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroActivityContentMapper {
    long countByExample(IntroActivityContentExample example);

    int deleteByExample(IntroActivityContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntroActivityContent record);

    int insertSelective(IntroActivityContent record);

    List<IntroActivityContent> selectByExampleWithBLOBs(IntroActivityContentExample example);

    List<IntroActivityContent> selectByExample(IntroActivityContentExample example);

    IntroActivityContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntroActivityContent record, @Param("example") IntroActivityContentExample example);

    int updateByExampleWithBLOBs(@Param("record") IntroActivityContent record, @Param("example") IntroActivityContentExample example);

    int updateByExample(@Param("record") IntroActivityContent record, @Param("example") IntroActivityContentExample example);

    int updateByPrimaryKeySelective(IntroActivityContent record);

    int updateByPrimaryKeyWithBLOBs(IntroActivityContent record);

    int updateByPrimaryKey(IntroActivityContent record);
}