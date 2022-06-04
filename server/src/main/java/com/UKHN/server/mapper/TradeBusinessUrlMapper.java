package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeBusinessUrl;
import com.UKHN_backend.server.domain.TradeBusinessUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeBusinessUrlMapper {
    long countByExample(TradeBusinessUrlExample example);

    int deleteByExample(TradeBusinessUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeBusinessUrl record);

    int insertSelective(TradeBusinessUrl record);

    List<TradeBusinessUrl> selectByExample(TradeBusinessUrlExample example);

    TradeBusinessUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeBusinessUrl record, @Param("example") TradeBusinessUrlExample example);

    int updateByExample(@Param("record") TradeBusinessUrl record, @Param("example") TradeBusinessUrlExample example);

    int updateByPrimaryKeySelective(TradeBusinessUrl record);

    int updateByPrimaryKey(TradeBusinessUrl record);
}