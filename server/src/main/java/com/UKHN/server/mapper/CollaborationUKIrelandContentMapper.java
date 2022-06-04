package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationUKIrelandContent;
import com.UKHN_backend.server.domain.CollaborationUKIrelandContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationUKIrelandContentMapper {
    long countByExample(CollaborationUKIrelandContentExample example);

    int deleteByExample(CollaborationUKIrelandContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationUKIrelandContent record);

    int insertSelective(CollaborationUKIrelandContent record);

    List<CollaborationUKIrelandContent> selectByExampleWithBLOBs(CollaborationUKIrelandContentExample example);

    List<CollaborationUKIrelandContent> selectByExample(CollaborationUKIrelandContentExample example);

    CollaborationUKIrelandContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationUKIrelandContent record, @Param("example") CollaborationUKIrelandContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CollaborationUKIrelandContent record, @Param("example") CollaborationUKIrelandContentExample example);

    int updateByExample(@Param("record") CollaborationUKIrelandContent record, @Param("example") CollaborationUKIrelandContentExample example);

    int updateByPrimaryKeySelective(CollaborationUKIrelandContent record);

    int updateByPrimaryKeyWithBLOBs(CollaborationUKIrelandContent record);

    int updateByPrimaryKey(CollaborationUKIrelandContent record);
}