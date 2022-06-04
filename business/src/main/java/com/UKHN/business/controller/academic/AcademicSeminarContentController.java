package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicSeminarContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicSeminarContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流-研讨会-研讨会详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-seminar-content")
public class AcademicSeminarContentController {
    @Resource
    private AcademicSeminarContentService academicSeminarContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        AcademicSeminarContentDto content = academicSeminarContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicSeminarContentDto academicSeminarContentDto) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarContentService.save(academicSeminarContentDto);
        responseDto.setContent(academicSeminarContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarContentService.delete(id);
        return responseDto;
    }
}
