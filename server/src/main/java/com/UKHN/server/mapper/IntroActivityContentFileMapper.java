package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.IntroActivityContentFile;
import com.UKHN_backend.server.domain.IntroActivityContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroActivityContentFileMapper {
    long countByExample(IntroActivityContentFileExample example);

    int deleteByExample(IntroActivityContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntroActivityContentFile record);

    int insertSelective(IntroActivityContentFile record);

    List<IntroActivityContentFile> selectByExample(IntroActivityContentFileExample example);

    IntroActivityContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntroActivityContentFile record, @Param("example") IntroActivityContentFileExample example);

    int updateByExample(@Param("record") IntroActivityContentFile record, @Param("example") IntroActivityContentFileExample example);

    int updateByPrimaryKeySelective(IntroActivityContentFile record);

    int updateByPrimaryKey(IntroActivityContentFile record);
}