package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradeProjectFile;
import com.UKHN_backend.server.domain.TradeProjectFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProjectFileMapper {
    long countByExample(TradeProjectFileExample example);

    int deleteByExample(TradeProjectFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeProjectFile record);

    int insertSelective(TradeProjectFile record);

    List<TradeProjectFile> selectByExample(TradeProjectFileExample example);

    TradeProjectFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProjectFile record, @Param("example") TradeProjectFileExample example);

    int updateByExample(@Param("record") TradeProjectFile record, @Param("example") TradeProjectFileExample example);

    int updateByPrimaryKeySelective(TradeProjectFile record);

    int updateByPrimaryKey(TradeProjectFile record);
}