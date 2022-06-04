package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeAdUrl;
import com.UKHN_backend.server.domain.HomeAdUrlExample;
import com.UKHN_backend.server.dto.home.HomeAdUrlDto;
import com.UKHN_backend.server.mapper.HomeAdUrlMapper;
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
public class HomeAdUrlService {
    @Resource
    private HomeAdUrlMapper homeAdUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        HomeAdUrl url = homeAdUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(HomeAdUrlDto homeAdUrlDto) {
        HomeAdUrl homeAdUrl = CopyUtil.copy(homeAdUrlDto, HomeAdUrl.class);
        HomeAdUrlExample example = new HomeAdUrlExample();
        example.createCriteria().andIdEqualTo(homeAdUrlDto.getId());
        List<HomeAdUrl> list = homeAdUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(homeAdUrl);
        } else {
            this.update(homeAdUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeAdUrl homeAdUrl) {

        homeAdUrlMapper.insert(homeAdUrl);
    }

    /**
     * 更新
     */
    private void update(HomeAdUrl homeAdUrl) {
        homeAdUrlMapper.updateByPrimaryKey(homeAdUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeAdUrlMapper.deleteByPrimaryKey(id);
    }
}