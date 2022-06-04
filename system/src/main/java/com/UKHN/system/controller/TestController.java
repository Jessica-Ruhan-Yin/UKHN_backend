package com.UKHN.system.controller;

import com.UKHN_backend.server.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试controller
 * @Author Jessica
 * @Version v
 * @Date 2021/11/2
 */
@RestController
public class TestController {

//    @Value("${system.test}")
    private String systemTest;

    @GetMapping("/test")
    public ResponseDto list(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(systemTest);
        return responseDto;
    }
}
