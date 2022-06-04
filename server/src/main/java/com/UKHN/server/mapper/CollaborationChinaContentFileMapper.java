package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CollaborationChinaContentFile;
import com.UKHN_backend.server.domain.CollaborationChinaContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollaborationChinaContentFileMapper {
    long countByExample(CollaborationChinaContentFileExample example);

    int deleteByExample(CollaborationChinaContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollaborationChinaContentFile record);

    int insertSelective(CollaborationChinaContentFile record);

    List<CollaborationChinaContentFile> selectByExample(CollaborationChinaContentFileExample example);

    CollaborationChinaContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollaborationChinaContentFile record, @Param("example") CollaborationChinaContentFileExample example);

    int updateByExample(@Param("record") CollaborationChinaContentFile record, @Param("example") CollaborationChinaContentFileExample example);

    int updateByPrimaryKeySelective(CollaborationChinaContentFile record);

    int updateByPrimaryKey(CollaborationChinaContentFile record);
}