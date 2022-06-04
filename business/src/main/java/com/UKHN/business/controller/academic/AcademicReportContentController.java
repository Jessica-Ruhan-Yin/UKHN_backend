package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicReportContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicReportContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description 学术报告-文章详情
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-report-content")
public class AcademicReportContentController {

    @Resource
    AcademicReportContentService academicReportContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicReportContentDto content = academicReportContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicReportContentDto academicReportContentDto){
        ResponseDto responseDto = new ResponseDto();
        academicReportContentService.save(academicReportContentDto);
        responseDto.setContent(academicReportContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        academicReportContentService.delete(id);
        return responseDto;
    }
}
