package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeAdUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeAdUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——广告轮播图链接
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-ad-url")
public class HomeAdUrlController {
    @Resource
    private HomeAdUrlService homeAdUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = homeAdUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeAdUrlDto homeAdUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        homeAdUrlService.save(homeAdUrlDto);
        responseDto.setContent(homeAdUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeAdUrlService.delete(id);
        return responseDto;
    }
}
