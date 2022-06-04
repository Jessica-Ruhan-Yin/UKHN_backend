package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeNewsUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeNewsUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——最新通告轮播图链接
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-news-url")
public class HomeNewsUrlController {
    @Resource
    private HomeNewsUrlService homeNewsUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = homeNewsUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeNewsUrlDto homeNewsUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsUrlService.save(homeNewsUrlDto);
        responseDto.setContent(homeNewsUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsUrlService.delete(id);
        return responseDto;
    }
}
