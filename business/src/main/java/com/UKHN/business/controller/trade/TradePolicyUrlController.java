package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.trade.TradePolicyUrlDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.trade.TradePolicyUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——政策福利——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */
@RestController
@RequestMapping("/admin/trade-policy-url")
public class TradePolicyUrlController {
    @Resource
    private TradePolicyUrlService tradePolicyUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = tradePolicyUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePolicyUrlDto tradePolicyUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePolicyUrlService.save(tradePolicyUrlDto);
        responseDto.setContent(tradePolicyUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradePolicyUrlService.delete(id);
        return responseDto;
    }
}
