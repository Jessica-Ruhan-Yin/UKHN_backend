package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradePromotionContentDto;
import com.UKHN_backend.server.dto.trade.TradePromotionDto;
import com.UKHN_backend.server.service.trade.TradePromotionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——宣传推广
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-promotion")
public class TradePromotionController {

    @Resource
    private TradePromotionService tradePromotionService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePromotionService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePromotionDto tradePromotionDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePromotionService.save(tradePromotionDto);
        responseDto.setContent(tradePromotionDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradePromotionService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradePromotionDto content = tradePromotionService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
