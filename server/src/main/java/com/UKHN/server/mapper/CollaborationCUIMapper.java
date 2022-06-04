package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationCUI;
import com.UKHN_backend.server.domain.CollaborationCUIExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationCUIMapper {
    long countByExample(CollaborationCUIExample example);

    int deleteByExample(CollaborationCUIExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationCUI record);

    int insertSelective(CollaborationCUI record);

    List<CollaborationCUI> selectByExample(CollaborationCUIExample example);

    CollaborationCUI selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationCUI record, @Param("example") CollaborationCUIExample example);

    int updateByExample(@Param("record") CollaborationCUI record, @Param("example") CollaborationCUIExample example);

    int updateByPrimaryKeySelective(CollaborationCUI record);

    int updateByPrimaryKey(CollaborationCUI record);
}