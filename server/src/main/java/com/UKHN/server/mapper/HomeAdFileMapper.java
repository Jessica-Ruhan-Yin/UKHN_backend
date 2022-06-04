package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeAdFile;
import com.UKHN_backend.server.domain.HomeAdFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeAdFileMapper {
    long countByExample(HomeAdFileExample example);

    int deleteByExample(HomeAdFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeAdFile record);

    int insertSelective(HomeAdFile record);

    List<HomeAdFile> selectByExample(HomeAdFileExample example);

    HomeAdFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeAdFile record, @Param("example") HomeAdFileExample example);

    int updateByExample(@Param("record") HomeAdFile record, @Param("example") HomeAdFileExample example);

    int updateByPrimaryKeySelective(HomeAdFile record);

    int updateByPrimaryKey(HomeAdFile record);
}