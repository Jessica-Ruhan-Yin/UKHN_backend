package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicReportFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicReportFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description 学术报告-文章详情的图片/视频地址
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/21
 */
@RestController
@RequestMapping("/admin/academic-report-file")
public class AcademicReportFileController {

    @Resource
    private AcademicReportFileService academicReportFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<AcademicReportFileDto> forumFileDtoList = academicReportFileService.list(id);
        responseDto.setContent(forumFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicReportFileDto academicReportFileDto){

        ResponseDto responseDto = new ResponseDto();
        academicReportFileService.save(academicReportFileDto);
        responseDto.setContent(academicReportFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        academicReportFileService.delete(id);
        return responseDto;
    }
}
