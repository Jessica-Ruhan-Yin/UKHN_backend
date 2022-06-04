package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationUKIrelandUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——英国及爱尔兰企业合作——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-UK-Ireland-url")
public class CollaborationUKIrelandUrlController {
    @Resource
    private CollaborationUKIrelandUrlService collaborationUKIrelandUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = collaborationUKIrelandUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationUKIrelandUrlDto collaborationUKIrelandUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandUrlService.save(collaborationUKIrelandUrlDto);
        responseDto.setContent(collaborationUKIrelandUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandUrlService.delete(id);
        return responseDto;
    }
}
