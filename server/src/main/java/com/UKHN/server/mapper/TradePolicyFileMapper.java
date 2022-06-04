package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePolicyFile;
import com.UKHN_backend.server.domain.TradePolicyFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePolicyFileMapper {
    long countByExample(TradePolicyFileExample example);

    int deleteByExample(TradePolicyFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePolicyFile record);

    int insertSelective(TradePolicyFile record);

    List<TradePolicyFile> selectByExample(TradePolicyFileExample example);

    TradePolicyFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePolicyFile record, @Param("example") TradePolicyFileExample example);

    int updateByExample(@Param("record") TradePolicyFile record, @Param("example") TradePolicyFileExample example);

    int updateByPrimaryKeySelective(TradePolicyFile record);

    int updateByPrimaryKey(TradePolicyFile record);
}