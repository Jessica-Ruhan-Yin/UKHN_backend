package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeBusinessContent;
import com.UKHN_backend.server.domain.TradeBusinessContentExample;
import com.UKHN_backend.server.dto.trade.TradeBusinessContentDto;
import com.UKHN_backend.server.mapper.CustMapper.TradeBusinessCust;
import com.UKHN_backend.server.mapper.TradeBusinessContentMapper;
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
public class TradeBusinessContentService {

    @Resource
    private TradeBusinessContentMapper tradeBusinessContentMapper;

    @Resource
    private TradeBusinessCust tradeBusinessCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public TradeBusinessContentDto list(Long id){
        TradeBusinessContent content = tradeBusinessContentMapper.selectByPrimaryKey(id);
        tradeBusinessCust.increaseViewCount(id);
        TradeBusinessContentDto contentDto = new TradeBusinessContentDto();
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
     * @param tradeBusinessContentDto
     */
    public void save(TradeBusinessContentDto tradeBusinessContentDto){
        TradeBusinessContent tradeBusinessContent = CopyUtil.copy(tradeBusinessContentDto,TradeBusinessContent.class);
        TradeBusinessContentExample example = new TradeBusinessContentExample();
        example.createCriteria().andIdEqualTo(tradeBusinessContentDto.getId());
        List<TradeBusinessContent> list = tradeBusinessContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(tradeBusinessContent);
        }else {
            this.update(tradeBusinessContent);
        }
    }

    /**
     * 新增
     * @param tradeBusinessContent
     */
    private void insert(TradeBusinessContent tradeBusinessContent){
        tradeBusinessContentMapper.insert(tradeBusinessContent);
    }

    /**
     * 更新
     * @param tradeBusinessContent
     */
    private void update(TradeBusinessContent tradeBusinessContent){
        tradeBusinessContentMapper.updateByPrimaryKeyWithBLOBs(tradeBusinessContent);
    }

    public void delete(Long id){
        tradeBusinessContentMapper.deleteByPrimaryKey(id);
    }
}
