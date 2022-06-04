package com.UKHN.server.service.home;

import com.UKHN_backend.server.domain.HomePartners;
import com.UKHN_backend.server.domain.HomePartnersExample;
import com.UKHN_backend.server.dto.home.HomePartnersDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.HomePartnersMapper;
import com.UKHN_backend.server.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */
@Service
public class HomePartnersService {

    private static final Logger LOG = LoggerFactory.getLogger(HomePartnersService.class);

    @Resource
    private HomePartnersMapper homePartnersMapper;

    /**
     * 查询轮播图文
     */
    public void list(PageDto req) {
        List<List<HomePartnersDto>> a = new ArrayList<>();
        List<HomePartnersDto> list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {


            HomePartnersExample homePartnersExample = new HomePartnersExample();
            PageHelper.startPage(req.getPage(), req.getSize());

            HomePartnersExample.Criteria criteria1 = homePartnersExample.createCriteria();

            criteria1.andTypeEqualTo(i + "");
            List<HomePartners> homePartnersList = homePartnersMapper.selectByExample(homePartnersExample);


            PageInfo<HomePartners> pageInfo = new PageInfo<>(homePartnersList);
            LOG.info("总行数：{}", pageInfo.getTotal());
            LOG.info("总页数：{}", pageInfo.getPages());
            req.setTotal(pageInfo.getTotal());
            List<HomePartnersDto> homePartnersDtoList = CopyUtil.copyList(homePartnersList, HomePartnersDto.class);
            a.add(homePartnersDtoList);
        }

        for (List<HomePartnersDto> homePartnersDtos : a) {
            list.addAll(homePartnersDtos);
        }

        req.setList(list);
    }

    /**
     * 保存
     */
    public void save(HomePartnersDto homePartnersDto) {
        HomePartners homePartners = CopyUtil.copy(homePartnersDto, HomePartners.class);
        if (StringUtils.isEmpty(homePartnersDto.getId())) {
            this.insert(homePartners);
        } else {
            this.update(homePartners);
        }
    }

    /**
     * 新增
     */
    private void insert(HomePartners homePartners) {
        homePartnersMapper.insert(homePartners);
    }

    /**
     * 更新
     */
    private void update(HomePartners homePartners) {
        homePartnersMapper.updateByPrimaryKeySelective(homePartners);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        homePartnersMapper.deleteByPrimaryKey(id);
    }


    public void listType(PageDto req, String type){
        HomePartnersExample homePartnersExample = new HomePartnersExample();
        HomePartnersExample.Criteria criteria = homePartnersExample.createCriteria();
        criteria.andTypeEqualTo(type);
        PageHelper.startPage(req.getPage(), req.getSize());
        List<HomePartners> homePartners = homePartnersMapper.selectByExample(homePartnersExample);

        PageInfo<HomePartners> pageInfo = new PageInfo<>(homePartners);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<HomePartnersDto> homePartnersDtoList = CopyUtil.copyList(homePartners, HomePartnersDto.class);
        req.setList(homePartnersDtoList);
    }
}
