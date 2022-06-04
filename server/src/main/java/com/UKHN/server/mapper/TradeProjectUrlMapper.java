package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeProjectUrl;
import com.UKHN_backend.server.domain.TradeProjectUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProjectUrlMapper {
    long countByExample(TradeProjectUrlExample example);

    int deleteByExample(TradeProjectUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeProjectUrl record);

    int insertSelective(TradeProjectUrl record);

    List<TradeProjectUrl> selectByExample(TradeProjectUrlExample example);

    TradeProjectUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProjectUrl record, @Param("example") TradeProjectUrlExample example);

    int updateByExample(@Param("record") TradeProjectUrl record, @Param("example") TradeProjectUrlExample example);

    int updateByPrimaryKeySelective(TradeProjectUrl record);

    int updateByPrimaryKey(TradeProjectUrl record);
}