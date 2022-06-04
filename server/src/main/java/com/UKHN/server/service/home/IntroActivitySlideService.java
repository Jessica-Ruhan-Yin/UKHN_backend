package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.IntroActivityContent;
import com.UKHN_backend.server.domain.IntroActivitySlide;
import com.UKHN_backend.server.domain.IntroActivitySlideExample;
import com.UKHN_backend.server.dto.home.IntroActivityContentDto;
import com.UKHN_backend.server.dto.home.IntroActivitySlideDto;
import com.UKHN_backend.server.dto.home.IntroActivitySlidePageDto;
import com.UKHN_backend.server.mapper.IntroActivityContentMapper;
import com.UKHN_backend.server.mapper.IntroActivitySlideMapper;
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
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */
@Service
public class IntroActivitySlideService {

    private static final Logger LOG = LoggerFactory.getLogger(IntroActivitySlideService.class);

    @Resource
    private IntroActivitySlideMapper introActivitySlideMapper;

    @Resource
    private IntroActivityContentMapper introActivityContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(IntroActivitySlidePageDto req) {
        IntroActivitySlideExample introActivitySlideExample = new IntroActivitySlideExample();
        introActivitySlideExample.setOrderByClause("date desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<IntroActivitySlide> introActivitySlideList = introActivitySlideMapper.selectByExample(introActivitySlideExample);

        PageInfo<IntroActivitySlide> pageInfo = new PageInfo<>(introActivitySlideList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<IntroActivitySlideDto> introActivitySlideDtoList = CopyUtil.copyList(introActivitySlideList, IntroActivitySlideDto.class);
        req.setList(introActivitySlideDtoList);
    }

    /**
     * 保存
     */
    public void save(IntroActivitySlideDto introActivitySlideDto) {
        IntroActivitySlide introActivitySlide = CopyUtil.copy(introActivitySlideDto, IntroActivitySlide.class);
        if (StringUtils.isEmpty(introActivitySlideDto.getId())) {
            this.insert(introActivitySlide);
        } else {
            this.update(introActivitySlide);
        }
    }

    /**
     * 新增
     */
    private void insert(IntroActivitySlide introActivitySlide) {
        introActivitySlideMapper.insert(introActivitySlide);
    }

    /**
     * 更新
     */
    private void update(IntroActivitySlide introActivitySlide) {
        introActivitySlideMapper.updateByPrimaryKeySelective(introActivitySlide);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        introActivitySlideMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public IntroActivityContentDto findContent(Long id) {
        IntroActivityContent content = introActivityContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, IntroActivityContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(IntroActivityContentDto contentDto) {
        IntroActivityContent content = CopyUtil.copy(contentDto, IntroActivityContent.class);
        int i = introActivityContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = introActivityContentMapper.insert(content);
        }
        return i;
    }

    public IntroActivitySlideDto searchItem(Long id) {
        IntroActivitySlide introActivitySlide = introActivitySlideMapper.selectByPrimaryKey(id);
        IntroActivitySlideDto introActivitySlideDto = CopyUtil.copy(introActivitySlide,IntroActivitySlideDto.class);
        return introActivitySlideDto;
    }
}
