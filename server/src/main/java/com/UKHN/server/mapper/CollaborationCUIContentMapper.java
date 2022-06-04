package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationCUIContent;
import com.UKHN_backend.server.domain.CollaborationCUIContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationCUIContentMapper {
    long countByExample(CollaborationCUIContentExample example);

    int deleteByExample(CollaborationCUIContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationCUIContent record);

    int insertSelective(CollaborationCUIContent record);

    List<CollaborationCUIContent> selectByExampleWithBLOBs(CollaborationCUIContentExample example);

    List<CollaborationCUIContent> selectByExample(CollaborationCUIContentExample example);

    CollaborationCUIContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationCUIContent record, @Param("example") CollaborationCUIContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CollaborationCUIContent record, @Param("example") CollaborationCUIContentExample example);

    int updateByExample(@Param("record") CollaborationCUIContent record, @Param("example") CollaborationCUIContentExample example);

    int updateByPrimaryKeySelective(CollaborationCUIContent record);

    int updateByPrimaryKeyWithBLOBs(CollaborationCUIContent record);

    int updateByPrimaryKey(CollaborationCUIContent record);
}