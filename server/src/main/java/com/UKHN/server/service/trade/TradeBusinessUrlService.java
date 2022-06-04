package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeBusinessUrl;
import com.UKHN_backend.server.domain.TradeBusinessUrlExample;
import com.UKHN_backend.server.dto.trade.TradeBusinessUrlDto;
import com.UKHN_backend.server.mapper.TradeBusinessUrlMapper;
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
public class TradeBusinessUrlService {
    @Resource
    private TradeBusinessUrlMapper tradeBusinessUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        TradeBusinessUrl url = tradeBusinessUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(TradeBusinessUrlDto tradeBusinessUrlDto) {
        TradeBusinessUrl tradeBusinessUrl = CopyUtil.copy(tradeBusinessUrlDto, TradeBusinessUrl.class);
        TradeBusinessUrlExample example = new TradeBusinessUrlExample();
        example.createCriteria().andIdEqualTo(tradeBusinessUrlDto.getId());
        List<TradeBusinessUrl> list = tradeBusinessUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(tradeBusinessUrl);
        } else {
            this.update(tradeBusinessUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(TradeBusinessUrl tradeBusinessUrl) {

        tradeBusinessUrlMapper.insert(tradeBusinessUrl);
    }

    /**
     * 更新
     */
    private void update(TradeBusinessUrl tradeBusinessUrl) {
        tradeBusinessUrlMapper.updateByPrimaryKey(tradeBusinessUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        tradeBusinessUrlMapper.deleteByPrimaryKey(id);
    }
}