package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationUKIrelandContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——英国及爱尔兰企业合作——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-UK-Ireland-content")
public class CollaborationUKIrelandContentController {
    @Resource
    private CollaborationUKIrelandContentService collaborationUKIrelandContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        CollaborationUKIrelandContentDto content = collaborationUKIrelandContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationUKIrelandContentDto collaborationUKIrelandContentDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandContentService.save(collaborationUKIrelandContentDto);
        responseDto.setContent(collaborationUKIrelandContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandContentService.delete(id);
        return responseDto;
    }
}
