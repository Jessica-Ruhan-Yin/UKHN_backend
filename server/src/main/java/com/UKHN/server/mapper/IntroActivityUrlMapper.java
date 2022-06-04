package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.IntroActivityUrl;
import com.UKHN_backend.server.domain.IntroActivityUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroActivityUrlMapper {
    long countByExample(IntroActivityUrlExample example);

    int deleteByExample(IntroActivityUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntroActivityUrl record);

    int insertSelective(IntroActivityUrl record);

    List<IntroActivityUrl> selectByExample(IntroActivityUrlExample example);

    IntroActivityUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntroActivityUrl record, @Param("example") IntroActivityUrlExample example);

    int updateByExample(@Param("record") IntroActivityUrl record, @Param("example") IntroActivityUrlExample example);

    int updateByPrimaryKeySelective(IntroActivityUrl record);

    int updateByPrimaryKey(IntroActivityUrl record);
}