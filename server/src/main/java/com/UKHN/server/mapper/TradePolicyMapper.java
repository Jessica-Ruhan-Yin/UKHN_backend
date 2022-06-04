package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePolicy;
import com.UKHN_backend.server.domain.TradePolicyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePolicyMapper {
    long countByExample(TradePolicyExample example);

    int deleteByExample(TradePolicyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePolicy record);

    int insertSelective(TradePolicy record);

    List<TradePolicy> selectByExample(TradePolicyExample example);

    TradePolicy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePolicy record, @Param("example") TradePolicyExample example);

    int updateByExample(@Param("record") TradePolicy record, @Param("example") TradePolicyExample example);

    int updateByPrimaryKeySelective(TradePolicy record);

    int updateByPrimaryKey(TradePolicy record);
}