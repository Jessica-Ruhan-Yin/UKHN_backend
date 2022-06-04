package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicForumContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicForumContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description 学术论坛-文章详情功能
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-forum-content")
public class AcademicForumContentController {

    @Resource
    AcademicForumContentService academicForumContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicForumContentDto content = academicForumContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicForumContentDto academicForumContentDto){
        ResponseDto responseDto = new ResponseDto();
        academicForumContentService.save(academicForumContentDto);
        responseDto.setContent(academicForumContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        academicForumContentService.delete(id);
        return responseDto;
    }
}
