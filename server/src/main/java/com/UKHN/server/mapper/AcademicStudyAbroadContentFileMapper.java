package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicStudyAbroadContentFile;
import com.UKHN_backend.server.domain.AcademicStudyAbroadContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicStudyAbroadContentFileMapper {
    long countByExample(AcademicStudyAbroadContentFileExample example);

    int deleteByExample(AcademicStudyAbroadContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicStudyAbroadContentFile record);

    int insertSelective(AcademicStudyAbroadContentFile record);

    List<AcademicStudyAbroadContentFile> selectByExample(AcademicStudyAbroadContentFileExample example);

    AcademicStudyAbroadContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicStudyAbroadContentFile record, @Param("example") AcademicStudyAbroadContentFileExample example);

    int updateByExample(@Param("record") AcademicStudyAbroadContentFile record, @Param("example") AcademicStudyAbroadContentFileExample example);

    int updateByPrimaryKeySelective(AcademicStudyAbroadContentFile record);

    int updateByPrimaryKey(AcademicStudyAbroadContentFile record);
}