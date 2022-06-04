package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicForumFile;
import com.UKHN_backend.server.domain.AcademicForumFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicForumFileMapper {
    long countByExample(AcademicForumFileExample example);

    int deleteByExample(AcademicForumFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicForumFile record);

    int insertSelective(AcademicForumFile record);

    List<AcademicForumFile> selectByExample(AcademicForumFileExample example);

    AcademicForumFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicForumFile record, @Param("example") AcademicForumFileExample example);

    int updateByExample(@Param("record") AcademicForumFile record, @Param("example") AcademicForumFileExample example);

    int updateByPrimaryKeySelective(AcademicForumFile record);

    int updateByPrimaryKey(AcademicForumFile record);
}