package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicForumUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicForumUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术论坛-文章链接(url)
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/06
 */
@RestController
@RequestMapping("/admin/academic-forum-url")
public class AcademicForumUrlController {
    @Resource
    private AcademicForumUrlService academicForumUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = academicForumUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicForumUrlDto academicForumUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        academicForumUrlService.save(academicForumUrlDto);
        responseDto.setContent(academicForumUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicForumUrlService.delete(id);
        return responseDto;
    }
}
