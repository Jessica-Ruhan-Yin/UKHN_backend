package com.UKHN.file.controller;

import com.UKHN_backend.server.dto.FileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.enums.CategoryEnum;
import com.UKHN_backend.server.service.FileService;
import com.UKHN_backend.server.util.UuidUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/17
 */
@RestController
@RequestMapping("/admin")
public class OSSController {

    private static final Logger LOG = LoggerFactory.getLogger(OSSController.class);

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.bucket}")
    private String bucket;

    @Value("${oss.domain}")
    private String ossDomain;

    @Resource
    private FileService fileService;

    @PostMapping("/oss-upload/{cate}")
    public ResponseDto fileUpload(@RequestParam MultipartFile file, @PathVariable String cate) throws Exception {
        LOG.info("上传文件开始");
        CategoryEnum categoryEnum = CategoryEnum.getByCode(cate);
        String dir = categoryEnum.name().toLowerCase();
        String key = UuidUtil.getShortUuid();
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        String path = dir + "/" + key + "." + suffix;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, path, new ByteArrayInputStream(file.getBytes()));

        // 上传字符串。
        ossClient.putObject(putObjectRequest);

        ResponseDto responseDto = new ResponseDto();
        FileDto fileDto = new FileDto();
        fileDto.setPath(ossDomain + path);
        responseDto.setContent(fileDto);

        return responseDto;
    }
}
