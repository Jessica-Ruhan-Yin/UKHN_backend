package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeAd;
import com.UKHN_backend.server.domain.HomeAdContent;
import com.UKHN_backend.server.domain.HomeAdExample;
import com.UKHN_backend.server.domain.HomeAd;
import com.UKHN_backend.server.dto.home.HomeAdContentDto;
import com.UKHN_backend.server.dto.home.HomeAdDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.home.HomeAdDto;
import com.UKHN_backend.server.mapper.HomeAdContentMapper;
import com.UKHN_backend.server.mapper.HomeAdMapper;
import com.UKHN_backend.server.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2021/12/12
 */
@Service
public class HomeAdService {

    private static final Logger LOG = LoggerFactory.getLogger(HomeAdService.class);

    @Resource
    private HomeAdMapper homeAdMapper;

    @Resource
    private HomeAdContentMapper homeAdContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(PageDto req) {
        HomeAdExample homeAdExample = new HomeAdExample();
        homeAdExample.setOrderByClause("date desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<HomeAd> homeAdList = homeAdMapper.selectByExample(homeAdExample);

        PageInfo<HomeAd> pageInfo = new PageInfo<>(homeAdList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<HomeAdDto> homeAdDtoList = CopyUtil.copyList(homeAdList, HomeAdDto.class);
        req.setList(homeAdDtoList);
    }

    /**
     * 保存
     */
    public void save(HomeAdDto homeAdDto) {
        HomeAd homeAd = CopyUtil.copy(homeAdDto, HomeAd.class);
        if (StringUtils.isEmpty(homeAdDto.getId())) {
            this.insert(homeAd);
        } else {
            this.update(homeAd);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeAd homeAd) {
        homeAdMapper.insert(homeAd);
    }

    /**
     * 更新
     */
    private void update(HomeAd homeAd) {
        homeAdMapper.updateByPrimaryKeySelective(homeAd);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeAdMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public HomeAdContentDto findContent(Long id) {
        HomeAdContent content = homeAdContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, HomeAdContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(HomeAdContentDto contentDto) {
        HomeAdContent content = CopyUtil.copy(contentDto, HomeAdContent.class);
        int i = homeAdContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = homeAdContentMapper.insert(content);
        }
        return i;
    }

    public HomeAdDto searchItem(Long id) {
        HomeAd homeAd = homeAdMapper.selectByPrimaryKey(id);
        HomeAdDto homeAdDto = CopyUtil.copy(homeAd,HomeAdDto.class);
        return homeAdDto;
    }
}
