package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicForumContent;
import com.UKHN_backend.server.domain.AcademicForumContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicForumContentMapper {
    long countByExample(AcademicForumContentExample example);

    int deleteByExample(AcademicForumContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicForumContent record);

    int insertSelective(AcademicForumContent record);

    List<AcademicForumContent> selectByExampleWithBLOBs(AcademicForumContentExample example);

    List<AcademicForumContent> selectByExample(AcademicForumContentExample example);

    AcademicForumContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicForumContent record, @Param("example") AcademicForumContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AcademicForumContent record, @Param("example") AcademicForumContentExample example);

    int updateByExample(@Param("record") AcademicForumContent record, @Param("example") AcademicForumContentExample example);

    int updateByPrimaryKeySelective(AcademicForumContent record);

    int updateByPrimaryKeyWithBLOBs(AcademicForumContent record);

    int updateByPrimaryKey(AcademicForumContent record);
}