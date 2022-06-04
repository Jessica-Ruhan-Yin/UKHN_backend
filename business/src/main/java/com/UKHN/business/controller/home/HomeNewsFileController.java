package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeNewsFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeNewsFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 首页——最新通告轮播图详情文件
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@RestController
@RequestMapping("/admin/home-news-file")
public class HomeNewsFileController {

    @Resource
    private HomeNewsFileService homeNewsFileService;

    @GetMapping("/list/{slideId}")
    public ResponseDto list(@PathVariable Long slideId) {
        ResponseDto responseDto = new ResponseDto();
        List<HomeNewsFileDto> fileDtoList = homeNewsFileService.list(slideId);
        responseDto.setContent(fileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeNewsFileDto homeNewsFileDto) {

        ResponseDto responseDto = new ResponseDto();
        homeNewsFileService.save(homeNewsFileDto);
        responseDto.setContent(homeNewsFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsFileService.delete(id);
        return responseDto;
    }
}

