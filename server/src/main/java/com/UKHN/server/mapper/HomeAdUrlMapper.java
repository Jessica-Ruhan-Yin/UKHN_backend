package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeAdUrl;
import com.UKHN_backend.server.domain.HomeAdUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeAdUrlMapper {
    long countByExample(HomeAdUrlExample example);

    int deleteByExample(HomeAdUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeAdUrl record);

    int insertSelective(HomeAdUrl record);

    List<HomeAdUrl> selectByExample(HomeAdUrlExample example);

    HomeAdUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeAdUrl record, @Param("example") HomeAdUrlExample example);

    int updateByExample(@Param("record") HomeAdUrl record, @Param("example") HomeAdUrlExample example);

    int updateByPrimaryKeySelective(HomeAdUrl record);

    int updateByPrimaryKey(HomeAdUrl record);
}