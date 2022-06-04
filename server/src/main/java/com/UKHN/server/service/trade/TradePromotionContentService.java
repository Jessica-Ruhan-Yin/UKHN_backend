package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePromotionContent;
import com.UKHN_backend.server.domain.TradePromotionContentExample;
import com.UKHN_backend.server.dto.trade.TradePromotionContentDto;
import com.UKHN_backend.server.mapper.CustMapper.TradePromotionCust;
import com.UKHN_backend.server.mapper.TradePromotionContentMapper;
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
 * @Date 2021/11/20
 */
@Service
public class TradePromotionContentService {

    @Resource
    private TradePromotionContentMapper tradePromotionContentMapper;

    @Resource
    private TradePromotionCust tradePromotionCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public TradePromotionContentDto list(Long id){
        TradePromotionContent content = tradePromotionContentMapper.selectByPrimaryKey(id);
        tradePromotionCust.increaseViewCount(id);
        TradePromotionContentDto contentDto = new TradePromotionContentDto();
        if (ObjectUtils.isEmpty(content.getContent())){
            contentDto.setContent("");
            contentDto.setView(content.getView());
            return contentDto;
        }else {
            contentDto.setContent(content.getContent());
            contentDto.setView(content.getView());
            return contentDto;
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     * @param tradePromotionContentDto
     */
    public void save(TradePromotionContentDto tradePromotionContentDto){
        TradePromotionContent tradePromotionContent = CopyUtil.copy(tradePromotionContentDto,TradePromotionContent.class);
        TradePromotionContentExample example = new TradePromotionContentExample();
        example.createCriteria().andIdEqualTo(tradePromotionContentDto.getId());
        List<TradePromotionContent> list = tradePromotionContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(tradePromotionContent);
        }else {
            this.update(tradePromotionContent);
        }
    }

    /**
     * 新增
     * @param tradePromotionContent
     */
    private void insert(TradePromotionContent tradePromotionContent){
        tradePromotionContentMapper.insert(tradePromotionContent);
    }

    /**
     * 更新
     * @param tradePromotionContent
     */
    private void update(TradePromotionContent tradePromotionContent){
        tradePromotionContentMapper.updateByPrimaryKeyWithBLOBs(tradePromotionContent);
    }

    public void delete(Long id){
        tradePromotionContentMapper.deleteByPrimaryKey(id);
    }
}
