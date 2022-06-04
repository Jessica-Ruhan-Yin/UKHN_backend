package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationCUIUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationCUIUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——中英、中爱企业合作——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-CUI-url")
public class CollaborationCUIUrlController {
    @Resource
    private CollaborationCUIUrlService collaborationCUIUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = collaborationCUIUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationCUIUrlDto collaborationCUIUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIUrlService.save(collaborationCUIUrlDto);
        responseDto.setContent(collaborationCUIUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIUrlService.delete(id);
        return responseDto;
    }
}
