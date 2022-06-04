package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationCUIContent;
import com.UKHN_backend.server.domain.CollaborationCUIContentExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentDto;
import com.UKHN_backend.server.mapper.CollaborationCUIContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.CollaCUICust;
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
public class CollaborationCUIContentService {
    @Resource
    private CollaborationCUIContentMapper collaborationCUIContentMapper;


    @Resource
    private CollaCUICust collaCUICust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public CollaborationCUIContentDto list(Long id){
        CollaborationCUIContent content = collaborationCUIContentMapper.selectByPrimaryKey(id);
        collaCUICust.increaseViewCount(id);
        CollaborationCUIContentDto contentDto = new CollaborationCUIContentDto();
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
    public void save(CollaborationCUIContentDto collaborationCUIContentDto) {
        CollaborationCUIContent collaborationCUIContent = CopyUtil.copy(collaborationCUIContentDto, CollaborationCUIContent.class);
        CollaborationCUIContentExample example = new CollaborationCUIContentExample();
        example.createCriteria().andIdEqualTo(collaborationCUIContentDto.getId());
        List<CollaborationCUIContent> list = collaborationCUIContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationCUIContent);
        } else {
            this.update(collaborationCUIContent);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationCUIContent collaborationCUIContent) {

        collaborationCUIContentMapper.insert(collaborationCUIContent);
    }

    /**
     * 更新
     */
    private void update(CollaborationCUIContent collaborationCUIContent) {
        collaborationCUIContentMapper.updateByPrimaryKeyWithBLOBs(collaborationCUIContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationCUIContentMapper.deleteByPrimaryKey(id);
    }
}