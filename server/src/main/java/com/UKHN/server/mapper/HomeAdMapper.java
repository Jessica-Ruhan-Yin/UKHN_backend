package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeAd;
import com.UKHN_backend.server.domain.HomeAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeAdMapper {
    long countByExample(HomeAdExample example);

    int deleteByExample(HomeAdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeAd record);

    int insertSelective(HomeAd record);

    List<HomeAd> selectByExample(HomeAdExample example);

    HomeAd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeAd record, @Param("example") HomeAdExample example);

    int updateByExample(@Param("record") HomeAd record, @Param("example") HomeAdExample example);

    int updateByPrimaryKeySelective(HomeAd record);

    int updateByPrimaryKey(HomeAd record);
}