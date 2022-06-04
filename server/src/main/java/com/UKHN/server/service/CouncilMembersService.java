package com.UKHN.server.service;

import com.UKHN_backend.server.domain.CouncilMembers;
import com.UKHN_backend.server.domain.CouncilMembersExample;
import com.UKHN_backend.server.dto.CouncilMembersDto;
import com.UKHN_backend.server.mapper.CouncilMembersMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * @Description 此功能为理事会成员的后端service操作
 * @author Tiffany
 * @Version v
 * @Date 2021/11/17
 */
import javax.annotation.Resource;
import java.util.List;

@Service
public class CouncilMembersService {

    @Resource
    private CouncilMembersMapper councilMembersMapper;

    //列表获取
    public List<CouncilMembersDto> list(){
        CouncilMembersExample example = new CouncilMembersExample();
        CouncilMembersExample.Criteria criteria = example.createCriteria();
        List<CouncilMembers> membersList = councilMembersMapper.selectByExample(null);
        return CopyUtil.copyList(membersList, CouncilMembersDto.class);
    }

    //更新
    public void update(CouncilMembers councilMembers){
        councilMembersMapper.updateByPrimaryKey(councilMembers);
    }


}
