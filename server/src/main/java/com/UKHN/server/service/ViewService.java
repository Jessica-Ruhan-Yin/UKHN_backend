package com.UKHN.server.service;

import com.UKHN_backend.server.domain.View;
import com.UKHN_backend.server.dto.ViewDto;
import com.UKHN_backend.server.mapper.CustMapper.ViewCust;
import com.UKHN_backend.server.mapper.ViewMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/20
 */
@Service
public class ViewService {

    @Resource
    private ViewMapper viewMapper;

    @Resource
    private ViewCust viewCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public ViewDto list(String id){
        View content = viewMapper.selectByPrimaryKey(id);
        viewCust.increaseViewCount(id);
        return CopyUtil.copy(content, ViewDto.class);
    }

}
