package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicStudyAbroadContent;
import com.UKHN_backend.server.domain.AcademicStudyAbroadContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicStudyAbroadContentMapper {
    long countByExample(AcademicStudyAbroadContentExample example);

    int deleteByExample(AcademicStudyAbroadContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicStudyAbroadContent record);

    int insertSelective(AcademicStudyAbroadContent record);

    List<AcademicStudyAbroadContent> selectByExampleWithBLOBs(AcademicStudyAbroadContentExample example);

    List<AcademicStudyAbroadContent> selectByExample(AcademicStudyAbroadContentExample example);

    AcademicStudyAbroadContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicStudyAbroadContent record, @Param("example") AcademicStudyAbroadContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AcademicStudyAbroadContent record, @Param("example") AcademicStudyAbroadContentExample example);

    int updateByExample(@Param("record") AcademicStudyAbroadContent record, @Param("example") AcademicStudyAbroadContentExample example);

    int updateByPrimaryKeySelective(AcademicStudyAbroadContent record);

    int updateByPrimaryKeyWithBLOBs(AcademicStudyAbroadContent record);

    int updateByPrimaryKey(AcademicStudyAbroadContent record);
}