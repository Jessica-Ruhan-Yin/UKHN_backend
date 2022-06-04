package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeProjectContentDto;
import com.UKHN_backend.server.service.trade.TradeProjectContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——项目合作——合作详情
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-project-content")
public class TradeProjectContentController {

    @Resource
    TradeProjectContentService tradeProjectContentService;

    @GetMapping("/show/{id}")
    public ResponseDto list(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradeProjectContentDto content = tradeProjectContentService.list(id);
        responseDto.setContent(content);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeProjectContentDto tradeProjectContentDto){
        ResponseDto responseDto = new ResponseDto();
        tradeProjectContentService.save(tradeProjectContentDto);
        responseDto.setContent(tradeProjectContentDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        tradeProjectContentService.delete(id);
        return responseDto;
    }
}
