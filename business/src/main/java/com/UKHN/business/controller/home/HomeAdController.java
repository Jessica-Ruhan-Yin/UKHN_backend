package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomeAdContentDto;
import com.UKHN_backend.server.dto.home.HomeAdDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.home.IntroActivitySlideDto;
import com.UKHN_backend.server.service.home.HomeAdService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——广告
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */

@RestController
@RequestMapping("/admin/home-ad")
public class HomeAdController {

    @Resource
    private HomeAdService homeAdService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto homeDto) {
        ResponseDto responseDto = new ResponseDto();
        homeAdService.list(homeDto);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomeAdDto homeDto) {
        ResponseDto responseDto = new ResponseDto();
        homeAdService.save(homeDto);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homeAdService.delete(id);
        return responseDto;
    }

    /**
     * 查找内容
     */
    @GetMapping("/find/{id}")
    public ResponseDto findContent(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        HomeAdContentDto content = homeAdService.findContent(id);
        responseDto.setContent(content);
        return responseDto;
    }


    /**
     * 保存内容，包含新增和修改
     */
    @PostMapping("/save/content")
    public ResponseDto saveContent(@RequestBody HomeAdContentDto contentDto){
        ResponseDto responseDto = new ResponseDto();
        homeAdService.saveContent(contentDto);
        return responseDto;
    }


    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        HomeAdDto content = homeAdService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
