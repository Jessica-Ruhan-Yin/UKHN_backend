package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeBusinessFile;
import com.UKHN_backend.server.domain.TradeBusinessFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeBusinessFileMapper {
    long countByExample(TradeBusinessFileExample example);

    int deleteByExample(TradeBusinessFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeBusinessFile record);

    int insertSelective(TradeBusinessFile record);

    List<TradeBusinessFile> selectByExample(TradeBusinessFileExample example);

    TradeBusinessFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeBusinessFile record, @Param("example") TradeBusinessFileExample example);

    int updateByExample(@Param("record") TradeBusinessFile record, @Param("example") TradeBusinessFileExample example);

    int updateByPrimaryKeySelective(TradeBusinessFile record);

    int updateByPrimaryKey(TradeBusinessFile record);
}