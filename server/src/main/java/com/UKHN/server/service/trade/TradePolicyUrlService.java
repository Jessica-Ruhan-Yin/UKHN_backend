package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePolicyUrl;
import com.UKHN_backend.server.domain.TradePolicyUrlExample;
import com.UKHN_backend.server.dto.trade.TradePolicyUrlDto;
import com.UKHN_backend.server.mapper.TradePolicyUrlMapper;
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
 * @Date 2021/12/06
 */

@Service
public class TradePolicyUrlService {
    @Resource
    private TradePolicyUrlMapper tradePolicyUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        TradePolicyUrl url = tradePolicyUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(TradePolicyUrlDto tradePolicyUrlDto) {
        TradePolicyUrl tradePolicyUrl = CopyUtil.copy(tradePolicyUrlDto, TradePolicyUrl.class);
        TradePolicyUrlExample example = new TradePolicyUrlExample();
        example.createCriteria().andIdEqualTo(tradePolicyUrlDto.getId());
        List<TradePolicyUrl> list = tradePolicyUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(tradePolicyUrl);
        } else {
            this.update(tradePolicyUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(TradePolicyUrl tradePolicyUrl) {

        tradePolicyUrlMapper.insert(tradePolicyUrl);
    }

    /**
     * 更新
     */
    private void update(TradePolicyUrl tradePolicyUrl) {
        tradePolicyUrlMapper.updateByPrimaryKey(tradePolicyUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        tradePolicyUrlMapper.deleteByPrimaryKey(id);
    }
}