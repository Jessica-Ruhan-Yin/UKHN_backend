package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessContentDto;
import com.UKHN_backend.server.dto.trade.TradeBusinessDto;
import com.UKHN_backend.server.service.trade.TradeBusinessService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——招商引资
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-business")
public class TradeBusinessController {

    @Resource
    private TradeBusinessService tradeBusinessService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeBusinessDto tradeBusinessDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessService.save(tradeBusinessDto);
        responseDto.setContent(tradeBusinessDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradeBusinessService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradeBusinessDto content = tradeBusinessService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
