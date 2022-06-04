package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationCUIContentFile;
import com.UKHN_backend.server.domain.CollaborationCUIContentFileExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIContentFileDto;
import com.UKHN_backend.server.mapper.CollaborationCUIContentFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@Service
public class CollaborationCUIContentFileService {
    @Resource
    private CollaborationCUIContentFileMapper collaborationCUIContentFileMapper;

    /**
     * 列表查询
     */
    public List<CollaborationCUIContentFileDto> list(Long slideId) {
        CollaborationCUIContentFileExample example = new CollaborationCUIContentFileExample();
        CollaborationCUIContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<CollaborationCUIContentFile> fileList = collaborationCUIContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, CollaborationCUIContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationCUIContentFileDto collaborationCUIContentFileDto) {
        CollaborationCUIContentFile collaborationCUIContentFile = CopyUtil.copy(collaborationCUIContentFileDto, CollaborationCUIContentFile.class);
        if (StringUtils.isEmpty(collaborationCUIContentFileDto.getId())) {
            this.insert(collaborationCUIContentFile);
        } else {
            this.update(collaborationCUIContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationCUIContentFile collaborationCUIContentFile) {
        collaborationCUIContentFileMapper.insert(collaborationCUIContentFile);
    }

    /**
     * 更新
     */
    private void update(CollaborationCUIContentFile collaborationCUIContentFile) {
        collaborationCUIContentFileMapper.updateByPrimaryKey(collaborationCUIContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationCUIContentFileMapper.deleteByPrimaryKey(id);
    }
}
