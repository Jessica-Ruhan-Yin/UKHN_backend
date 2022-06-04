package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationChinaContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 产业合作——国内产业合作——合作详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-China-file")
public class CollaborationChinaContentFileController {

    @Resource
    private CollaborationChinaContentFileService collaborationChinaContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<CollaborationChinaContentFileDto> fileDtoList = collaborationChinaContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationChinaContentFileDto collaborationChinaContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        collaborationChinaContentFileService.save(collaborationChinaContentFileDto);
        responseDto.setContent(collaborationChinaContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaContentFileService.delete(id);
        return responseDto;
    }
}

