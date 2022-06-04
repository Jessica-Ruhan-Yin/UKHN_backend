package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationUKIreland;
import com.UKHN_backend.server.domain.CollaborationUKIreland;
import com.UKHN_backend.server.domain.CollaborationUKIrelandContent;
import com.UKHN_backend.server.domain.CollaborationUKIrelandExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandPageDto;
import com.UKHN_backend.server.mapper.CollaborationUKIrelandContentMapper;
import com.UKHN_backend.server.mapper.CollaborationUKIrelandMapper;
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
public class CollaborationUKIrelandService {

    private static final Logger LOG = LoggerFactory.getLogger(CollaborationUKIrelandService.class);

    @Resource
    private CollaborationUKIrelandMapper collaborationUKIrelandMapper;

    @Resource
    private CollaborationUKIrelandContentMapper collaborationUKIrelandContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(CollaborationUKIrelandPageDto req) {
        CollaborationUKIrelandExample collaborationUKIrelandExample = new CollaborationUKIrelandExample();
        collaborationUKIrelandExample.setOrderByClause("id desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<CollaborationUKIreland> collaborationUKIrelandList = collaborationUKIrelandMapper.selectByExample(collaborationUKIrelandExample);

        PageInfo<CollaborationUKIreland> pageInfo = new PageInfo<>(collaborationUKIrelandList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<CollaborationUKIrelandDto> collaborationUKIrelandDtoList = CopyUtil.copyList(collaborationUKIrelandList, CollaborationUKIrelandDto.class);
        req.setList(collaborationUKIrelandDtoList);
    }

    /**
     * 保存
     */
    public void save(CollaborationUKIrelandDto collaborationUKIrelandDto) {
        CollaborationUKIreland collaborationUKIreland = CopyUtil.copy(collaborationUKIrelandDto, CollaborationUKIreland.class);
        if (StringUtils.isEmpty(collaborationUKIrelandDto.getId())) {
            this.insert(collaborationUKIreland);
        } else {
            this.update(collaborationUKIreland);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationUKIreland collaborationUKIreland) {
        collaborationUKIrelandMapper.insert(collaborationUKIreland);
    }

    /**
     * 更新
     */
    private void update(CollaborationUKIreland collaborationUKIreland) {
        collaborationUKIrelandMapper.updateByPrimaryKeySelective(collaborationUKIreland);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationUKIrelandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public CollaborationUKIrelandContentDto findContent(Long id) {
        CollaborationUKIrelandContent content = collaborationUKIrelandContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CollaborationUKIrelandContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(CollaborationUKIrelandContentDto contentDto) {
        CollaborationUKIrelandContent content = CopyUtil.copy(contentDto, CollaborationUKIrelandContent.class);
        int i = collaborationUKIrelandContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = collaborationUKIrelandContentMapper.insert(content);
        }
        return i;
    }

    public CollaborationUKIrelandDto searchItem(Long id) {
        CollaborationUKIreland collaborationUKIreland = collaborationUKIrelandMapper.selectByPrimaryKey(id);
        CollaborationUKIrelandDto collaborationUKIrelandDto = CopyUtil.copy(collaborationUKIreland,CollaborationUKIrelandDto.class);
        return collaborationUKIrelandDto;
    }
}
