package com.UKHN.business.controller;

import com.UKHN_backend.server.domain.HomeSendEmail;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.home.HomeSendEmailService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.validation.Valid;

/**
 * @Description 发送邮箱功能
 * @Author Tiffany
 * @Version v
 * @Date 2022/2/28
 */

@RestController
@RequestMapping("/admin/send-email")
public class SendEmailController {

    @Resource
    private HomeSendEmailService homeSendEmailService;
    @PostMapping(value = "/send")
    public ResponseDto send(@RequestBody @Valid HomeSendEmail homeSendEmail,BindingResult results) throws MessagingException, MessagingException {
        ResponseDto responseDto = new ResponseDto();
        if (results.hasErrors()){
            responseDto.setSuccess(false);
            responseDto.setMessage(results.getFieldError().getDefaultMessage());
            return responseDto;
        }

        return homeSendEmailService.send(homeSendEmail);
    }


}
