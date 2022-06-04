package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicSeminarContent;
import com.UKHN_backend.server.domain.AcademicSeminarContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicSeminarContentMapper {
    long countByExample(AcademicSeminarContentExample example);

    int deleteByExample(AcademicSeminarContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicSeminarContent record);

    int insertSelective(AcademicSeminarContent record);

    List<AcademicSeminarContent> selectByExampleWithBLOBs(AcademicSeminarContentExample example);

    List<AcademicSeminarContent> selectByExample(AcademicSeminarContentExample example);

    AcademicSeminarContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicSeminarContent record, @Param("example") AcademicSeminarContentExample example);

    int updateByExampleWithBLOBs(@Param("record") AcademicSeminarContent record, @Param("example") AcademicSeminarContentExample example);

    int updateByExample(@Param("record") AcademicSeminarContent record, @Param("example") AcademicSeminarContentExample example);

    int updateByPrimaryKeySelective(AcademicSeminarContent record);

    int updateByPrimaryKeyWithBLOBs(AcademicSeminarContent record);

    int updateByPrimaryKey(AcademicSeminarContent record);
}