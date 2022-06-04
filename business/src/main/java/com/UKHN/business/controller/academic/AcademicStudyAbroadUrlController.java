package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicStudyAboradUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流——留学申请——留学申请链接
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-study-abroad-url")
public class AcademicStudyAbroadUrlController {
    @Resource
    private AcademicStudyAboradUrlService academicStudyAbroadUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = academicStudyAbroadUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicStudyAbroadUrlDto academicStudyAbroadUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadUrlService.save(academicStudyAbroadUrlDto);
        responseDto.setContent(academicStudyAbroadUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadUrlService.delete(id);
        return responseDto;
    }
}
