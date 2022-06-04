package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicReportDto;
import com.UKHN_backend.server.dto.academic.AcademicReportContentDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicReportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术报告-展示功能
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-report")
public class AcademicReportController {

    @Resource
    private AcademicReportService academicReportService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        academicReportService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicReportDto academicReportDto) {
        ResponseDto responseDto = new ResponseDto();
        academicReportService.save(academicReportDto);
        responseDto.setContent(academicReportDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicReportService.delete(id);
        return responseDto;
    }
    
    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicReportDto content = academicReportService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }
}
