package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationCUI;
import com.UKHN_backend.server.domain.CollaborationCUIContent;
import com.UKHN_backend.server.domain.CollaborationCUIExample;
import com.UKHN_backend.server.domain.CollaborationCUI;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIPageDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIDto;
import com.UKHN_backend.server.mapper.CollaborationCUIContentMapper;
import com.UKHN_backend.server.mapper.CollaborationCUIMapper;
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
public class CollaborationCUIService {

    private static final Logger LOG = LoggerFactory.getLogger(CollaborationCUIService.class);

    @Resource
    private CollaborationCUIMapper collaborationCUIMapper;

    @Resource
    private CollaborationCUIContentMapper collaborationCUIContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(CollaborationCUIPageDto req) {
        CollaborationCUIExample collaborationCUIExample = new CollaborationCUIExample();
        collaborationCUIExample.setOrderByClause("id desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<CollaborationCUI> collaborationCUIList = collaborationCUIMapper.selectByExample(collaborationCUIExample);

        PageInfo<CollaborationCUI> pageInfo = new PageInfo<>(collaborationCUIList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<CollaborationCUIDto> collaborationCUIDtoList = CopyUtil.copyList(collaborationCUIList, CollaborationCUIDto.class);
        req.setList(collaborationCUIDtoList);
    }

    /**
     * 保存
     */
    public void save(CollaborationCUIDto collaborationCUIDto) {
        CollaborationCUI collaborationCUI = CopyUtil.copy(collaborationCUIDto, CollaborationCUI.class);
        if (StringUtils.isEmpty(collaborationCUIDto.getId())) {
            this.insert(collaborationCUI);
        } else {
            this.update(collaborationCUI);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationCUI collaborationCUI) {
        collaborationCUIMapper.insert(collaborationCUI);
    }

    /**
     * 更新
     */
    private void update(CollaborationCUI collaborationCUI) {
        collaborationCUIMapper.updateByPrimaryKeySelective(collaborationCUI);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationCUIMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public CollaborationCUIContentDto findContent(Long id) {
        CollaborationCUIContent content = collaborationCUIContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CollaborationCUIContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(CollaborationCUIContentDto contentDto) {
        CollaborationCUIContent content = CopyUtil.copy(contentDto, CollaborationCUIContent.class);
        int i = collaborationCUIContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = collaborationCUIContentMapper.insert(content);
        }
        return i;
    }

    public CollaborationCUIDto searchItem(Long id) {
        CollaborationCUI collaborationCUI = collaborationCUIMapper.selectByPrimaryKey(id);
        CollaborationCUIDto collaborationCUIDto = CopyUtil.copy(collaborationCUI,CollaborationCUIDto.class);
        return collaborationCUIDto;
    }
}
