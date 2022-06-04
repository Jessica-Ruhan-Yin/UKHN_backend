package com.UKHN.file.controller;

import com.UKHN_backend.server.dto.FileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.FileService;
import com.UKHN_backend.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;


/**
 * @Description 文件上传功能
 * @Author Jessica
 * @Version v
 * @Date 2021/11/9
 */
@RestController
@RequestMapping("/admin")
public class UploadController {

    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @Resource
    private FileService fileService;

    @Value("${file.domain}")
    private String FILE_DOMAIN;

    @Value("${file.path}")
    private String FILE_PATH;

    @RequestMapping("/upload/{cate}")
    public ResponseDto upload(@RequestParam MultipartFile file, @PathVariable String cate) throws IOException {
        LOG.info("上传文件开始");
        LOG.info(file.getOriginalFilename());
        LOG.info(String.valueOf(file.getSize()));

        // 保存文件到本地
        String fileName = file.getOriginalFilename();
        String key = UuidUtil.getShortUuid();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        String path = "home/intro/" + key + "." + suffix;
        String fullPath = FILE_PATH + path;
        File dest = new File(fullPath);
        file.transferTo(dest);
        LOG.info(dest.getAbsolutePath());

        //保存文件记录开始
        FileDto fileDto = new FileDto();
        fileDto.setPath(path);
        fileDto.setName(fileName);
        fileDto.setSize(Math.toIntExact(file.getSize()));
        fileDto.setSuffix(suffix);
        fileDto.setCategory(cate);
        fileService.save(fileDto);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(FILE_DOMAIN + path);
        return responseDto;
    }
}
