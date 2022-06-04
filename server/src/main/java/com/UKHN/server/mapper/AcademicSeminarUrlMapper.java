package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicSeminarUrl;
import com.UKHN_backend.server.domain.AcademicSeminarUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicSeminarUrlMapper {
    long countByExample(AcademicSeminarUrlExample example);

    int deleteByExample(AcademicSeminarUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicSeminarUrl record);

    int insertSelective(AcademicSeminarUrl record);

    List<AcademicSeminarUrl> selectByExample(AcademicSeminarUrlExample example);

    AcademicSeminarUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicSeminarUrl record, @Param("example") AcademicSeminarUrlExample example);

    int updateByExample(@Param("record") AcademicSeminarUrl record, @Param("example") AcademicSeminarUrlExample example);

    int updateByPrimaryKeySelective(AcademicSeminarUrl record);

    int updateByPrimaryKey(AcademicSeminarUrl record);
}