package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeProjectFile;
import com.UKHN_backend.server.domain.TradeProjectFileExample;
import com.UKHN_backend.server.dto.trade.TradeProjectFileDto;
import com.UKHN_backend.server.mapper.TradeProjectFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradeProjectFileService {

    @Resource
    private TradeProjectFileMapper tradeProjectFileMapper;

    /**
     * 列表查询
     */
    public List<TradeProjectFileDto> list(Long id){
        TradeProjectFileExample example = new TradeProjectFileExample();
        TradeProjectFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<TradeProjectFile> fileList = tradeProjectFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,TradeProjectFileDto.class);
    }
    /**
     * 保存
     */
    public void save(TradeProjectFileDto tradeProjectFileDto){
        TradeProjectFile tradeProjectFile = CopyUtil.copy(tradeProjectFileDto,TradeProjectFile.class);
        if (StringUtils.isEmpty(tradeProjectFileDto.getId())){
            this.insert(tradeProjectFile);
        }else {
            this.update(tradeProjectFile);
        }
    }

    /**
     * 新增
     * @param tradeProjectFile
     */
    private void insert(TradeProjectFile tradeProjectFile){
        tradeProjectFileMapper.insert(tradeProjectFile);
    }

    /**
     * 更新
     * @param tradeProjectFile
     */
    private void update(TradeProjectFile tradeProjectFile){
        tradeProjectFileMapper.updateByPrimaryKeySelective(tradeProjectFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradeProjectFileMapper.deleteByPrimaryKey(id);
    }
}
