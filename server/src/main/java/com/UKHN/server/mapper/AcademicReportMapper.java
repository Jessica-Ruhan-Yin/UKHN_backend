package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicReport;
import com.UKHN_backend.server.domain.AcademicReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicReportMapper {
    long countByExample(AcademicReportExample example);

    int deleteByExample(AcademicReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicReport record);

    int insertSelective(AcademicReport record);

    List<AcademicReport> selectByExample(AcademicReportExample example);

    AcademicReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicReport record, @Param("example") AcademicReportExample example);

    int updateByExample(@Param("record") AcademicReport record, @Param("example") AcademicReportExample example);

    int updateByPrimaryKeySelective(AcademicReport record);

    int updateByPrimaryKey(AcademicReport record);
}