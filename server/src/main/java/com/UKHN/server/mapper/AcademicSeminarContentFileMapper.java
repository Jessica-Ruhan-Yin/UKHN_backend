package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.AcademicSeminarContentFile;
import com.UKHN_backend.server.domain.AcademicSeminarContentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcademicSeminarContentFileMapper {
    long countByExample(AcademicSeminarContentFileExample example);

    int deleteByExample(AcademicSeminarContentFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcademicSeminarContentFile record);

    int insertSelective(AcademicSeminarContentFile record);

    List<AcademicSeminarContentFile> selectByExample(AcademicSeminarContentFileExample example);

    AcademicSeminarContentFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcademicSeminarContentFile record, @Param("example") AcademicSeminarContentFileExample example);

    int updateByExample(@Param("record") AcademicSeminarContentFile record, @Param("example") AcademicSeminarContentFileExample example);

    int updateByPrimaryKeySelective(AcademicSeminarContentFile record);

    int updateByPrimaryKey(AcademicSeminarContentFile record);
}