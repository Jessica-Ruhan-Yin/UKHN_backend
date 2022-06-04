package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.View;
import com.UKHN_backend.server.domain.ViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewMapper {
    long countByExample(ViewExample example);

    int deleteByExample(ViewExample example);

    int deleteByPrimaryKey(String id);

    int insert(View record);

    int insertSelective(View record);

    List<View> selectByExample(ViewExample example);

    View selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") View record, @Param("example") ViewExample example);

    int updateByExample(@Param("record") View record, @Param("example") ViewExample example);

    int updateByPrimaryKeySelective(View record);

    int updateByPrimaryKey(View record);
}