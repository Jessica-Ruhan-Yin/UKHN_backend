package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationUKIreland;
import com.UKHN_backend.server.domain.CollaborationUKIrelandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationUKIrelandMapper {
    long countByExample(CollaborationUKIrelandExample example);

    int deleteByExample(CollaborationUKIrelandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationUKIreland record);

    int insertSelective(CollaborationUKIreland record);

    List<CollaborationUKIreland> selectByExample(CollaborationUKIrelandExample example);

    CollaborationUKIreland selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationUKIreland record, @Param("example") CollaborationUKIrelandExample example);

    int updateByExample(@Param("record") CollaborationUKIreland record, @Param("example") CollaborationUKIrelandExample example);

    int updateByPrimaryKeySelective(CollaborationUKIreland record);

    int updateByPrimaryKey(CollaborationUKIreland record);
}