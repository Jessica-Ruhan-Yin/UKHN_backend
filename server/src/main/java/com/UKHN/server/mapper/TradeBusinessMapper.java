package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeBusiness;
import com.UKHN_backend.server.domain.TradeBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeBusinessMapper {
    long countByExample(TradeBusinessExample example);

    int deleteByExample(TradeBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeBusiness record);

    int insertSelective(TradeBusiness record);

    List<TradeBusiness> selectByExample(TradeBusinessExample example);

    TradeBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeBusiness record, @Param("example") TradeBusinessExample example);

    int updateByExample(@Param("record") TradeBusiness record, @Param("example") TradeBusinessExample example);

    int updateByPrimaryKeySelective(TradeBusiness record);

    int updateByPrimaryKey(TradeBusiness record);
}