package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradePromotionFileDto;
import com.UKHN_backend.server.service.trade.TradePromotionFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-promotion-file")
public class TradePromotionFileController {

    @Resource
    private TradePromotionFileService tradePromotionFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<TradePromotionFileDto> policyFileDtoList = tradePromotionFileService.list(id);
        responseDto.setContent(policyFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePromotionFileDto tradePromotionFileDto){

        ResponseDto responseDto = new ResponseDto();
        tradePromotionFileService.save(tradePromotionFileDto);
        responseDto.setContent(tradePromotionFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradePromotionFileService.delete(id);
        return responseDto;
    }
}
