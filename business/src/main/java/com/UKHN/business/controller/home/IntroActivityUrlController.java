package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.IntroActivityUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.IntroActivityUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 同乡会介绍——同乡会活动——活动内容详情
 * @Author Jessica
 * @Version v
 * @Date 2021/12/1
 */
@RestController
@RequestMapping("/admin/intro-activity-url")
public class IntroActivityUrlController {
    @Resource
    private IntroActivityUrlService introActivityUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = introActivityUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody IntroActivityUrlDto introActivityUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        introActivityUrlService.save(introActivityUrlDto);
        responseDto.setContent(introActivityUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        introActivityUrlService.delete(id);
        return responseDto;
    }
}
