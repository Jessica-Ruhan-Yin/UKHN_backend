package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationUKIrelandContentFile;
import com.UKHN_backend.server.domain.CollaborationUKIrelandContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationUKIrelandContentFileMapper {
    long countByExample(CollaborationUKIrelandContentFileExample example);

    int deleteByExample(CollaborationUKIrelandContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationUKIrelandContentFile record);

    int insertSelective(CollaborationUKIrelandContentFile record);

    List<CollaborationUKIrelandContentFile> selectByExample(CollaborationUKIrelandContentFileExample example);

    CollaborationUKIrelandContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationUKIrelandContentFile record, @Param("example") CollaborationUKIrelandContentFileExample example);

    int updateByExample(@Param("record") CollaborationUKIrelandContentFile record, @Param("example") CollaborationUKIrelandContentFileExample example);

    int updateByPrimaryKeySelective(CollaborationUKIrelandContentFile record);

    int updateByPrimaryKey(CollaborationUKIrelandContentFile record);
}