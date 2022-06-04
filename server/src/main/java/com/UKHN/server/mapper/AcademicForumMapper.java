package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicForum;
import com.UKHN_backend.server.domain.AcademicForumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicForumMapper {
    long countByExample(AcademicForumExample example);

    int deleteByExample(AcademicForumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicForum record);

    int insertSelective(AcademicForum record);

    List<AcademicForum> selectByExample(AcademicForumExample example);

    AcademicForum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicForum record, @Param("example") AcademicForumExample example);

    int updateByExample(@Param("record") AcademicForum record, @Param("example") AcademicForumExample example);

    int updateByPrimaryKeySelective(AcademicForum record);

    int updateByPrimaryKey(AcademicForum record);
}