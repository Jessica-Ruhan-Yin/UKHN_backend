package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeNews;
import com.UKHN_backend.server.domain.HomeNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeNewsMapper {
    long countByExample(HomeNewsExample example);

    int deleteByExample(HomeNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeNews record);

    int insertSelective(HomeNews record);

    List<HomeNews> selectByExample(HomeNewsExample example);

    HomeNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeNews record, @Param("example") HomeNewsExample example);

    int updateByExample(@Param("record") HomeNews record, @Param("example") HomeNewsExample example);

    int updateByPrimaryKeySelective(HomeNews record);

    int updateByPrimaryKey(HomeNews record);
}