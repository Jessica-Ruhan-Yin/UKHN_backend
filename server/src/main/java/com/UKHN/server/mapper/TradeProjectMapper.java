package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeProject;
import com.UKHN_backend.server.domain.TradeProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProjectMapper {
    long countByExample(TradeProjectExample example);

    int deleteByExample(TradeProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeProject record);

    int insertSelective(TradeProject record);

    List<TradeProject> selectByExample(TradeProjectExample example);

    TradeProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProject record, @Param("example") TradeProjectExample example);

    int updateByExample(@Param("record") TradeProject record, @Param("example") TradeProjectExample example);

    int updateByPrimaryKeySelective(TradeProject record);

    int updateByPrimaryKey(TradeProject record);
}