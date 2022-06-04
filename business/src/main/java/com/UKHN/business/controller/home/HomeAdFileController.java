package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeAdFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeAdFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 首页——广告轮播图详情文件
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-ad-file")
public class HomeAdFileController {

    @Resource
    private HomeAdFileService homeAdFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<HomeAdFileDto> fileDtoList = homeAdFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeAdFileDto homeAdFileDto) {

        ResponseDto responseDto = new ResponseDto();
        homeAdFileService.save(homeAdFileDto);
        responseDto.setContent(homeAdFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeAdFileService.delete(id);
        return responseDto;
    }
}

