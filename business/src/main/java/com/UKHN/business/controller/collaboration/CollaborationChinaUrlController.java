package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationChinaUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationChinaUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——国内产业合作——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-China-url")
public class CollaborationChinaUrlController {
    @Resource
    private CollaborationChinaUrlService collaborationChinaUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = collaborationChinaUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationChinaUrlDto collaborationChinaUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaUrlService.save(collaborationChinaUrlDto);
        responseDto.setContent(collaborationChinaUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaUrlService.delete(id);
        return responseDto;
    }
}
