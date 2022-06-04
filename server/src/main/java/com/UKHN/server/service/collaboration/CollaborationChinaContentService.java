package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationChinaContent;
import com.UKHN_backend.server.domain.CollaborationChinaContentExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentDto;
import com.UKHN_backend.server.mapper.CollaborationChinaContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.CollaCnCust;
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
public class CollaborationChinaContentService {
    @Resource
    private CollaborationChinaContentMapper collaborationChinaContentMapper;


    @Resource
    private CollaCnCust collaCnCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public CollaborationChinaContentDto list(Long id){
        CollaborationChinaContent content = collaborationChinaContentMapper.selectByPrimaryKey(id);
        collaCnCust.increaseViewCount(id);
        CollaborationChinaContentDto contentDto = new CollaborationChinaContentDto();
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
    public void save(CollaborationChinaContentDto collaborationChinaContentDto) {
        CollaborationChinaContent collaborationChinaContent = CopyUtil.copy(collaborationChinaContentDto, CollaborationChinaContent.class);
        CollaborationChinaContentExample example = new CollaborationChinaContentExample();
        example.createCriteria().andIdEqualTo(collaborationChinaContentDto.getId());
        List<CollaborationChinaContent> list = collaborationChinaContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationChinaContent);
        } else {
            this.update(collaborationChinaContent);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationChinaContent collaborationChinaContent) {

        collaborationChinaContentMapper.insert(collaborationChinaContent);
    }

    /**
     * 更新
     */
    private void update(CollaborationChinaContent collaborationChinaContent) {
        collaborationChinaContentMapper.updateByPrimaryKeyWithBLOBs(collaborationChinaContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationChinaContentMapper.deleteByPrimaryKey(id);
    }
}