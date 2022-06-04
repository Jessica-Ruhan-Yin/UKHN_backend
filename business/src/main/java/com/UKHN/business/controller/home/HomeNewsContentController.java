package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeNewsContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeNewsContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——最新通告轮播图详情
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-news-content")
public class HomeNewsContentController {
    @Resource
    private HomeNewsContentService homeNewsContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        HomeNewsContentDto content = homeNewsContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeNewsContentDto homeNewsContentDto) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsContentService.save(homeNewsContentDto);
        responseDto.setContent(homeNewsContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsContentService.delete(id);
        return responseDto;
    }
}
