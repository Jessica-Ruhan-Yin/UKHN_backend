package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationUKIrelandContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 产业合作——英国及爱尔兰企业合作——合作详情文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/collaboration-UK-Ireland-file")
public class CollaborationUKIrelandContentFileController {

    @Resource
    private CollaborationUKIrelandContentFileService collaborationUKIrelandContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<CollaborationUKIrelandContentFileDto> fileDtoList = collaborationUKIrelandContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationUKIrelandContentFileDto collaborationUKIrelandContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandContentFileService.save(collaborationUKIrelandContentFileDto);
        responseDto.setContent(collaborationUKIrelandContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandContentFileService.delete(id);
        return responseDto;
    }
}

