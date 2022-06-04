package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicSeminarContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicSeminarContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 学术交流——研讨会——研讨会详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-seminar-file")
public class AcademicSeminarContentFileController {

    @Resource
    private AcademicSeminarContentFileService academicSeminarContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<AcademicSeminarContentFileDto> fileDtoList = academicSeminarContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicSeminarContentFileDto academicSeminarContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        academicSeminarContentFileService.save(academicSeminarContentFileDto);
        responseDto.setContent(academicSeminarContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarContentFileService.delete(id);
        return responseDto;
    }
}

