package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.IntroActivityContentDto;
import com.UKHN_backend.server.dto.home.IntroActivitySlideDto;
import com.UKHN_backend.server.dto.home.IntroActivitySlidePageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.IntroActivitySlideService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 同乡会介绍——同乡会活动部分轮播图
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin")
public class IntroActivitySlideController {

    @Resource
    private IntroActivitySlideService introActivitySlideService;

    @PostMapping("/intro-activity-slide/list")
    public ResponseDto list(@RequestBody IntroActivitySlidePageDto introActivityDto) {
        ResponseDto responseDto = new ResponseDto();
        introActivitySlideService.list(introActivityDto);
        responseDto.setContent(introActivityDto);
        return responseDto;
    }

    @PostMapping("/intro-activity-slide/save")
    public ResponseDto save(@RequestBody IntroActivitySlideDto introActivityDto) {
        ResponseDto responseDto = new ResponseDto();
        introActivitySlideService.save(introActivityDto);
        responseDto.setContent(introActivityDto);
        return responseDto;
    }

    @DeleteMapping("/intro-activity-slide/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        introActivitySlideService.delete(id);
        return responseDto;
    }

    /**
     * 查找内容
     */
    @GetMapping("/find-intro-activity-content/show/{id}")
    public ResponseDto findContent(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        IntroActivityContentDto content = introActivitySlideService.findContent(id);
        responseDto.setContent(content);
        return responseDto;
    }


    /**
     * 保存内容，包含新增和修改
     */
    @PostMapping("/save-intro-activity-content")
    public ResponseDto saveContent(@RequestBody IntroActivityContentDto contentDto){
        ResponseDto responseDto = new ResponseDto();
        introActivitySlideService.saveContent(contentDto);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/intro-activity/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        IntroActivitySlideDto content = introActivitySlideService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
