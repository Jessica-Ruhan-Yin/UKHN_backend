package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.TradePolicyContent;
import com.UKHN_backend.server.domain.TradePolicyContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePolicyContentMapper {
    long countByExample(TradePolicyContentExample example);

    int deleteByExample(TradePolicyContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradePolicyContent record);

    int insertSelective(TradePolicyContent record);

    List<TradePolicyContent> selectByExampleWithBLOBs(TradePolicyContentExample example);

    List<TradePolicyContent> selectByExample(TradePolicyContentExample example);

    TradePolicyContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePolicyContent record, @Param("example") TradePolicyContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TradePolicyContent record, @Param("example") TradePolicyContentExample example);

    int updateByExample(@Param("record") TradePolicyContent record, @Param("example") TradePolicyContentExample example);

    int updateByPrimaryKeySelective(TradePolicyContent record);

    int updateByPrimaryKeyWithBLOBs(TradePolicyContent record);

    int updateByPrimaryKey(TradePolicyContent record);
}