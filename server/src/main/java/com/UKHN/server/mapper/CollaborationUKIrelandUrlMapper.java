package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationUKIrelandUrl;
import com.UKHN_backend.server.domain.CollaborationUKIrelandUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationUKIrelandUrlMapper {
    long countByExample(CollaborationUKIrelandUrlExample example);

    int deleteByExample(CollaborationUKIrelandUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationUKIrelandUrl record);

    int insertSelective(CollaborationUKIrelandUrl record);

    List<CollaborationUKIrelandUrl> selectByExample(CollaborationUKIrelandUrlExample example);

    CollaborationUKIrelandUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationUKIrelandUrl record, @Param("example") CollaborationUKIrelandUrlExample example);

    int updateByExample(@Param("record") CollaborationUKIrelandUrl record, @Param("example") CollaborationUKIrelandUrlExample example);

    int updateByPrimaryKeySelective(CollaborationUKIrelandUrl record);

    int updateByPrimaryKey(CollaborationUKIrelandUrl record);
}