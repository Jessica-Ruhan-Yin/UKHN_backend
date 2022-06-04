package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.IntroActivityContentFile;
import com.UKHN_backend.server.domain.IntroActivityContentFileExample;
import com.UKHN_backend.server.dto.home.IntroActivityContentFileDto;
import com.UKHN_backend.server.mapper.IntroActivityContentFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@Service
public class IntroActivityContentFileService {
    @Resource
    private IntroActivityContentFileMapper introActivityContentFileMapper;

    /**
     * 列表查询
     */
    public List<IntroActivityContentFileDto> list(Long slideId) {
        IntroActivityContentFileExample example = new IntroActivityContentFileExample();
        IntroActivityContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<IntroActivityContentFile> fileList = introActivityContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, IntroActivityContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(IntroActivityContentFileDto introActivityContentFileDto) {
        IntroActivityContentFile introActivityContentFile = CopyUtil.copy(introActivityContentFileDto, IntroActivityContentFile.class);
        if (StringUtils.isEmpty(introActivityContentFileDto.getId())) {
            this.insert(introActivityContentFile);
        } else {
            this.update(introActivityContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(IntroActivityContentFile introActivityContentFile) {
        introActivityContentFileMapper.insert(introActivityContentFile);
    }

    /**
     * 更新
     */
    private void update(IntroActivityContentFile introActivityContentFile) {
        introActivityContentFileMapper.updateByPrimaryKey(introActivityContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        introActivityContentFileMapper.deleteByPrimaryKey(id);
    }
}
