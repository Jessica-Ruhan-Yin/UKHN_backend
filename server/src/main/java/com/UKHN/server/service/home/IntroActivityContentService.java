package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.IntroActivityContent;
import com.UKHN_backend.server.domain.IntroActivityContentExample;
import com.UKHN_backend.server.dto.home.IntroActivityContentDto;
import com.UKHN_backend.server.mapper.CustMapper.IntroActCust;
import com.UKHN_backend.server.mapper.IntroActivityContentMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@Service
public class IntroActivityContentService {
    @Resource
    private IntroActivityContentMapper introActivityContentMapper;

    @Resource
    private IntroActCust introActCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public IntroActivityContentDto list(Long id){
        IntroActivityContent content = introActivityContentMapper.selectByPrimaryKey(id);
        introActCust.increaseViewCount(id);
        IntroActivityContentDto contentDto = new IntroActivityContentDto();
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
    public void save(IntroActivityContentDto introActivityContentDto) {
        IntroActivityContent introActivityContent = CopyUtil.copy(introActivityContentDto, IntroActivityContent.class);
        IntroActivityContentExample example = new IntroActivityContentExample();
        example.createCriteria().andIdEqualTo(introActivityContentDto.getId());
        List<IntroActivityContent> list = introActivityContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(introActivityContent);
        } else {
            this.update(introActivityContent);
        }
    }

    /**
     * 新增
     */
    private void insert(IntroActivityContent introActivityContent) {

        introActivityContentMapper.insert(introActivityContent);
    }

    /**
     * 更新
     */
    private void update(IntroActivityContent introActivityContent) {
        introActivityContentMapper.updateByPrimaryKeyWithBLOBs(introActivityContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        introActivityContentMapper.deleteByPrimaryKey(id);
    }
}