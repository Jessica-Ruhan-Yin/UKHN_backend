package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationUKIrelandUrl;
import com.UKHN_backend.server.domain.CollaborationUKIrelandUrlExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationUKIrelandUrlDto;
import com.UKHN_backend.server.mapper.CollaborationUKIrelandUrlMapper;
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
public class CollaborationUKIrelandUrlService {
    @Resource
    private CollaborationUKIrelandUrlMapper collaborationUKIrelandUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        CollaborationUKIrelandUrl url = collaborationUKIrelandUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationUKIrelandUrlDto collaborationUKIrelandUrlDto) {
        CollaborationUKIrelandUrl collaborationUKIrelandUrl = CopyUtil.copy(collaborationUKIrelandUrlDto, CollaborationUKIrelandUrl.class);
        CollaborationUKIrelandUrlExample example = new CollaborationUKIrelandUrlExample();
        example.createCriteria().andIdEqualTo(collaborationUKIrelandUrlDto.getId());
        List<CollaborationUKIrelandUrl> list = collaborationUKIrelandUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationUKIrelandUrl);
        } else {
            this.update(collaborationUKIrelandUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationUKIrelandUrl collaborationUKIrelandUrl) {

        collaborationUKIrelandUrlMapper.insert(collaborationUKIrelandUrl);
    }

    /**
     * 更新
     */
    private void update(CollaborationUKIrelandUrl collaborationUKIrelandUrl) {
        collaborationUKIrelandUrlMapper.updateByPrimaryKey(collaborationUKIrelandUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationUKIrelandUrlMapper.deleteByPrimaryKey(id);
    }
}