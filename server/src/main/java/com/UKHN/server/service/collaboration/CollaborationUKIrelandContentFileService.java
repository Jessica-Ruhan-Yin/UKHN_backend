package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationUKIrelandContentFile;
import com.UKHN_backend.server.domain.CollaborationUKIrelandContentFileExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandContentFileDto;
import com.UKHN_backend.server.mapper.CollaborationUKIrelandContentFileMapper;
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
public class CollaborationUKIrelandContentFileService {
    @Resource
    private CollaborationUKIrelandContentFileMapper collaborationUKIrelandContentFileMapper;

    /**
     * 列表查询
     */
    public List<CollaborationUKIrelandContentFileDto> list(Long slideId) {
        CollaborationUKIrelandContentFileExample example = new CollaborationUKIrelandContentFileExample();
        CollaborationUKIrelandContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<CollaborationUKIrelandContentFile> fileList = collaborationUKIrelandContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, CollaborationUKIrelandContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationUKIrelandContentFileDto collaborationUKIrelandContentFileDto) {
        CollaborationUKIrelandContentFile collaborationUKIrelandContentFile = CopyUtil.copy(collaborationUKIrelandContentFileDto, CollaborationUKIrelandContentFile.class);
        if (StringUtils.isEmpty(collaborationUKIrelandContentFileDto.getId())) {
            this.insert(collaborationUKIrelandContentFile);
        } else {
            this.update(collaborationUKIrelandContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationUKIrelandContentFile collaborationUKIrelandContentFile) {
        collaborationUKIrelandContentFileMapper.insert(collaborationUKIrelandContentFile);
    }

    /**
     * 更新
     */
    private void update(CollaborationUKIrelandContentFile collaborationUKIrelandContentFile) {
        collaborationUKIrelandContentFileMapper.updateByPrimaryKey(collaborationUKIrelandContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationUKIrelandContentFileMapper.deleteByPrimaryKey(id);
    }
}
