package com.UKHN.business.controller.home;

import com.UKHN_backend.server.dto.home.HomePartnersDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomePartnersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 首页——合作机构
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */

@RestController
@RequestMapping("/admin/home-partners")
public class HomePartnersController {

    @Resource
    private HomePartnersService homePartnersService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto homeDto) {
        ResponseDto responseDto = new ResponseDto();
        homePartnersService.list(homeDto);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @PostMapping("/list-type/{type}")
    public ResponseDto listType(@RequestBody PageDto homeDto, @PathVariable String type) {
        ResponseDto responseDto = new ResponseDto();
        homePartnersService.listType(homeDto,type);
        responseDto.setContent(homeDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody HomePartnersDto homePartnersDto) {
        ResponseDto responseDto = new ResponseDto();
        homePartnersService.save(homePartnersDto);
        responseDto.setContent(homePartnersDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        homePartnersService.delete(id);
        return responseDto;
    }
    
}
