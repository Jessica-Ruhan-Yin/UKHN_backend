package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.trade.TradeBusinessContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.trade.TradeBusinessContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——招商引资——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@RestController
@RequestMapping("/admin/trade-business-content")
public class TradeBusinessContentController {
    @Resource
    private TradeBusinessContentService tradeBusinessContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        TradeBusinessContentDto content = tradeBusinessContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeBusinessContentDto tradeBusinessContentDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessContentService.save(tradeBusinessContentDto);
        responseDto.setContent(tradeBusinessContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessContentService.delete(id);
        return responseDto;
    }
}
