package com.UKHN.server.service.collaboration;

import com.UKHN_backend.server.domain.CollaborationChinaUrl;
import com.UKHN_backend.server.domain.CollaborationChinaUrlExample;
import com.UKHN_backend.server.dto.collaboration.CollaborationChinaUrlDto;
import com.UKHN_backend.server.mapper.CollaborationChinaUrlMapper;
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
public class CollaborationChinaUrlService {
    @Resource
    private CollaborationChinaUrlMapper collaborationChinaUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        CollaborationChinaUrl url = collaborationChinaUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CollaborationChinaUrlDto collaborationChinaUrlDto) {
        CollaborationChinaUrl collaborationChinaUrl = CopyUtil.copy(collaborationChinaUrlDto, CollaborationChinaUrl.class);
        CollaborationChinaUrlExample example = new CollaborationChinaUrlExample();
        example.createCriteria().andIdEqualTo(collaborationChinaUrlDto.getId());
        List<CollaborationChinaUrl> list = collaborationChinaUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(collaborationChinaUrl);
        } else {
            this.update(collaborationChinaUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(CollaborationChinaUrl collaborationChinaUrl) {

        collaborationChinaUrlMapper.insert(collaborationChinaUrl);
    }

    /**
     * 更新
     */
    private void update(CollaborationChinaUrl collaborationChinaUrl) {
        collaborationChinaUrlMapper.updateByPrimaryKey(collaborationChinaUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        collaborationChinaUrlMapper.deleteByPrimaryKey(id);
    }
}