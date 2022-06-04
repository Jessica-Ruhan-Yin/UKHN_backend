package com.UKHN.server.service.trade;

import com.UKHN_backend.server.domain.TradeProject;
import com.UKHN_backend.server.domain.TradeProject;
import com.UKHN_backend.server.domain.TradeProjectContent;
import com.UKHN_backend.server.domain.TradeProjectExample;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.dto.trade.TradeProjectDto;
import com.UKHN_backend.server.dto.trade.TradeProjectContentDto;
import com.UKHN_backend.server.dto.trade.TradeProjectDto;
import com.UKHN_backend.server.mapper.TradeProjectContentMapper;
import com.UKHN_backend.server.mapper.TradeProjectMapper;
import com.UKHN_backend.server.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/20
 */
@Service
public class TradeProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(TradeProjectService.class);


    @Resource
    private TradeProjectContentMapper tradeProjectContentMapper;

    @Resource
    private TradeProjectMapper tradeProjectMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        TradeProjectExample tradeProjectExample = new TradeProjectExample();
        tradeProjectExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<TradeProject> tradeProjectList = tradeProjectMapper.selectByExample(tradeProjectExample);

        PageInfo<TradeProject> pageInfo = new PageInfo<>(tradeProjectList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<TradeProjectDto> tradeProjectDtoList = CopyUtil.copyList(tradeProjectList,TradeProjectDto.class);
        pageDto.setList(tradeProjectDtoList);
    }

    /**
     * 保存
     */
    public void save(TradeProjectDto tradeProjectDto){
        TradeProject tradeProject = CopyUtil.copy(tradeProjectDto,TradeProject.class);
        if (StringUtils.isEmpty(tradeProjectDto.getId())){
            this.insert(tradeProject);
        }else {
            this.update(tradeProject);
        }
    }

    /**
     * 新增
     * @param tradeProject
     */
    private void insert(TradeProject tradeProject){
        tradeProjectMapper.insert(tradeProject);
    }

    /**
     * 更新
     * @param tradeProject
     */
    private void update(TradeProject tradeProject){
        tradeProjectMapper.updateByPrimaryKeySelective(tradeProject);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        tradeProjectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public TradeProjectContentDto findContent(Long id){
        TradeProjectContent tradeProjectContent = tradeProjectContentMapper.selectByPrimaryKey(id);
        if (tradeProjectContent==null){
            return null;
        }
        return CopyUtil.copy(tradeProjectContent, TradeProjectContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param tradeProjectContentDto
     * @return
     */
    public int saveContent(TradeProjectContentDto tradeProjectContentDto){
        TradeProjectContent tradeProjectContent = CopyUtil.copy(tradeProjectContentDto,TradeProjectContent.class);
        int i = tradeProjectContentMapper.updateByPrimaryKeyWithBLOBs(tradeProjectContent);
        if (i == 0){
            i = tradeProjectContentMapper.insert(tradeProjectContent);
        }
        return i;

    }

    public TradeProjectDto searchItem(Long id) {
        TradeProject tradeProject = tradeProjectMapper.selectByPrimaryKey(id);
        TradeProjectDto tradeProjectDto = CopyUtil.copy(tradeProject,TradeProjectDto.class);
        return tradeProjectDto;
    }
}
