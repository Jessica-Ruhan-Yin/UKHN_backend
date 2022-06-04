package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomeAdContent;
import com.UKHN_backend.server.domain.HomeAdContentExample;
import com.UKHN_backend.server.dto.home.HomeAdContentDto;
import com.UKHN_backend.server.mapper.CustMapper.HomeAdCust;
import com.UKHN_backend.server.mapper.HomeAdContentMapper;
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
public class HomeAdContentService {
    @Resource
    private HomeAdContentMapper homeAdContentMapper;

    @Resource
    private HomeAdCust homeAdCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public HomeAdContentDto list(Long id){
        HomeAdContent content = homeAdContentMapper.selectByPrimaryKey(id);
        homeAdCust.increaseViewCount(id);
        HomeAdContentDto contentDto = new HomeAdContentDto();
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
    public void save(HomeAdContentDto homeAdContentDto) {
        HomeAdContent homeAdContent = CopyUtil.copy(homeAdContentDto, HomeAdContent.class);
        HomeAdContentExample example = new HomeAdContentExample();
        example.createCriteria().andIdEqualTo(homeAdContentDto.getId());
        List<HomeAdContent> list = homeAdContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(homeAdContent);
        } else {
            this.update(homeAdContent);
        }
    }

    /**
     * 新增
     */
    private void insert(HomeAdContent homeAdContent) {

        homeAdContentMapper.insert(homeAdContent);
    }

    /**
     * 更新
     */
    private void update(HomeAdContent homeAdContent) {
        homeAdContentMapper.updateByPrimaryKeyWithBLOBs(homeAdContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homeAdContentMapper.deleteByPrimaryKey(id);
    }
}