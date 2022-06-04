package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeSendEmail;
import com.UKHN_backend.server.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2022/2/28
 */

@Service
public class HomeSendEmailService {

    @Resource
    private JavaMailSender javaMailSender;

    public ResponseDto send(HomeSendEmail homeSendEmail) throws MessagingException {
        ResponseDto responseDto = new ResponseDto();

//        try {
            SimpleMailMessage information = new SimpleMailMessage();
            String text = "名字："+homeSendEmail.getName()+
                "\n邮箱："+homeSendEmail.getEmail()+
                "\n手机号："+homeSendEmail.getPhone()+
                "\n公司："+homeSendEmail.getSubject()+
                "\n留言:"+homeSendEmail.getMessage();
            information.setFrom("ukhainan01@163.com"); //发送者
            information.setTo("ukhainan01@163.com");  //接受者
            information.setCc("ukhainan01@163.com"); //抄送，填发送者的邮箱即可
            information.setSubject("加入我们");	//主题
            information.setText(text);	//内容

            String replyText = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "    <meta charset=\"utf-8\">\n" + "    <title>Thank you</title>\n" +
                    "</head>\n" + "<body>\n" + "    <h2 class=\"text\">英国海南同乡联谊会</h2>\n" + "    <h5 class=\"text\">UK HAINAN ASSOCIATION</h5>\n" +
                    "    <div style=\"text-align: center;\">\n" + "        <img style=\"height: 150px;\"\n" + "            src=\"https://UKHN_backend-admin.oss-cn-hongkong.aliyuncs.com/home_collaboration/7X5aD33o.jpg?versionId=CAEQJhiBgMDC2oDr6xciIDQ0OTAyYzIwMDc5YzQ3MzVhZTI1YWE2NWQ4MThlMjJj\">\n" +
                    "    </div>\n" + "    <h3 class=\"text\">感谢您的投递，我们将尽快给予您答复！</h3>\n" +
                    "    <p class=\"text\">这里是英国海南同乡联谊会，致力于推动中英在海南省有关科技，<br>金融，商务，旅游，教育等领域的交流与合作，携手促进海南自贸港的建设与发展。</p>\n" +
                    "    <p class=\"text\" style=\"font-size: 12px;\">更多详情请查看：<a href=\"http://www.ukhainan.com/#/\">英国海南同乡联谊会官网</a></p>\n" +
                    "    <h3 class=\"text\">Thank you for your enquiry, we will reply you as soon as possible!</h3>\n" +
                    "    <p class=\"text\">This is UK HAINAN ASSOCIATION, which is committed to promoting the exchanges and cooperation <br>between China and the UK in the fields of science and technology, finance, business, tourism, education, etc.<br>in Hainan Province, and jointly promote the construction and development of Hainan Free Trade Port.</p>\n" +
                    "    <p class=\"text\" style=\"font-size: 12px;\">For more details, please see:<a href=\"http://www.ukhainan.com/#/\">UK HAINAN ASSOCIATION</a></p>\n" +
                    "</body>\n" + "</html>\n" + "<style>\n" + "    .text {\n" + "        text-align: center;\n" + "    }\n" + "</style>";
            MimeMessage reply = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(reply,true);
            mimeMessageHelper.setFrom("ukhainan01@163.com");
            mimeMessageHelper.setTo(homeSendEmail.getEmail());
            mimeMessageHelper.setSubject("英国海南同乡会");
            mimeMessageHelper.setText(replyText,true);

            javaMailSender.send(information);
            javaMailSender.send(reply);
            responseDto.setSuccess(true);
            responseDto.setMessage("发送成功");
//        }catch (Exception e) {
//            responseDto.setSuccess(false);
//            responseDto.setMessage("发送失败");
//        }
        return responseDto;
    }
}
