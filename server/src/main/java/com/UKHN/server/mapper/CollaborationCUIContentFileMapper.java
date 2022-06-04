package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationCUIContentFile;
import com.UKHN_backend.server.domain.CollaborationCUIContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationCUIContentFileMapper {
    long countByExample(CollaborationCUIContentFileExample example);

    int deleteByExample(CollaborationCUIContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationCUIContentFile record);

    int insertSelective(CollaborationCUIContentFile record);

    List<CollaborationCUIContentFile> selectByExample(CollaborationCUIContentFileExample example);

    CollaborationCUIContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationCUIContentFile record, @Param("example") CollaborationCUIContentFileExample example);

    int updateByExample(@Param("record") CollaborationCUIContentFile record, @Param("example") CollaborationCUIContentFileExample example);

    int updateByPrimaryKeySelective(CollaborationCUIContentFile record);

    int updateByPrimaryKey(CollaborationCUIContentFile record);
}