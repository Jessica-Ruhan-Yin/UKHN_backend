package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeNewsUrl;
import com.UKHN_backend.server.domain.HomeNewsUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeNewsUrlMapper {
    long countByExample(HomeNewsUrlExample example);

    int deleteByExample(HomeNewsUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeNewsUrl record);

    int insertSelective(HomeNewsUrl record);

    List<HomeNewsUrl> selectByExample(HomeNewsUrlExample example);

    HomeNewsUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeNewsUrl record, @Param("example") HomeNewsUrlExample example);

    int updateByExample(@Param("record") HomeNewsUrl record, @Param("example") HomeNewsUrlExample example);

    int updateByPrimaryKeySelective(HomeNewsUrl record);

    int updateByPrimaryKey(HomeNewsUrl record);
}