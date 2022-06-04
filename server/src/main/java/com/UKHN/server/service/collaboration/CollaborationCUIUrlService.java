package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationCUIUrl;
import com.UKHN_backend.server.domain.CollaborationCUIUrlExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationCUIUrlDto;
import com.UKHN_backend.server.mapper.CollaborationCUIUrlMapper;
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
public class CollaborationCUIUrlService {
    @Resource
    private CollaborationCUIUrlMapper collaborationCUIUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        CollaborationCUIUrl url = collaborationCUIUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationCUIUrlDto collaborationCUIUrlDto) {
        CollaborationCUIUrl collaborationCUIUrl = CopyUtil.copy(collaborationCUIUrlDto, CollaborationCUIUrl.class);
        CollaborationCUIUrlExample example = new CollaborationCUIUrlExample();
        example.createCriteria().andIdEqualTo(collaborationCUIUrlDto.getId());
        List<CollaborationCUIUrl> list = collaborationCUIUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationCUIUrl);
        } else {
            this.update(collaborationCUIUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationCUIUrl collaborationCUIUrl) {

        collaborationCUIUrlMapper.insert(collaborationCUIUrl);
    }

    /**
     * 更新
     */
    private void update(CollaborationCUIUrl collaborationCUIUrl) {
        collaborationCUIUrlMapper.updateByPrimaryKey(collaborationCUIUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationCUIUrlMapper.deleteByPrimaryKey(id);
    }
}