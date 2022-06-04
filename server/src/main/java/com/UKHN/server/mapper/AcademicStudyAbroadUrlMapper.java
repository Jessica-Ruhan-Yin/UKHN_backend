package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicStudyAbroadUrl;
import com.UKHN_backend.server.domain.AcademicStudyAbroadUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicStudyAbroadUrlMapper {
    long countByExample(AcademicStudyAbroadUrlExample example);

    int deleteByExample(AcademicStudyAbroadUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicStudyAbroadUrl record);

    int insertSelective(AcademicStudyAbroadUrl record);

    List<AcademicStudyAbroadUrl> selectByExample(AcademicStudyAbroadUrlExample example);

    AcademicStudyAbroadUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicStudyAbroadUrl record, @Param("example") AcademicStudyAbroadUrlExample example);

    int updateByExample(@Param("record") AcademicStudyAbroadUrl record, @Param("example") AcademicStudyAbroadUrlExample example);

    int updateByPrimaryKeySelective(AcademicStudyAbroadUrl record);

    int updateByPrimaryKey(AcademicStudyAbroadUrl record);
}