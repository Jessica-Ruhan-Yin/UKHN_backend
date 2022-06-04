package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationChina;
import com.UKHN_backend.server.domain.CollaborationChinaContent;
import com.UKHN_backend.server.domain.CollaborationChinaExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaDto;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaPageDto;
import com.UKHN_backend.server.mapper.CollaborationChinaContentMapper;
import com.UKHN_backend.server.mapper.CollaborationChinaMapper;
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
public class CollaborationChinaService {

    private static final Logger LOG = LoggerFactory.getLogger(CollaborationChinaService.class);

    @Resource
    private CollaborationChinaMapper collaborationChinaMapper;

    @Resource
    private CollaborationChinaContentMapper collaborationChinaContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(CollaborationChinaPageDto req) {
        CollaborationChinaExample collaborationChinaExample = new CollaborationChinaExample();
        collaborationChinaExample.setOrderByClause("id desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<CollaborationChina> collaborationChinaList = collaborationChinaMapper.selectByExample(collaborationChinaExample);

        PageInfo<CollaborationChina> pageInfo = new PageInfo<>(collaborationChinaList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<CollaborationChinaDto> collaborationChinaDtoList = CopyUtil.copyList(collaborationChinaList, CollaborationChinaDto.class);
        req.setList(collaborationChinaDtoList);
    }

    /**
     * 保存
     */
    public void save(CollaborationChinaDto collaborationChinaDto) {
        CollaborationChina collaborationChina = CopyUtil.copy(collaborationChinaDto, CollaborationChina.class);
        if (StringUtils.isEmpty(collaborationChinaDto.getId())) {
            this.insert(collaborationChina);
        } else {
            this.update(collaborationChina);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationChina collaborationChina) {
        collaborationChinaMapper.insert(collaborationChina);
    }

    /**
     * 更新
     */
    private void update(CollaborationChina collaborationChina) {
        collaborationChinaMapper.updateByPrimaryKeySelective(collaborationChina);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationChinaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public CollaborationChinaContentDto findContent(Long id) {
        CollaborationChinaContent content = collaborationChinaContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CollaborationChinaContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(CollaborationChinaContentDto contentDto) {
        CollaborationChinaContent content = CopyUtil.copy(contentDto, CollaborationChinaContent.class);
        int i = collaborationChinaContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = collaborationChinaContentMapper.insert(content);
        }
        return i;
    }

    public CollaborationChinaDto searchItem(Long id) {
        CollaborationChina collaborationChina = collaborationChinaMapper.selectByPrimaryKey(id);
        CollaborationChinaDto collaborationChinaDto = CopyUtil.copy(collaborationChina,CollaborationChinaDto.class);
        return collaborationChinaDto;
    }
}
