package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicReportUrl;
import com.UKHN_backend.server.domain.AcademicReportUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicReportUrlMapper {
    long countByExample(AcademicReportUrlExample example);

    int deleteByExample(AcademicReportUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicReportUrl record);

    int insertSelective(AcademicReportUrl record);

    List<AcademicReportUrl> selectByExample(AcademicReportUrlExample example);

    AcademicReportUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicReportUrl record, @Param("example") AcademicReportUrlExample example);

    int updateByExample(@Param("record") AcademicReportUrl record, @Param("example") AcademicReportUrlExample example);

    int updateByPrimaryKeySelective(AcademicReportUrl record);

    int updateByPrimaryKey(AcademicReportUrl record);
}