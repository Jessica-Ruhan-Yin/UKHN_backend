package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePolicyFile;
import com.UKHN_backend.server.domain.TradePolicyFileExample;
import com.UKHN_backend.server.dto.trade.TradePolicyFileDto;
import com.UKHN_backend.server.mapper.TradePolicyFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradePolicyFileService {

    @Resource
    private TradePolicyFileMapper tradePolicyFileMapper;

    /**
     * 列表查询
     */
    public List<TradePolicyFileDto> list(Long id){
        TradePolicyFileExample example = new TradePolicyFileExample();
        TradePolicyFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<TradePolicyFile> fileList = tradePolicyFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,TradePolicyFileDto.class);
    }
    /**
     * 保存
     */
    public void save(TradePolicyFileDto tradePolicyFileDto){
        TradePolicyFile tradePolicyFile = CopyUtil.copy(tradePolicyFileDto,TradePolicyFile.class);
        if (StringUtils.isEmpty(tradePolicyFileDto.getId())){
            this.insert(tradePolicyFile);
        }else {
            this.update(tradePolicyFile);
        }
    }

    /**
     * 新增
     * @param tradePolicyFile
     */
    private void insert(TradePolicyFile tradePolicyFile){
        tradePolicyFileMapper.insert(tradePolicyFile);
    }

    /**
     * 更新
     * @param tradePolicyFile
     */
    private void update(TradePolicyFile tradePolicyFile){
        tradePolicyFileMapper.updateByPrimaryKeySelective(tradePolicyFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradePolicyFileMapper.deleteByPrimaryKey(id);
    }
}
