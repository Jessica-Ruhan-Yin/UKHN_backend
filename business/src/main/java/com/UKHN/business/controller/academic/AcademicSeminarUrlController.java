package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicSeminarUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicSeminarUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流——研讨会——研讨会链接
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-seminar-url")
public class AcademicSeminarUrlController {
    @Resource
    private AcademicSeminarUrlService academicSeminarUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = academicSeminarUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicSeminarUrlDto academicSeminarUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarUrlService.save(academicSeminarUrlDto);
        responseDto.setContent(academicSeminarUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarUrlService.delete(id);
        return responseDto;
    }
}
