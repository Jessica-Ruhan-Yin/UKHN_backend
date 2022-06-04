package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicStudyAbroad;
import com.UKHN_backend.server.domain.AcademicStudyAbroadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicStudyAbroadMapper {
    long countByExample(AcademicStudyAbroadExample example);

    int deleteByExample(AcademicStudyAbroadExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicStudyAbroad record);

    int insertSelective(AcademicStudyAbroad record);

    List<AcademicStudyAbroad> selectByExample(AcademicStudyAbroadExample example);

    AcademicStudyAbroad selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicStudyAbroad record, @Param("example") AcademicStudyAbroadExample example);

    int updateByExample(@Param("record") AcademicStudyAbroad record, @Param("example") AcademicStudyAbroadExample example);

    int updateByPrimaryKeySelective(AcademicStudyAbroad record);

    int updateByPrimaryKey(AcademicStudyAbroad record);
}