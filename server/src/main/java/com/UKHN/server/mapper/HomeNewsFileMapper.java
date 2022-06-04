package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.HomeNewsFile;
import com.UKHN_backend.server.domain.HomeNewsFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeNewsFileMapper {
    long countByExample(HomeNewsFileExample example);

    int deleteByExample(HomeNewsFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeNewsFile record);

    int insertSelective(HomeNewsFile record);

    List<HomeNewsFile> selectByExample(HomeNewsFileExample example);

    HomeNewsFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeNewsFile record, @Param("example") HomeNewsFileExample example);

    int updateByExample(@Param("record") HomeNewsFile record, @Param("example") HomeNewsFileExample example);

    int updateByPrimaryKeySelective(HomeNewsFile record);

    int updateByPrimaryKey(HomeNewsFile record);
}