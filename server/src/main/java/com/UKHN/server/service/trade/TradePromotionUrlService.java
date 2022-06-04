package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePromotionUrl;
import com.UKHN_backend.server.domain.TradePromotionUrlExample;
import com.UKHN_backend.server.dto.trade.TradePromotionUrlDto;
import com.UKHN_backend.server.mapper.TradePromotionUrlMapper;
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
public class TradePromotionUrlService {
    @Resource
    private TradePromotionUrlMapper tradePromotionUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        TradePromotionUrl url = tradePromotionUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(TradePromotionUrlDto tradePromotionUrlDto) {
        TradePromotionUrl tradePromotionUrl = CopyUtil.copy(tradePromotionUrlDto, TradePromotionUrl.class);
        TradePromotionUrlExample example = new TradePromotionUrlExample();
        example.createCriteria().andIdEqualTo(tradePromotionUrlDto.getId());
        List<TradePromotionUrl> list = tradePromotionUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(tradePromotionUrl);
        } else {
            this.update(tradePromotionUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(TradePromotionUrl tradePromotionUrl) {

        tradePromotionUrlMapper.insert(tradePromotionUrl);
    }

    /**
     * 更新
     */
    private void update(TradePromotionUrl tradePromotionUrl) {
        tradePromotionUrlMapper.updateByPrimaryKey(tradePromotionUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        tradePromotionUrlMapper.deleteByPrimaryKey(id);
    }
}