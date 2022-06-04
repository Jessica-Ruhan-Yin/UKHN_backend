package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeProjectFileDto;
import com.UKHN_backend.server.service.trade.TradeProjectFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description 自贸港专栏——项目合作——合作详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-project-file")
public class TradeProjectFileController {

    @Resource
    private TradeProjectFileService tradeProjectFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<TradeProjectFileDto> policyFileDtoList = tradeProjectFileService.list(id);
        responseDto.setContent(policyFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeProjectFileDto tradeProjectFileDto){

        ResponseDto responseDto = new ResponseDto();
        tradeProjectFileService.save(tradeProjectFileDto);
        responseDto.setContent(tradeProjectFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradeProjectFileService.delete(id);
        return responseDto;
    }
}
