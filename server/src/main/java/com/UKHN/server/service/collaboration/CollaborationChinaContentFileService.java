package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationChinaContentFile;
import com.UKHN_backend.server.domain.CollaborationChinaContentFileExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaContentFileDto;
import com.UKHN_backend.server.mapper.CollaborationChinaContentFileMapper;
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
public class CollaborationChinaContentFileService {
    @Resource
    private CollaborationChinaContentFileMapper collaborationChinaContentFileMapper;

    /**
     * 列表查询
     */
    public List<CollaborationChinaContentFileDto> list(Long slideId) {
        CollaborationChinaContentFileExample example = new CollaborationChinaContentFileExample();
        CollaborationChinaContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<CollaborationChinaContentFile> fileList = collaborationChinaContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, CollaborationChinaContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationChinaContentFileDto collaborationChinaContentFileDto) {
        CollaborationChinaContentFile collaborationChinaContentFile = CopyUtil.copy(collaborationChinaContentFileDto, CollaborationChinaContentFile.class);
        if (StringUtils.isEmpty(collaborationChinaContentFileDto.getId())) {
            this.insert(collaborationChinaContentFile);
        } else {
            this.update(collaborationChinaContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationChinaContentFile collaborationChinaContentFile) {
        collaborationChinaContentFileMapper.insert(collaborationChinaContentFile);
    }

    /**
     * 更新
     */
    private void update(CollaborationChinaContentFile collaborationChinaContentFile) {
        collaborationChinaContentFileMapper.updateByPrimaryKey(collaborationChinaContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationChinaContentFileMapper.deleteByPrimaryKey(id);
    }
}
