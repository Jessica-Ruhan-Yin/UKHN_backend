package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeBusinessContent;
import com.UKHN_backend.server.domain.TradeBusinessContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeBusinessContentMapper {
    long countByExample(TradeBusinessContentExample example);

    int deleteByExample(TradeBusinessContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeBusinessContent record);

    int insertSelective(TradeBusinessContent record);

    List<TradeBusinessContent> selectByExampleWithBLOBs(TradeBusinessContentExample example);

    List<TradeBusinessContent> selectByExample(TradeBusinessContentExample example);

    TradeBusinessContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeBusinessContent record, @Param("example") TradeBusinessContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeBusinessContent record, @Param("example") TradeBusinessContentExample example);

    int updateByExample(@Param("record") TradeBusinessContent record, @Param("example") TradeBusinessContentExample example);

    int updateByPrimaryKeySelective(TradeBusinessContent record);

    int updateByPrimaryKeyWithBLOBs(TradeBusinessContent record);

    int updateByPrimaryKey(TradeBusinessContent record);
}