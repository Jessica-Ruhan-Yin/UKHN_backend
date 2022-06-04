package com.UKHN.business.controller;

import com.UKHN_backend.server.domain.IntroEnroll;
import com.UKHN_backend.server.dto.IntroEnrollDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.IntroEnrollService;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 同乡会介绍--招新
 * @Author Jessica
 * @Version v
 * @Date 2021/11/17
 */
@RestController
@RequestMapping("/admin/intro-enroll")
public class IntroEnrollController {

    @Resource
    private IntroEnrollService introEnrollService;

    //加入我们——信息查询
    @GetMapping("/list")
    public ResponseDto list() {
        ResponseDto responseDto = new ResponseDto();
        List<IntroEnrollDto> introEnrollDtoList = introEnrollService.list();
        responseDto.setContent(introEnrollDtoList);
        return responseDto;
    }

    //加入我们——信息编辑
    @PostMapping("/save")
    public ResponseDto save(@RequestBody IntroEnrollDto introEnrollDto) {
        ResponseDto responseDto = new ResponseDto();
        IntroEnroll introEnroll = CopyUtil.copy(introEnrollDto, IntroEnroll.class);
        introEnrollService.save(introEnroll);
        responseDto.setContent(introEnrollDto);
        return responseDto;
    }
}
