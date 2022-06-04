package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePromotionFile;
import com.UKHN_backend.server.domain.TradePromotionFileExample;
import com.UKHN_backend.server.dto.trade.TradePromotionFileDto;
import com.UKHN_backend.server.mapper.TradePromotionFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradePromotionFileService {

    @Resource
    private TradePromotionFileMapper tradePromotionFileMapper;

    /**
     * 列表查询
     */
    public List<TradePromotionFileDto> list(Long id){
        TradePromotionFileExample example = new TradePromotionFileExample();
        TradePromotionFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<TradePromotionFile> fileList = tradePromotionFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,TradePromotionFileDto.class);
    }
    /**
     * 保存
     */
    public void save(TradePromotionFileDto tradePromotionFileDto){
        TradePromotionFile tradePromotionFile = CopyUtil.copy(tradePromotionFileDto,TradePromotionFile.class);
        if (StringUtils.isEmpty(tradePromotionFileDto.getId())){
            this.insert(tradePromotionFile);
        }else {
            this.update(tradePromotionFile);
        }
    }

    /**
     * 新增
     * @param tradePromotionFile
     */
    private void insert(TradePromotionFile tradePromotionFile){
        tradePromotionFileMapper.insert(tradePromotionFile);
    }

    /**
     * 更新
     * @param tradePromotionFile
     */
    private void update(TradePromotionFile tradePromotionFile){
        tradePromotionFileMapper.updateByPrimaryKeySelective(tradePromotionFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradePromotionFileMapper.deleteByPrimaryKey(id);
    }
}
