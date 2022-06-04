package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeBusinessFile;
import com.UKHN_backend.server.domain.TradeBusinessFileExample;
import com.UKHN_backend.server.dto.trade.TradeBusinessFileDto;
import com.UKHN_backend.server.mapper.TradeBusinessFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradeBusinessFileService {

    @Resource
    private TradeBusinessFileMapper tradeBusinessFileMapper;

    /**
     * 列表查询
     */
    public List<TradeBusinessFileDto> list(Long id){
        TradeBusinessFileExample example = new TradeBusinessFileExample();
        TradeBusinessFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<TradeBusinessFile> fileList = tradeBusinessFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,TradeBusinessFileDto.class);
    }
    /**
     * 保存
     */
    public void save(TradeBusinessFileDto tradeBusinessFileDto){
        TradeBusinessFile tradeBusinessFile = CopyUtil.copy(tradeBusinessFileDto,TradeBusinessFile.class);
        if (StringUtils.isEmpty(tradeBusinessFileDto.getId())){
            this.insert(tradeBusinessFile);
        }else {
            this.update(tradeBusinessFile);
        }
    }

    /**
     * 新增
     * @param tradeBusinessFile
     */
    private void insert(TradeBusinessFile tradeBusinessFile){
        tradeBusinessFileMapper.insert(tradeBusinessFile);
    }

    /**
     * 更新
     * @param tradeBusinessFile
     */
    private void update(TradeBusinessFile tradeBusinessFile){
        tradeBusinessFileMapper.updateByPrimaryKeySelective(tradeBusinessFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradeBusinessFileMapper.deleteByPrimaryKey(id);
    }
}
