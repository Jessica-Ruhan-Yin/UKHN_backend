package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicReportFile;
import com.UKHN_backend.server.domain.AcademicReportFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicReportFileMapper {
    long countByExample(AcademicReportFileExample example);

    int deleteByExample(AcademicReportFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicReportFile record);

    int insertSelective(AcademicReportFile record);

    List<AcademicReportFile> selectByExample(AcademicReportFileExample example);

    AcademicReportFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicReportFile record, @Param("example") AcademicReportFileExample example);

    int updateByExample(@Param("record") AcademicReportFile record, @Param("example") AcademicReportFileExample example);

    int updateByPrimaryKeySelective(AcademicReportFile record);

    int updateByPrimaryKey(AcademicReportFile record);
}