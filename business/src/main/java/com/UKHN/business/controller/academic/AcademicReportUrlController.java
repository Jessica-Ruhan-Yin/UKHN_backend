package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicReportUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicReportUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术报告-文章链接(url)
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/06
 */
@RestController
@RequestMapping("/admin/academic-report-url")
public class AcademicReportUrlController {
    @Resource
    private AcademicReportUrlService academicReportUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = academicReportUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicReportUrlDto academicReportUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        academicReportUrlService.save(academicReportUrlDto);
        responseDto.setContent(academicReportUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicReportUrlService.delete(id);
        return responseDto;
    }
}
