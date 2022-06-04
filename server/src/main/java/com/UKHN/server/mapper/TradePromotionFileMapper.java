package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePromotionFile;
import com.UKHN_backend.server.domain.TradePromotionFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePromotionFileMapper {
    long countByExample(TradePromotionFileExample example);

    int deleteByExample(TradePromotionFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePromotionFile record);

    int insertSelective(TradePromotionFile record);

    List<TradePromotionFile> selectByExample(TradePromotionFileExample example);

    TradePromotionFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePromotionFile record, @Param("example") TradePromotionFileExample example);

    int updateByExample(@Param("record") TradePromotionFile record, @Param("example") TradePromotionFileExample example);

    int updateByPrimaryKeySelective(TradePromotionFile record);

    int updateByPrimaryKey(TradePromotionFile record);
}