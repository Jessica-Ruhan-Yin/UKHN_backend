package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationCUIUrl;
import com.UKHN_backend.server.domain.CollaborationCUIUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationCUIUrlMapper {
    long countByExample(CollaborationCUIUrlExample example);

    int deleteByExample(CollaborationCUIUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationCUIUrl record);

    int insertSelective(CollaborationCUIUrl record);

    List<CollaborationCUIUrl> selectByExample(CollaborationCUIUrlExample example);

    CollaborationCUIUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationCUIUrl record, @Param("example") CollaborationCUIUrlExample example);

    int updateByExample(@Param("record") CollaborationCUIUrl record, @Param("example") CollaborationCUIUrlExample example);

    int updateByPrimaryKeySelective(CollaborationCUIUrl record);

    int updateByPrimaryKey(CollaborationCUIUrl record);
}