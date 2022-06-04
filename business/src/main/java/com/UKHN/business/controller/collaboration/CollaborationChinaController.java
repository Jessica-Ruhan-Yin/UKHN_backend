package com.UKHN.business.controller.collaboration;

import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaPageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.collaboration.CollaborationChinaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 产业合作——国内产业合作
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/collaboration-China")
public class CollaborationChinaController {

    @Resource
    private CollaborationChinaService collaborationChinaService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody CollaborationChinaPageDto collaborationChinaDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaService.list(collaborationChinaDto);
        responseDto.setContent(collaborationChinaDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CollaborationChinaDto collaborationChinaDto) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaService.save(collaborationChinaDto);
        responseDto.setContent(collaborationChinaDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        collaborationChinaService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        CollaborationChinaDto content = collaborationChinaService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
