package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessFileDto;
import com.UKHN_backend.server.service.trade.TradeBusinessFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description 自贸港专栏——招商引资——合作详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-business-file")
public class TradeBusinessFileController {

    @Resource
    private TradeBusinessFileService tradeBusinessFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<TradeBusinessFileDto> policyFileDtoList = tradeBusinessFileService.list(id);
        responseDto.setContent(policyFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeBusinessFileDto tradeBusinessFileDto){

        ResponseDto responseDto = new ResponseDto();
        tradeBusinessFileService.save(tradeBusinessFileDto);
        responseDto.setContent(tradeBusinessFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessFileService.delete(id);
        return responseDto;
    }
}
