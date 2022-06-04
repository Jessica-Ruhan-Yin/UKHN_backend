package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeNewsUrl;
import com.UKHN_backend.server.domain.HomeNewsUrlExample;
import com.UKHN_backend.server.dto.home.HomeNewsUrlDto;
import com.UKHN_backend.server.mapper.HomeNewsUrlMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@Service
public class HomeNewsUrlService {
    @Resource
    private HomeNewsUrlMapper homeNewsUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        HomeNewsUrl url = homeNewsUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(HomeNewsUrlDto homeNewsUrlDto) {
        HomeNewsUrl homeNewsUrl = CopyUtil.copy(homeNewsUrlDto, HomeNewsUrl.class);
        HomeNewsUrlExample example = new HomeNewsUrlExample();
        example.createCriteria().andIdEqualTo(homeNewsUrlDto.getId());
        List<HomeNewsUrl> list = homeNewsUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(homeNewsUrl);
        } else {
            this.update(homeNewsUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeNewsUrl homeNewsUrl) {

        homeNewsUrlMapper.insert(homeNewsUrl);
    }

    /**
     * 更新
     */
    private void update(HomeNewsUrl homeNewsUrl) {
        homeNewsUrlMapper.updateByPrimaryKey(homeNewsUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeNewsUrlMapper.deleteByPrimaryKey(id);
    }
}