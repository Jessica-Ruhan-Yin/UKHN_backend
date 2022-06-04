package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicForumFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicForumFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description 学术论坛-文章详情的图片/视频地址
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-forum-file")
public class AcademicForumFileController {

    @Resource
    private AcademicForumFileService academicForumFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<AcademicForumFileDto> forumFileDtoList = academicForumFileService.list(id);
        responseDto.setContent(forumFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicForumFileDto academicForumFileDto){

        ResponseDto responseDto = new ResponseDto();
        academicForumFileService.save(academicForumFileDto);
        responseDto.setContent(academicForumFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        academicForumFileService.delete(id);
        return responseDto;
    }
}
