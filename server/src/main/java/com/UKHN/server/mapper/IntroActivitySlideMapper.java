package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.IntroActivitySlide;
import com.UKHN_backend.server.domain.IntroActivitySlideExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroActivitySlideMapper {
    long countByExample(IntroActivitySlideExample example);

    int deleteByExample(IntroActivitySlideExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntroActivitySlide record);

    int insertSelective(IntroActivitySlide record);

    List<IntroActivitySlide> selectByExample(IntroActivitySlideExample example);

    IntroActivitySlide selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntroActivitySlide record, @Param("example") IntroActivitySlideExample example);

    int updateByExample(@Param("record") IntroActivitySlide record, @Param("example") IntroActivitySlideExample example);

    int updateByPrimaryKeySelective(IntroActivitySlide record);

    int updateByPrimaryKey(IntroActivitySlide record);
}