package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationChina;
import com.UKHN_backend.server.domain.CollaborationChinaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationChinaMapper {
    long countByExample(CollaborationChinaExample example);

    int deleteByExample(CollaborationChinaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationChina record);

    int insertSelective(CollaborationChina record);

    List<CollaborationChina> selectByExample(CollaborationChinaExample example);

    CollaborationChina selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationChina record, @Param("example") CollaborationChinaExample example);

    int updateByExample(@Param("record") CollaborationChina record, @Param("example") CollaborationChinaExample example);

    int updateByPrimaryKeySelective(CollaborationChina record);

    int updateByPrimaryKey(CollaborationChina record);
}