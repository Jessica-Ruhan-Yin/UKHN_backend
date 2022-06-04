package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePromotionContent;
import com.UKHN_backend.server.domain.TradePromotionContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePromotionContentMapper {
    long countByExample(TradePromotionContentExample example);

    int deleteByExample(TradePromotionContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePromotionContent record);

    int insertSelective(TradePromotionContent record);

    List<TradePromotionContent> selectByExampleWithBLOBs(TradePromotionContentExample example);

    List<TradePromotionContent> selectByExample(TradePromotionContentExample example);

    TradePromotionContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePromotionContent record, @Param("example") TradePromotionContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TradePromotionContent record, @Param("example") TradePromotionContentExample example);

    int updateByExample(@Param("record") TradePromotionContent record, @Param("example") TradePromotionContentExample example);

    int updateByPrimaryKeySelective(TradePromotionContent record);

    int updateByPrimaryKeyWithBLOBs(TradePromotionContent record);

    int updateByPrimaryKey(TradePromotionContent record);
}