package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeAdFile;
import com.UKHN_backend.server.domain.HomeAdFileExample;
import com.UKHN_backend.server.dto.home.HomeAdFileDto;
import com.UKHN_backend.server.mapper.HomeAdFileMapper;
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
public class HomeAdFileService {
    @Resource
    private HomeAdFileMapper homeAdFileMapper;

    /**
     * 列表查询
     */
    public List<HomeAdFileDto> list(Long adId) {
        HomeAdFileExample example = new HomeAdFileExample();
        HomeAdFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(adId);
        List<HomeAdFile> fileList = homeAdFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, HomeAdFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(HomeAdFileDto homeAdFileDto) {
        HomeAdFile homeAdFile = CopyUtil.copy(homeAdFileDto, HomeAdFile.class);
        if (StringUtils.isEmpty(homeAdFileDto.getId())) {
            this.insert(homeAdFile);
        } else {
            this.update(homeAdFile);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeAdFile homeAdFile) {
        homeAdFileMapper.insert(homeAdFile);
    }

    /**
     * 更新
     */
    private void update(HomeAdFile homeAdFile) {
        homeAdFileMapper.updateByPrimaryKey(homeAdFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeAdFileMapper.deleteByPrimaryKey(id);
    }
}
