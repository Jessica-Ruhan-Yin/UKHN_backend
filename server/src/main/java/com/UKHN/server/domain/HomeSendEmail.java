package com.UKHN.server.domain;

import lombok.Data;

import javax.validation.constraints.*;
/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2022/2/28
 */
@Data
public class HomeSendEmail {

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotBlank(message = "手机号码不能为空")
//    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "手机号格式错误")
    private String phone;

    @NotBlank(message = "公司不能为空")
    private String subject;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "个人信息不能为空")
    private String message;
}
