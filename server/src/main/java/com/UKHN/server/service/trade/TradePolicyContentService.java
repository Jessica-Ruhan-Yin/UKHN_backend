package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradePolicyContent;
import com.UKHN_backend.server.domain.TradePolicyContentExample;
import com.UKHN_backend.server.dto.trade.TradePolicyContentDto;
import com.UKHN_backend.server.mapper.TradePolicyContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.TradePolicyCust;
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
public class TradePolicyContentService {

    @Resource
    private TradePolicyContentMapper tradePolicyContentMapper;

    @Resource
    private TradePolicyCust tradePolicyCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public TradePolicyContentDto list(Long id){
        TradePolicyContent content = tradePolicyContentMapper.selectByPrimaryKey(id);
        tradePolicyCust.increaseViewCount(id);
        TradePolicyContentDto contentDto = new TradePolicyContentDto();
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
     * @param tradePolicyContentDto
     */
    public void save(TradePolicyContentDto tradePolicyContentDto){
        TradePolicyContent tradePolicyContent = CopyUtil.copy(tradePolicyContentDto,TradePolicyContent.class);
        TradePolicyContentExample example = new TradePolicyContentExample();
        example.createCriteria().andIdEqualTo(tradePolicyContentDto.getId());
        List<TradePolicyContent> list = tradePolicyContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(tradePolicyContent);
        }else {
            this.update(tradePolicyContent);
        }
    }

    /**
     * 新增
     * @param tradePolicyContent
     */
    private void insert(TradePolicyContent tradePolicyContent){
        tradePolicyContentMapper.insert(tradePolicyContent);
    }

    /**
     * 更新
     * @param tradePolicyContent
     */
    private void update(TradePolicyContent tradePolicyContent){
        tradePolicyContentMapper.updateByPrimaryKeyWithBLOBs(tradePolicyContent);
    }

    public void delete(Long id){
        tradePolicyContentMapper.deleteByPrimaryKey(id);
    }
}
