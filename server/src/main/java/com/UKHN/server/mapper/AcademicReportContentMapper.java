package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicReportContent;
import com.UKHN_backend.server.domain.AcademicReportContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicReportContentMapper {
    long countByExample(AcademicReportContentExample example);

    int deleteByExample(AcademicReportContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicReportContent record);

    int insertSelective(AcademicReportContent record);

    List<AcademicReportContent> selectByExampleWithBLOBs(AcademicReportContentExample example);

    List<AcademicReportContent> selectByExample(AcademicReportContentExample example);

    AcademicReportContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicReportContent record, @Param("example") AcademicReportContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AcademicReportContent record, @Param("example") AcademicReportContentExample example);

    int updateByExample(@Param("record") AcademicReportContent record, @Param("example") AcademicReportContentExample example);

    int updateByPrimaryKeySelective(AcademicReportContent record);

    int updateByPrimaryKeyWithBLOBs(AcademicReportContent record);

    int updateByPrimaryKey(AcademicReportContent record);
}