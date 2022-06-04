package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeProjectContent;
import com.UKHN_backend.server.domain.TradeProjectContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProjectContentMapper {
    long countByExample(TradeProjectContentExample example);

    int deleteByExample(TradeProjectContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeProjectContent record);

    int insertSelective(TradeProjectContent record);

    List<TradeProjectContent> selectByExampleWithBLOBs(TradeProjectContentExample example);

    List<TradeProjectContent> selectByExample(TradeProjectContentExample example);

    TradeProjectContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProjectContent record, @Param("example") TradeProjectContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeProjectContent record, @Param("example") TradeProjectContentExample example);

    int updateByExample(@Param("record") TradeProjectContent record, @Param("example") TradeProjectContentExample example);

    int updateByPrimaryKeySelective(TradeProjectContent record);

    int updateByPrimaryKeyWithBLOBs(TradeProjectContent record);

    int updateByPrimaryKey(TradeProjectContent record);
}