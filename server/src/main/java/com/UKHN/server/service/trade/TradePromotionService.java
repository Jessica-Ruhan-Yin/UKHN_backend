package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePromotion;
import com.UKHN_backend.server.domain.TradePromotion;
import com.UKHN_backend.server.domain.TradePromotionContent;
import com.UKHN_backend.server.domain.TradePromotionExample;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.trade.TradePromotionDto;
import com.UKHN_backend.server.dto.trade.TradePromotionContentDto;
import com.UKHN_backend.server.dto.trade.TradePromotionDto;
import com.UKHN_backend.server.mapper.TradePromotionContentMapper;
import com.UKHN_backend.server.mapper.TradePromotionMapper;
import com.UKHN_backend.server.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/20
 */
@Service
public class TradePromotionService {

    private static final Logger LOG = LoggerFactory.getLogger(TradePromotionService.class);


    @Resource
    private TradePromotionContentMapper tradePromotionContentMapper;

    @Resource
    private TradePromotionMapper tradePromotionMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        TradePromotionExample tradePromotionExample = new TradePromotionExample();
        tradePromotionExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<TradePromotion> tradePromotionList = tradePromotionMapper.selectByExample(tradePromotionExample);

        PageInfo<TradePromotion> pageInfo = new PageInfo<>(tradePromotionList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<TradePromotionDto> tradePromotionDtoList = CopyUtil.copyList(tradePromotionList,TradePromotionDto.class);
        pageDto.setList(tradePromotionDtoList);
    }

    /**
     * 保存
     */
    public void save(TradePromotionDto tradePromotionDto){
        TradePromotion tradePromotion = CopyUtil.copy(tradePromotionDto,TradePromotion.class);
        if (StringUtils.isEmpty(tradePromotionDto.getId())){
            this.insert(tradePromotion);
        }else {
            this.update(tradePromotion);
        }
    }

    /**
     * 新增
     * @param tradePromotion
     */
    private void insert(TradePromotion tradePromotion){
        tradePromotionMapper.insert(tradePromotion);
    }

    /**
     * 更新
     * @param tradePromotion
     */
    private void update(TradePromotion tradePromotion){
        tradePromotionMapper.updateByPrimaryKeySelective(tradePromotion);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradePromotionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public TradePromotionContentDto findContent(Long id){
        TradePromotionContent tradePromotionContent = tradePromotionContentMapper.selectByPrimaryKey(id);
        if (tradePromotionContent==null){
            return null;
        }
        return CopyUtil.copy(tradePromotionContent, TradePromotionContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param tradePromotionContentDto
     * @return
     */
    public int saveContent(TradePromotionContentDto tradePromotionContentDto){
        TradePromotionContent tradePromotionContent = CopyUtil.copy(tradePromotionContentDto,TradePromotionContent.class);
        int i = tradePromotionContentMapper.updateByPrimaryKeyWithBLOBs(tradePromotionContent);
        if (i == 0){
            i = tradePromotionContentMapper.insert(tradePromotionContent);
        }
        return i;

    }

    public TradePromotionDto searchItem(Long id) {
        TradePromotion tradePromotion = tradePromotionMapper.selectByPrimaryKey(id);
        TradePromotionDto tradePromotionDto = CopyUtil.copy(tradePromotion,TradePromotionDto.class);
        return tradePromotionDto;
    }
}
