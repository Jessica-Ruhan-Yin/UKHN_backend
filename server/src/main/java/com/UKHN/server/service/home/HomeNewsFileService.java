package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeNewsFile;
import com.UKHN_backend.server.domain.HomeNewsFileExample;
import com.UKHN_backend.server.dto.home.HomeNewsFileDto;
import com.UKHN_backend.server.mapper.HomeNewsFileMapper;
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
public class HomeNewsFileService {
    @Resource
    private HomeNewsFileMapper homeNewsFileMapper;

    /**
     * 列表查询
     */
    public List<HomeNewsFileDto> list(Long newsId) {
        HomeNewsFileExample example = new HomeNewsFileExample();
        HomeNewsFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(newsId);
        List<HomeNewsFile> fileList = homeNewsFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, HomeNewsFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(HomeNewsFileDto homeNewsFileDto) {
        HomeNewsFile homeNewsFile = CopyUtil.copy(homeNewsFileDto, HomeNewsFile.class);
        if (StringUtils.isEmpty(homeNewsFileDto.getId())) {
            this.insert(homeNewsFile);
        } else {
            this.update(homeNewsFile);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeNewsFile homeNewsFile) {
        homeNewsFileMapper.insert(homeNewsFile);
    }

    /**
     * 更新
     */
    private void update(HomeNewsFile homeNewsFile) {
        homeNewsFileMapper.updateByPrimaryKey(homeNewsFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeNewsFileMapper.deleteByPrimaryKey(id);
    }
}
