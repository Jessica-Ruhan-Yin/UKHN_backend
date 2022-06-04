package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicStudyAboradContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流——留学申请——留学申请详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-study-abroad-content")
public class AcademicStudyAbroadContentController {
    @Resource
    private AcademicStudyAboradContentService academicStudyAbroadContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        AcademicStudyAbroadContentDto content = academicStudyAbroadContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicStudyAbroadContentDto academicStudyAbroadContentDto) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadContentService.save(academicStudyAbroadContentDto);
        responseDto.setContent(academicStudyAbroadContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadContentService.delete(id);
        return responseDto;
    }
}
