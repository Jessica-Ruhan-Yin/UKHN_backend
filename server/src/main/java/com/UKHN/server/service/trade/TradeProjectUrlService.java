package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeProjectUrl;
import com.UKHN_backend.server.domain.TradeProjectUrlExample;
import com.UKHN_backend.server.dto.trade.TradeProjectUrlDto;
import com.UKHN_backend.server.mapper.TradeProjectUrlMapper;
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
 * @Date 2021/12/06
 */

@Service
public class TradeProjectUrlService {
    @Resource
    private TradeProjectUrlMapper tradeProjectUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        TradeProjectUrl url = tradeProjectUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(TradeProjectUrlDto tradeProjectUrlDto) {
        TradeProjectUrl tradeProjectUrl = CopyUtil.copy(tradeProjectUrlDto, TradeProjectUrl.class);
        TradeProjectUrlExample example = new TradeProjectUrlExample();
        example.createCriteria().andIdEqualTo(tradeProjectUrlDto.getId());
        List<TradeProjectUrl> list = tradeProjectUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(tradeProjectUrl);
        } else {
            this.update(tradeProjectUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(TradeProjectUrl tradeProjectUrl) {

        tradeProjectUrlMapper.insert(tradeProjectUrl);
    }

    /**
     * 更新
     */
    private void update(TradeProjectUrl tradeProjectUrl) {
        tradeProjectUrlMapper.updateByPrimaryKey(tradeProjectUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        tradeProjectUrlMapper.deleteByPrimaryKey(id);
    }
}