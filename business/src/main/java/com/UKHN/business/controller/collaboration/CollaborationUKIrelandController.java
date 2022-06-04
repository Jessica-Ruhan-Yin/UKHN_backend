package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandPageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationUKIrelandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——英国及爱尔兰企业合作
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/collaboration-UK-Ireland")
public class CollaborationUKIrelandController {

    @Resource
    private CollaborationUKIrelandService collaborationUKIrelandService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody CollaborationUKIrelandPageDto collaborationUKIrelandDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandService.list(collaborationUKIrelandDto);
        responseDto.setContent(collaborationUKIrelandDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationUKIrelandDto collaborationUKIrelandDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandService.save(collaborationUKIrelandDto);
        responseDto.setContent(collaborationUKIrelandDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationUKIrelandService.delete(id);
        return responseDto;
    }
    
    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        CollaborationUKIrelandDto content = collaborationUKIrelandService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }
}
