package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.IntroActivityContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.IntroActivityContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 同乡会介绍——同乡会活动——活动内容详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/intro-activity-content")
public class IntroActivityContentController {
    @Resource
    private IntroActivityContentService introActivityContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        IntroActivityContentDto content = introActivityContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody IntroActivityContentDto introActivityContentDto) {
        ResponseDto responseDto = new ResponseDto();
        introActivityContentService.save(introActivityContentDto);
        responseDto.setContent(introActivityContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        introActivityContentService.delete(id);
        return responseDto;
    }
}
