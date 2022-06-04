package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicStudyAbroadContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 学术交流——留学申请——留学申请详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/academic-study-abroad-file")
public class AcademicStudyAbroadFileController {

    @Resource
    private AcademicStudyAbroadContentFileService academicStudyAbroadContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<AcademicStudyAbroadContentFileDto> fileDtoList = academicStudyAbroadContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicStudyAbroadContentFileDto academicStudyAbroadContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadContentFileService.save(academicStudyAbroadContentFileDto);
        responseDto.setContent(academicStudyAbroadContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadContentFileService.delete(id);
        return responseDto;
    }
}

