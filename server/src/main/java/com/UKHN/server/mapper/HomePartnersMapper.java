package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomePartners;
import com.UKHN_backend.server.domain.HomePartnersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomePartnersMapper {
    long countByExample(HomePartnersExample example);

    int deleteByExample(HomePartnersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomePartners record);

    int insertSelective(HomePartners record);

    List<HomePartners> selectByExample(HomePartnersExample example);

    HomePartners selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomePartners record, @Param("example") HomePartnersExample example);

    int updateByExample(@Param("record") HomePartners record, @Param("example") HomePartnersExample example);

    int updateByPrimaryKeySelective(HomePartners record);

    int updateByPrimaryKey(HomePartners record);
}