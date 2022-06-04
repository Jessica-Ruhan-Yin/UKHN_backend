package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationCUIContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 产业合作——中英、中爱企业合作——合作详情文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-CUI-file")
public class CollaborationCUIContentFileController {

    @Resource
    private CollaborationCUIContentFileService collaborationCUIContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<CollaborationCUIContentFileDto> fileDtoList = collaborationCUIContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationCUIContentFileDto collaborationCUIContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        collaborationCUIContentFileService.save(collaborationCUIContentFileDto);
        responseDto.setContent(collaborationCUIContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationCUIContentFileService.delete(id);
        return responseDto;
    }
}

