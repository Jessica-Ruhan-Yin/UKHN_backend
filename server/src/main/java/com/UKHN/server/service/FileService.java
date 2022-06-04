package com.UKHN.server.service;


import com.UKHN_backend.server.domain.File;
import com.UKHN_backend.server.domain.FileExample;
import com.UKHN_backend.server.dto.FileDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.FileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    @Resource
    private FileMapper fileMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        FileExample fileExample = new FileExample();
        List<File> fileList = fileMapper.selectByExample(fileExample);
        PageInfo<File> pageInfo = new PageInfo<>(fileList);
        pageDto.setTotal(pageInfo.getTotal());
        List<FileDto> fileDtoList = CopyUtil.copyList(fileList, FileDto.class);
        pageDto.setList(fileDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(FileDto fileDto) {
        File file = CopyUtil.copy(fileDto, File.class);
        File fileDb = fileMapper.selectByPrimaryKey(fileDto.getId());
        if (fileDb == null) {
            this.insert(file);
        } else {
            this.update(fileDb);
        }
    }

    /**
     * 新增
     */
    private void insert(File file) {

        Date now = new Date();
        file.setCreatedAt(now);
        file.setUpdatedAt(now);
        fileMapper.insert(file);
    }

    /**
     * 更新
     */
    private void update(File file) {
        file.setUpdatedAt(new Date());
        fileMapper.updateByPrimaryKey(file);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        fileMapper.deleteByPrimaryKey(id);
    }


}