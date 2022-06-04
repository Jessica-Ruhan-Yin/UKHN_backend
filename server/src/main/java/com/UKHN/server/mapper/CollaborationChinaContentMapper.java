package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationChinaContent;
import com.UKHN_backend.server.domain.CollaborationChinaContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationChinaContentMapper {
    long countByExample(CollaborationChinaContentExample example);

    int deleteByExample(CollaborationChinaContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationChinaContent record);

    int insertSelective(CollaborationChinaContent record);

    List<CollaborationChinaContent> selectByExampleWithBLOBs(CollaborationChinaContentExample example);

    List<CollaborationChinaContent> selectByExample(CollaborationChinaContentExample example);

    CollaborationChinaContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationChinaContent record, @Param("example") CollaborationChinaContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CollaborationChinaContent record, @Param("example") CollaborationChinaContentExample example);

    int updateByExample(@Param("record") CollaborationChinaContent record, @Param("example") CollaborationChinaContentExample example);

    int updateByPrimaryKeySelective(CollaborationChinaContent record);

    int updateByPrimaryKeyWithBLOBs(CollaborationChinaContent record);

    int updateByPrimaryKey(CollaborationChinaContent record);
}