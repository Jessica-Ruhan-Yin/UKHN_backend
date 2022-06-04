package com.UKHN.business.controller.trade;

import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.ResponseDto;
import com.UKHN_backend.server.dto.trade.TradeProjectDto;
import com.UKHN_backend.server.dto.trade.TradeProjectContentDto;
import com.UKHN_backend.server.dto.trade.TradeProjectDto;
import com.UKHN_backend.server.service.trade.TradeProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 自贸港专栏——项目合作
 * @Author Jessica
 * @Version v
 * @Date 2022/04/26
 */

@RestController
@RequestMapping("/admin/trade-project")
public class TradeProjectController {

    @Resource
    private TradeProjectService tradeProjectService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeProjectService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TradeProjectDto tradeProjectDto) {
        ResponseDto responseDto = new ResponseDto();
        tradeProjectService.save(tradeProjectDto);
        responseDto.setContent(tradeProjectDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        ResponseDto responseDto = new ResponseDto();
        tradeProjectService.delete(id);
        return responseDto;
    }
    /**
     * 根据id查找标题和日期
     */
    @GetMapping("/search/{id}")
    public ResponseDto searchItem(@PathVariable Long id){
        ResponseDto responseDto = new ResponseDto();
        TradeProjectDto content = tradeProjectService.searchItem(id);
        responseDto.setContent(content);
        return responseDto;
    }

}
