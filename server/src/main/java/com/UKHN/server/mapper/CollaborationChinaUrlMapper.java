package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationChinaUrl;
import com.UKHN_backend.server.domain.CollaborationChinaUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationChinaUrlMapper {
    long countByExample(CollaborationChinaUrlExample example);

    int deleteByExample(CollaborationChinaUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationChinaUrl record);

    int insertSelective(CollaborationChinaUrl record);

    List<CollaborationChinaUrl> selectByExample(CollaborationChinaUrlExample example);

    CollaborationChinaUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationChinaUrl record, @Param("example") CollaborationChinaUrlExample example);

    int updateByExample(@Param("record") CollaborationChinaUrl record, @Param("example") CollaborationChinaUrlExample example);

    int updateByPrimaryKeySelective(CollaborationChinaUrl record);

    int updateByPrimaryKey(CollaborationChinaUrl record);
}