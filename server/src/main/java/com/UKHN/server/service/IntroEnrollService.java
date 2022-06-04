package com.UKHN.server.service;

import com.UKHN_backend.server.domain.IntroEnroll;
import com.UKHN_backend.server.domain.IntroEnrollExample;
import com.UKHN_backend.server.dto.IntroEnrollDto;
import com.UKHN_backend.server.mapper.IntroEnrollMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/17
 */
@Service
public class IntroEnrollService {

    @Resource
    private IntroEnrollMapper introEnrollMapper;

    public List<IntroEnrollDto> list() {
        IntroEnrollExample introEnrollExample = new IntroEnrollExample();
        List<IntroEnroll> introEnrollList = introEnrollMapper.selectByExample(introEnrollExample);
        List<IntroEnrollDto> introEnrollDtoList = CopyUtil.copyList(introEnrollList, IntroEnrollDto.class);
        return introEnrollDtoList;
    }

    public void save(IntroEnroll introEnroll) {
        introEnrollMapper.updateByPrimaryKeySelective(introEnroll);
    }


}
