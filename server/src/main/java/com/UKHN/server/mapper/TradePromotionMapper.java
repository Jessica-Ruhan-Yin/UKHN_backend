package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePromotion;
import com.UKHN_backend.server.domain.TradePromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePromotionMapper {
    long countByExample(TradePromotionExample example);

    int deleteByExample(TradePromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePromotion record);

    int insertSelective(TradePromotion record);

    List<TradePromotion> selectByExample(TradePromotionExample example);

    TradePromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePromotion record, @Param("example") TradePromotionExample example);

    int updateByExample(@Param("record") TradePromotion record, @Param("example") TradePromotionExample example);

    int updateByPrimaryKeySelective(TradePromotion record);

    int updateByPrimaryKey(TradePromotion record);
}