package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeNewsContent;
import com.UKHN_backend.server.domain.HomeNewsContentExample;
import com.UKHN_backend.server.dto.home.HomeNewsContentDto;
import com.UKHN_backend.server.mapper.CustMapper.HomeNewsCust;
import com.UKHN_backend.server.mapper.HomeNewsContentMapper;
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
public class HomeNewsContentService {
    @Resource
    private HomeNewsContentMapper homeNewsContentMapper;

    @Resource
    private HomeNewsCust homeNewsCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public HomeNewsContentDto list(Long id){
        HomeNewsContent content = homeNewsContentMapper.selectByPrimaryKey(id);
        homeNewsCust.increaseViewCount(id);
        HomeNewsContentDto contentDto = new HomeNewsContentDto();
        if (ObjectUtils.isEmpty(content.getContent())){
            contentDto.setContent("");
            contentDto.setView(content.getView());
            return contentDto;
        }else {
            contentDto.setContent(content.getContent());
            contentDto.setView(content.getView());
            return contentDto;
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(HomeNewsContentDto homeNewsContentDto) {
        HomeNewsContent homeNewsContent = CopyUtil.copy(homeNewsContentDto, HomeNewsContent.class);
        HomeNewsContentExample example = new HomeNewsContentExample();
        example.createCriteria().andIdEqualTo(homeNewsContentDto.getId());
        List<HomeNewsContent> list = homeNewsContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(homeNewsContent);
        } else {
            this.update(homeNewsContent);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeNewsContent homeNewsContent) {

        homeNewsContentMapper.insert(homeNewsContent);
    }

    /**
     * 更新
     */
    private void update(HomeNewsContent homeNewsContent) {
        homeNewsContentMapper.updateByPrimaryKeyWithBLOBs(homeNewsContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeNewsContentMapper.deleteByPrimaryKey(id);
    }
}