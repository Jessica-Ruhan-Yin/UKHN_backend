package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.IntroActivityContentFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.IntroActivityContentFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 同乡会介绍——同乡会活动——活动内容文件
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/intro-activity-file")
public class IntroActivityContentFileController {

    @Resource
    private IntroActivityContentFileService introActivityContentFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<IntroActivityContentFileDto> fileDtoList = introActivityContentFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody IntroActivityContentFileDto introActivityContentFileDto) {

        ResponseDto responseDto = new ResponseDto();
        introActivityContentFileService.save(introActivityContentFileDto);
        responseDto.setContent(introActivityContentFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        introActivityContentFileService.delete(id);
        return responseDto;
    }
}

