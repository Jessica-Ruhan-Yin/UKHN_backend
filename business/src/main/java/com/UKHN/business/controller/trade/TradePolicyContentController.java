package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.trade.TradePolicyContentDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.trade.TradePolicyContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——政策福利——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-policy-content")
public class TradePolicyContentController {

    @Resource
    TradePolicyContentService tradePolicyContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradePolicyContentDto content = tradePolicyContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePolicyContentDto tradePolicyContentDto){
        ResponseDto responseDto = new ResponseDto();
        tradePolicyContentService.save(tradePolicyContentDto);
        responseDto.setContent(tradePolicyContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradePolicyContentService.delete(id);
        return responseDto;
    }
}
