package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeProjectContent;
import com.UKHN_backend.server.domain.TradeProjectContentExample;
import com.UKHN_backend.server.dto.trade.TradeProjectContentDto;
import com.UKHN_backend.server.mapper.CustMapper.TradeProjectCust;
import com.UKHN_backend.server.mapper.TradeProjectContentMapper;
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
public class TradeProjectContentService {

    @Resource
    private TradeProjectContentMapper tradeProjectContentMapper;

    @Resource
    private TradeProjectCust tradeProjectCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public TradeProjectContentDto list(Long id){
        TradeProjectContent content = tradeProjectContentMapper.selectByPrimaryKey(id);
        tradeProjectCust.increaseViewCount(id);
        TradeProjectContentDto contentDto = new TradeProjectContentDto();
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
     * @param tradeProjectContentDto
     */
    public void save(TradeProjectContentDto tradeProjectContentDto){
        TradeProjectContent tradeProjectContent = CopyUtil.copy(tradeProjectContentDto,TradeProjectContent.class);
        TradeProjectContentExample example = new TradeProjectContentExample();
        example.createCriteria().andIdEqualTo(tradeProjectContentDto.getId());
        List<TradeProjectContent> list = tradeProjectContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(tradeProjectContent);
        }else {
            this.update(tradeProjectContent);
        }
    }

    /**
     * 新增
     * @param tradeProjectContent
     */
    private void insert(TradeProjectContent tradeProjectContent){
        tradeProjectContentMapper.insert(tradeProjectContent);
    }

    /**
     * 更新
     * @param tradeProjectContent
     */
    private void update(TradeProjectContent tradeProjectContent){
        tradeProjectContentMapper.updateByPrimaryKeyWithBLOBs(tradeProjectContent);
    }

    public void delete(Long id){
        tradeProjectContentMapper.deleteByPrimaryKey(id);
    }
}
