package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicSeminar;
import com.UKHN_backend.server.domain.AcademicSeminarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicSeminarMapper {
    long countByExample(AcademicSeminarExample example);

    int deleteByExample(AcademicSeminarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicSeminar record);

    int insertSelective(AcademicSeminar record);

    List<AcademicSeminar> selectByExample(AcademicSeminarExample example);

    AcademicSeminar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicSeminar record, @Param("example") AcademicSeminarExample example);

    int updateByExample(@Param("record") AcademicSeminar record, @Param("example") AcademicSeminarExample example);

    int updateByPrimaryKeySelective(AcademicSeminar record);

    int updateByPrimaryKey(AcademicSeminar record);
}