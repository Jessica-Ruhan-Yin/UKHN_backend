package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicForumContentDto;
import com.UKHN_backend.server.dto.academic.AcademicForumDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicForumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术论坛 展示功能
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-forum")
public class AcademicForumController {

    @Resource
    private AcademicForumService academicForumService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        academicForumService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicForumDto academicForumDto) {
        ResponseDto responseDto = new ResponseDto();
        academicForumService.save(academicForumDto);
        responseDto.setContent(academicForumDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicForumService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicForumDto content = academicForumService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
