package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicForumUrl;
import com.UKHN_backend.server.domain.AcademicForumUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicForumUrlMapper {
    long countByExample(AcademicForumUrlExample example);

    int deleteByExample(AcademicForumUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicForumUrl record);

    int insertSelective(AcademicForumUrl record);

    List<AcademicForumUrl> selectByExample(AcademicForumUrlExample example);

    AcademicForumUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicForumUrl record, @Param("example") AcademicForumUrlExample example);

    int updateByExample(@Param("record") AcademicForumUrl record, @Param("example") AcademicForumUrlExample example);

    int updateByPrimaryKeySelective(AcademicForumUrl record);

    int updateByPrimaryKey(AcademicForumUrl record);
}