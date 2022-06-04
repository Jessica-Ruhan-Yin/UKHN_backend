package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeAdContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeAdContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——广告轮播图详情
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-ad-content")
public class HomeAdContentController {
    @Resource
    private HomeAdContentService homeAdContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        HomeAdContentDto content = homeAdContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeAdContentDto homeAdContentDto) {
        ResponseDto responseDto = new ResponseDto();
        homeAdContentService.save(homeAdContentDto);
        responseDto.setContent(homeAdContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeAdContentService.delete(id);
        return responseDto;
    }
}
