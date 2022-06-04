package com.UKHN.business.controller.academic;

import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentDto;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.academic.AcademicStudyAbroadService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 学术交流——留学申请部分封面信息
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/academic-study-abroad")
public class AcademicStudyAbroadController {

    @Resource
    private AcademicStudyAbroadService academicStudyAbroadService;

    @GetMapping("/list")
    public ResponseDto list() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(academicStudyAbroadService.list());
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody AcademicStudyAbroadDto academicStudyAbroadDto) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadService.save(academicStudyAbroadDto);
        responseDto.setContent(academicStudyAbroadDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        academicStudyAbroadService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        AcademicStudyAbroadDto content = academicStudyAbroadService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
