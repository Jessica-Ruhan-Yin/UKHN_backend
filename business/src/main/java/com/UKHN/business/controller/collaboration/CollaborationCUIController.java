package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIPageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationCUIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——中英、中爱企业合作
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/collaboration-CUI")
public class CollaborationCUIController {

    @Resource
    private CollaborationCUIService collaborationCUIService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody CollaborationCUIPageDto collaborationCUIDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIService.list(collaborationCUIDto);
        responseDto.setContent(collaborationCUIDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationCUIDto collaborationCUIDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIService.save(collaborationCUIDto);
        responseDto.setContent(collaborationCUIDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIService.delete(id);
        return responseDto;
    }
    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        CollaborationCUIDto content = collaborationCUIService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
