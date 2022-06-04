package com.UKHN.business.controller;


import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.ViewDto;
import com.UKHN_backend.server.service.ViewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description 首页访问量
 */
@RestController
@RequestMapping("/admin/view")
public class ViewController {

    @Resource
    ViewService viewService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        ViewDto content = viewService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
