package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeAdDto;
import com.UKHN_backend.server.dto.home.HomeNewsContentDto;
import com.UKHN_backend.server.dto.home.HomeNewsDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeNewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——最新通告轮播图
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */

@RestController
@RequestMapping("/admin/home-news")
public class HomeNewsController {

    @Resource
    private HomeNewsService homeNewsService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto homeDto) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsService.list(homeDto);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeNewsDto homeDto) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsService.save(homeDto);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeNewsService.delete(id);
        return responseDto;
    }

    /**
     * 查找内容
     */
    @GetMapping("/find/{id}")
    public ResponseDto findContent(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        HomeNewsContentDto content = homeNewsService.findContent(id);
        responseDto.setContent(content);
        return responseDto;
    }


    /**
     * 保存内容，包含新增和修改
     */
    @PostMapping("/save/content")
    public ResponseDto saveContent(@RequestBody HomeNewsContentDto contentDto){
        ResponseDto responseDto = new ResponseDto();
        homeNewsService.saveContent(contentDto);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        HomeNewsDto content = homeNewsService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }


}
