package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.trade.TradePolicyFileDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.trade.TradePolicyFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description 自贸港专栏——政策福利——合作详情内容文件
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-policy-file")
public class TradePolicyFileController {

    @Resource
    private TradePolicyFileService tradePolicyFileService;

    @GetMapping("/list/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        List<TradePolicyFileDto> policyFileDtoList = tradePolicyFileService.list(id);
        responseDto.setContent(policyFileDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePolicyFileDto tradePolicyFileDto){

        ResponseDto responseDto = new ResponseDto();
        tradePolicyFileService.save(tradePolicyFileDto);
        responseDto.setContent(tradePolicyFileDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradePolicyFileService.delete(id);
        return responseDto;
    }
}
