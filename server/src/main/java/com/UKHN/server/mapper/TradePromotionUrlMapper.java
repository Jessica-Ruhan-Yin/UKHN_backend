package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePromotionUrl;
import com.UKHN_backend.server.domain.TradePromotionUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePromotionUrlMapper {
    long countByExample(TradePromotionUrlExample example);

    int deleteByExample(TradePromotionUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePromotionUrl record);

    int insertSelective(TradePromotionUrl record);

    List<TradePromotionUrl> selectByExample(TradePromotionUrlExample example);

    TradePromotionUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePromotionUrl record, @Param("example") TradePromotionUrlExample example);

    int updateByExample(@Param("record") TradePromotionUrl record, @Param("example") TradePromotionUrlExample example);

    int updateByPrimaryKeySelective(TradePromotionUrl record);

    int updateByPrimaryKey(TradePromotionUrl record);
}