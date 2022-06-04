package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.IntroActivityUrl;
import com.UKHN_backend.server.domain.IntroActivityUrlExample;
import com.UKHN_backend.server.dto.home.IntroActivityUrlDto;
import com.UKHN_backend.server.mapper.IntroActivityUrlMapper;
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
 * @Date 2021/12/1
 */
@Service
public class IntroActivityUrlService {
    @Resource
    private IntroActivityUrlMapper introActivityUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        IntroActivityUrl url = introActivityUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(IntroActivityUrlDto introActivityUrlDto) {
        IntroActivityUrl introActivityUrl = CopyUtil.copy(introActivityUrlDto, IntroActivityUrl.class);
        IntroActivityUrlExample example = new IntroActivityUrlExample();
        example.createCriteria().andIdEqualTo(introActivityUrlDto.getId());
        List<IntroActivityUrl> list = introActivityUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(introActivityUrl);
        } else {
            this.update(introActivityUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(IntroActivityUrl introActivityUrl) {

        introActivityUrlMapper.insert(introActivityUrl);
    }

    /**
     * 更新
     */
    private void update(IntroActivityUrl introActivityUrl) {
        introActivityUrlMapper.updateByPrimaryKey(introActivityUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        introActivityUrlMapper.deleteByPrimaryKey(id);
    }
}