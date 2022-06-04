package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeAdContent;
import com.UKHN_backend.server.domain.HomeAdContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeAdContentMapper {
    long countByExample(HomeAdContentExample example);

    int deleteByExample(HomeAdContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeAdContent record);

    int insertSelective(HomeAdContent record);

    List<HomeAdContent> selectByExampleWithBLOBs(HomeAdContentExample example);

    List<HomeAdContent> selectByExample(HomeAdContentExample example);

    HomeAdContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeAdContent record, @Param("example") HomeAdContentExample example);

    int updateByExampleWithBLOBs(@Param("record") HomeAdContent record, @Param("example") HomeAdContentExample example);

    int updateByExample(@Param("record") HomeAdContent record, @Param("example") HomeAdContentExample example);

    int updateByPrimaryKeySelective(HomeAdContent record);

    int updateByPrimaryKeyWithBLOBs(HomeAdContent record);

    int updateByPrimaryKey(HomeAdContent record);
}