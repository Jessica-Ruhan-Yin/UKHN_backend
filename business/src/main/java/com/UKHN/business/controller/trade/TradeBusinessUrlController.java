package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessUrlDto;
import com.UKHN_backend.server.service.trade.TradeBusinessUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——招商引资——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */
@RestController
@RequestMapping("/admin/trade-business-url")
public class TradeBusinessUrlController {
    @Resource
    private TradeBusinessUrlService tradeBusinessUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = tradeBusinessUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeBusinessUrlDto tradeBusinessUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessUrlService.save(tradeBusinessUrlDto);
        responseDto.setContent(tradeBusinessUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessUrlService.delete(id);
        return responseDto;
    }
}
