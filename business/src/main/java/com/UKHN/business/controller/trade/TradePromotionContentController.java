package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradePromotionContentDto;
import com.UKHN_backend.server.service.trade.TradePromotionContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——宣传推广——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-promotion-content")
public class TradePromotionContentController {

    @Resource
    TradePromotionContentService tradePromotionContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradePromotionContentDto content = tradePromotionContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePromotionContentDto tradePromotionContentDto){
        ResponseDto responseDto = new ResponseDto();
        tradePromotionContentService.save(tradePromotionContentDto);
        responseDto.setContent(tradePromotionContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradePromotionContentService.delete(id);
        return responseDto;
    }
}
