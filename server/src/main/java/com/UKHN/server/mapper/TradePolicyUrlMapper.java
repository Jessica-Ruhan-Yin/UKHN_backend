package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePolicyUrl;
import com.UKHN_backend.server.domain.TradePolicyUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePolicyUrlMapper {
    long countByExample(TradePolicyUrlExample example);

    int deleteByExample(TradePolicyUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePolicyUrl record);

    int insertSelective(TradePolicyUrl record);

    List<TradePolicyUrl> selectByExample(TradePolicyUrlExample example);

    TradePolicyUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePolicyUrl record, @Param("example") TradePolicyUrlExample example);

    int updateByExample(@Param("record") TradePolicyUrl record, @Param("example") TradePolicyUrlExample example);

    int updateByPrimaryKeySelective(TradePolicyUrl record);

    int updateByPrimaryKey(TradePolicyUrl record);
}