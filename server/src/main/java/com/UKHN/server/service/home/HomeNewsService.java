package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeNews;
import com.UKHN_backend.server.domain.HomeNewsContent;
import com.UKHN_backend.server.domain.HomeNewsExample;
import com.UKHN_backend.server.dto.home.HomeNewsDto;
import com.UKHN_backend.server.dto.home.HomeNewsContentDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.HomeNewsContentMapper;
import com.UKHN_backend.server.mapper.HomeNewsMapper;
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
public class HomeNewsService {

    private static final Logger LOG = LoggerFactory.getLogger(HomeNewsService.class);

    @Resource
    private HomeNewsMapper homeNewsMapper;

    @Resource
    private HomeNewsContentMapper homeNewsContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(PageDto req) {
        HomeNewsExample homeNewsExample = new HomeNewsExample();
        homeNewsExample.setOrderByClause("date desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<HomeNews> homeNewsList = homeNewsMapper.selectByExample(homeNewsExample);

        PageInfo<HomeNews> pageInfo = new PageInfo<>(homeNewsList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<HomeNewsDto> homeNewsDtoList = CopyUtil.copyList(homeNewsList, HomeNewsDto.class);
        req.setList(homeNewsDtoList);
    }

    /**
     * 保存
     */
    public void save(HomeNewsDto homeNewsDto) {
        HomeNews homeNews = CopyUtil.copy(homeNewsDto, HomeNews.class);
        if (StringUtils.isEmpty(homeNewsDto.getId())) {
            this.insert(homeNews);
        } else {
            this.update(homeNews);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeNews homeNews) {
        homeNewsMapper.insert(homeNews);
    }

    /**
     * 更新
     */
    private void update(HomeNews homeNews) {
        homeNewsMapper.updateByPrimaryKeySelective(homeNews);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeNewsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public HomeNewsContentDto findContent(Long id) {
        HomeNewsContent content = homeNewsContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, HomeNewsContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(HomeNewsContentDto contentDto) {
        HomeNewsContent content = CopyUtil.copy(contentDto, HomeNewsContent.class);
        int i = homeNewsContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = homeNewsContentMapper.insert(content);
        }
        return i;
    }

    public HomeNewsDto searchItem(Long id) {
        HomeNews homeNews = homeNewsMapper.selectByPrimaryKey(id);
        HomeNewsDto homeNewsDto = CopyUtil.copy(homeNews,HomeNewsDto.class);
        return homeNewsDto;
    }
}
