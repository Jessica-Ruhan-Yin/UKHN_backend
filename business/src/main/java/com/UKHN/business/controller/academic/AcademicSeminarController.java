package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicSeminarContentDto;
import com.UKHN_backend.server.dto.academic.AcademicSeminarDto;
import com.UKHN_backend.server.dto.academic.AcademicSeminarPageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicSeminarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流——研讨会部分封面信息
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/academic-seminar")
public class AcademicSeminarController {

    @Resource
    private AcademicSeminarService academicSeminarService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody AcademicSeminarPageDto academicSeminarDto) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarService.list(academicSeminarDto);
        responseDto.setContent(academicSeminarDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicSeminarDto academicSeminarDto) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarService.save(academicSeminarDto);
        responseDto.setContent(academicSeminarDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicSeminarService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicSeminarDto content = academicSeminarService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
