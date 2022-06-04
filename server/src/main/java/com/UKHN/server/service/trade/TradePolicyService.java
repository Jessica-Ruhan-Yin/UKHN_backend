package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePolicy;
import com.UKHN_backend.server.domain.TradePolicyContent;
import com.UKHN_backend.server.domain.TradePolicyExample;
import com.UKHN_backend.server.dto.trade.TradePolicyDto;
import com.UKHN_backend.server.dto.trade.TradePolicyContentDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.TradePolicyContentMapper;
import com.UKHN_backend.server.mapper.TradePolicyMapper;
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
public class TradePolicyService {

    private static final Logger LOG = LoggerFactory.getLogger(TradePolicyService.class);


    @Resource
    private TradePolicyContentMapper tradePolicyContentMapper;

    @Resource
    private TradePolicyMapper tradePolicyMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        TradePolicyExample tradePolicyExample = new TradePolicyExample();
        tradePolicyExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<TradePolicy> tradePolicyList = tradePolicyMapper.selectByExample(tradePolicyExample);

        PageInfo<TradePolicy> pageInfo = new PageInfo<>(tradePolicyList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<TradePolicyDto> tradePolicyDtoList = CopyUtil.copyList(tradePolicyList,TradePolicyDto.class);
        pageDto.setList(tradePolicyDtoList);
    }

    /**
     * 保存
     */
    public void save(TradePolicyDto tradePolicyDto){
        TradePolicy tradePolicy = CopyUtil.copy(tradePolicyDto,TradePolicy.class);
        if (StringUtils.isEmpty(tradePolicyDto.getId())){
            this.insert(tradePolicy);
        }else {
            this.update(tradePolicy);
        }
    }

    /**
     * 新增
     * @param tradePolicy
     */
    private void insert(TradePolicy tradePolicy){
        tradePolicyMapper.insert(tradePolicy);
    }

    /**
     * 更新
     * @param tradePolicy
     */
    private void update(TradePolicy tradePolicy){
        tradePolicyMapper.updateByPrimaryKeySelective(tradePolicy);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradePolicyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public TradePolicyContentDto findContent(Long id){
        TradePolicyContent tradePolicyContent = tradePolicyContentMapper.selectByPrimaryKey(id);
        if (tradePolicyContent==null){
            return null;
        }
        return CopyUtil.copy(tradePolicyContent, TradePolicyContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param tradePolicyContentDto
     * @return
     */
    public int saveContent(TradePolicyContentDto tradePolicyContentDto){
        TradePolicyContent tradePolicyContent = CopyUtil.copy(tradePolicyContentDto,TradePolicyContent.class);
        int i = tradePolicyContentMapper.updateByPrimaryKeyWithBLOBs(tradePolicyContent);
        if (i == 0){
            i = tradePolicyContentMapper.insert(tradePolicyContent);
        }
        return i;

    }

    public TradePolicyDto searchItem(Long id) {
        TradePolicy tradePolicy = tradePolicyMapper.selectByPrimaryKey(id);
        TradePolicyDto tradePolicyDto = CopyUtil.copy(tradePolicy,TradePolicyDto.class);
        return tradePolicyDto;
    }
}
