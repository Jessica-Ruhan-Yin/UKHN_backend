package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeBusiness;
import com.UKHN_backend.server.domain.TradeBusinessContent;
import com.UKHN_backend.server.domain.TradeBusinessExample;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessContentDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessDto;
import com.UKHN_backend.server.mapper.TradeBusinessContentMapper;
import com.UKHN_backend.server.mapper.TradeBusinessMapper;
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
public class TradeBusinessService {

    private static final Logger LOG = LoggerFactory.getLogger(TradeBusinessService.class);


    @Resource
    private TradeBusinessContentMapper tradeBusinessContentMapper;

    @Resource
    private TradeBusinessMapper tradeBusinessMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        TradeBusinessExample tradeBusinessExample = new TradeBusinessExample();
        tradeBusinessExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<TradeBusiness> tradeBusinessList = tradeBusinessMapper.selectByExample(tradeBusinessExample);

        PageInfo<TradeBusiness> pageInfo = new PageInfo<>(tradeBusinessList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<TradeBusinessDto> tradeBusinessDtoList = CopyUtil.copyList(tradeBusinessList,TradeBusinessDto.class);
        pageDto.setList(tradeBusinessDtoList);
    }

    /**
     * 保存
     */
    public void save(TradeBusinessDto tradeBusinessDto){
        TradeBusiness tradeBusiness = CopyUtil.copy(tradeBusinessDto,TradeBusiness.class);
        if (StringUtils.isEmpty(tradeBusinessDto.getId())){
            this.insert(tradeBusiness);
        }else {
            this.update(tradeBusiness);
        }
    }

    /**
     * 新增
     * @param tradeBusiness
     */
    private void insert(TradeBusiness tradeBusiness){
        tradeBusinessMapper.insert(tradeBusiness);
    }

    /**
     * 更新
     * @param tradeBusiness
     */
    private void update(TradeBusiness tradeBusiness){
        tradeBusinessMapper.updateByPrimaryKeySelective(tradeBusiness);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradeBusinessMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public TradeBusinessContentDto findContent(Long id){
        TradeBusinessContent tradeBusinessContent = tradeBusinessContentMapper.selectByPrimaryKey(id);
        if (tradeBusinessContent==null){
            return null;
        }
        return CopyUtil.copy(tradeBusinessContent, TradeBusinessContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param tradeBusinessContentDto
     * @return
     */
    public int saveContent(TradeBusinessContentDto tradeBusinessContentDto){
        TradeBusinessContent tradeBusinessContent = CopyUtil.copy(tradeBusinessContentDto,TradeBusinessContent.class);
        int i = tradeBusinessContentMapper.updateByPrimaryKeyWithBLOBs(tradeBusinessContent);
        if (i == 0){
            i = tradeBusinessContentMapper.insert(tradeBusinessContent);
        }
        return i;

    }

    public TradeBusinessDto searchItem(Long id) {
        TradeBusiness tradeBusiness = tradeBusinessMapper.selectByPrimaryKey(id);
        TradeBusinessDto tradeBusinessDto = CopyUtil.copy(tradeBusiness,TradeBusinessDto.class);
        return tradeBusinessDto;
    }
}
