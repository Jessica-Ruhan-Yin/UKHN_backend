package com.UKHN.server.mapper;

import com.UKHN_backend.server.domain.CouncilMembers;
import com.UKHN_backend.server.domain.CouncilMembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouncilMembersMapper {
    long countByExample(CouncilMembersExample example);

    int deleteByExample(CouncilMembersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouncilMembers record);

    int insertSelective(CouncilMembers record);

    List<CouncilMembers> selectByExample(CouncilMembersExample example);

    CouncilMembers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouncilMembers record, @Param("example") CouncilMembersExample example);

    int updateByExample(@Param("record") CouncilMembers record, @Param("example") CouncilMembersExample example);

    int updateByPrimaryKeySelective(CouncilMembers record);

    int updateByPrimaryKey(CouncilMembers record);
}