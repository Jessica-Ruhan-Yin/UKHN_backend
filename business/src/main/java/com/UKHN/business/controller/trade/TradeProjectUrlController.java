package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeProjectUrlDto;
import com.UKHN_backend.server.service.trade.TradeProjectUrlService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——项目合作——合作链接
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */
@RestController
@RequestMapping("/admin/trade-project-url")
public class TradeProjectUrlController {
    @Resource
    private TradeProjectUrlService tradeProjectUrlService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        String url = tradeProjectUrlService.list(id);
        responseDto.setContent(url);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeProjectUrlDto tradeProjectUrlDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeProjectUrlService.save(tradeProjectUrlDto);
        responseDto.setContent(tradeProjectUrlDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradeProjectUrlService.delete(id);
        return responseDto;
    }
}
