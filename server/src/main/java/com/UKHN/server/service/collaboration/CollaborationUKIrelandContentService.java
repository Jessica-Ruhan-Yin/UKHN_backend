package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationUKIrelandContent;
import com.UKHN_backend.server.domain.CollaborationUKIrelandContentExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentDto;
import com.UKHN_backend.server.mapper.CollaborationUKIrelandContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.CollaUKICust;
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
public class CollaborationUKIrelandContentService {
    @Resource
    private CollaborationUKIrelandContentMapper collaborationUKIrelandContentMapper;

    @Resource
    private CollaUKICust collaUKICust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public CollaborationUKIrelandContentDto list(Long id){
        CollaborationUKIrelandContent content = collaborationUKIrelandContentMapper.selectByPrimaryKey(id);
        collaUKICust.increaseViewCount(id);
        CollaborationUKIrelandContentDto contentDto = new CollaborationUKIrelandContentDto();
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
    public void save(CollaborationUKIrelandContentDto collaborationUKIrelandContentDto) {
        CollaborationUKIrelandContent collaborationUKIrelandContent = CopyUtil.copy(collaborationUKIrelandContentDto, CollaborationUKIrelandContent.class);
        CollaborationUKIrelandContentExample example = new CollaborationUKIrelandContentExample();
        example.createCriteria().andIdEqualTo(collaborationUKIrelandContentDto.getId());
        List<CollaborationUKIrelandContent> list = collaborationUKIrelandContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationUKIrelandContent);
        } else {
            this.update(collaborationUKIrelandContent);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationUKIrelandContent collaborationUKIrelandContent) {

        collaborationUKIrelandContentMapper.insert(collaborationUKIrelandContent);
    }

    /**
     * 更新
     */
    private void update(CollaborationUKIrelandContent collaborationUKIrelandContent) {
        collaborationUKIrelandContentMapper.updateByPrimaryKeyWithBLOBs(collaborationUKIrelandContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationUKIrelandContentMapper.deleteByPrimaryKey(id);
    }
}