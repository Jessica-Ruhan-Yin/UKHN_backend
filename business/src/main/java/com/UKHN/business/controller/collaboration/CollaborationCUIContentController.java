package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationCUIContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——中英、中爱企业合作——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-CUI-content")
public class CollaborationCUIContentController {
    @Resource
    private CollaborationCUIContentService collaborationCUIContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        CollaborationCUIContentDto content = collaborationCUIContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationCUIContentDto collaborationCUIContentDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIContentService.save(collaborationCUIContentDto);
        responseDto.setContent(collaborationCUIContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIContentService.delete(id);
        return responseDto;
    }
}
