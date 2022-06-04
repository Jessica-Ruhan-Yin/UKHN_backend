package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationChinaContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——国内产业合作——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-China-content")
public class CollaborationChinaContentController {
    @Resource
    private CollaborationChinaContentService collaborationChinaContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        CollaborationChinaContentDto content = collaborationChinaContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationChinaContentDto collaborationChinaContentDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaContentService.save(collaborationChinaContentDto);
        responseDto.setContent(collaborationChinaContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaContentService.delete(id);
        return responseDto;
    }
}
