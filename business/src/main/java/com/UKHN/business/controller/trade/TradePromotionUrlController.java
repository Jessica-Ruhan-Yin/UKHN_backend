package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradePromotionUrlDto;
import com.UKHN_backend.server.service.trade.TradePromotionUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */
@RestController
@RequestMapping("/admin/trade-promotion-url")
public class TradePromotionUrlController {
    @Resource
    private TradePromotionUrlService tradePromotionUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = tradePromotionUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePromotionUrlDto tradePromotionUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePromotionUrlService.save(tradePromotionUrlDto);
        responseDto.setContent(tradePromotionUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradePromotionUrlService.delete(id);
        return responseDto;
    }
}
