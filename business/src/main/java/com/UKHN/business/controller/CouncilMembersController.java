package com.UKHN.business.controller;

import com.UKHN_backend.server.domain.CouncilMembers;
import com.UKHN_backend.server.dto.CouncilMembersDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.CouncilMembersService;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 此功能为理事会成员的后端service操作
 * @author Tiffany
 * @Version v
 * @Date 2021/11/17
 */
@RestController
@RequestMapping("/admin/council-members")
public class CouncilMembersController {

    @Resource
    private CouncilMembersService councilMembersService;

    /**
     * 获取理事会成员列表
     * @return
     */
    @GetMapping("/show")
    public ResponseDto list(){
        ResponseDto responseDto = new ResponseDto();
        List<CouncilMembersDto> menbersDtoList = councilMembersService.list();
        responseDto.setContent(menbersDtoList);
        return responseDto;
    }

    /**
     * 更新理事会成员
     */
    @PostMapping("/update")
    public ResponseDto update(@RequestBody CouncilMembersDto councilMembersDto){
        ResponseDto responseDto = new ResponseDto();
        CouncilMembers councilMembers = CopyUtil.copy(councilMembersDto,CouncilMembers.class);
        councilMembersService.update(councilMembers);
        responseDto.setContent(councilMembers);
        return responseDto;

    }
}
