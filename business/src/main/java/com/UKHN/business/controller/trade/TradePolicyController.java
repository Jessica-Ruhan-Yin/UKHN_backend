package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.trade.TradePolicyContentDto;
import com.UKHN_backend.server.dto.trade.TradePolicyDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.service.trade.TradePolicyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——政策福利
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-policy")
public class TradePolicyController {

    @Resource
    private TradePolicyService tradePolicyService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePolicyService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradePolicyDto tradePolicyDto) {
        ResponseDto responseDto = new ResponseDto();
        tradePolicyService.save(tradePolicyDto);
        responseDto.setContent(tradePolicyDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradePolicyService.delete(id);
        return responseDto;
    }

    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradePolicyDto content = tradePolicyService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }
}
