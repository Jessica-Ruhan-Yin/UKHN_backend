package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeNewsContent;
import com.UKHN_backend.server.domain.HomeNewsContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeNewsContentMapper {
    long countByExample(HomeNewsContentExample example);

    int deleteByExample(HomeNewsContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeNewsContent record);

    int insertSelective(HomeNewsContent record);

    List<HomeNewsContent> selectByExampleWithBLOBs(HomeNewsContentExample example);

    List<HomeNewsContent> selectByExample(HomeNewsContentExample example);

    HomeNewsContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeNewsContent record, @Param("example") HomeNewsContentExample example);

    int updateByExampleWithBLOBs(@Param("record") HomeNewsContent record, @Param("example") HomeNewsContentExample example);

    int updateByExample(@Param("record") HomeNewsContent record, @Param("example") HomeNewsContentExample example);

    int updateByPrimaryKeySelective(HomeNewsContent record);

    int updateByPrimaryKeyWithBLOBs(HomeNewsContent record);

    int updateByPrimaryKey(HomeNewsContent record);
}