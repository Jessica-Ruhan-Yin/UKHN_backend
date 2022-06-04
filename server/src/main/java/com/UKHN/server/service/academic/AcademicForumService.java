package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicForum;
import com.UKHN_backend.server.domain.AcademicForumContent;
import com.UKHN_backend.server.domain.AcademicForumExample;
import com.UKHN_backend.server.dto.academic.AcademicForumContentDto;
import com.UKHN_backend.server.dto.academic.AcademicForumDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.AcademicForumContentMapper;
import com.UKHN_backend.server.mapper.AcademicForumMapper;
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
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/20
 */
@Service
public class AcademicForumService {

    private static final Logger LOG = LoggerFactory.getLogger(AcademicForumService.class);


    @Resource
    private AcademicForumContentMapper academicForumContentMapper;

    @Resource
    private AcademicForumMapper academicForumMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        AcademicForumExample academicForumExample = new AcademicForumExample();
        academicForumExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<AcademicForum> academicForumList = academicForumMapper.selectByExample(academicForumExample);

        PageInfo<AcademicForum> pageInfo = new PageInfo<>(academicForumList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<AcademicForumDto> academicForumDtoList = CopyUtil.copyList(academicForumList,AcademicForumDto.class);
        pageDto.setList(academicForumDtoList);
    }

    /**
     * 保存
     */
    public void save(AcademicForumDto academicForumDto){
        AcademicForum academicForum = CopyUtil.copy(academicForumDto,AcademicForum.class);
        if (StringUtils.isEmpty(academicForumDto.getId())){
            this.insert(academicForum);
        }else {
            this.update(academicForum);
        }
    }

    /**
     * 新增
     * @param academicForum
     */
    private void insert(AcademicForum academicForum){
        academicForumMapper.insert(academicForum);
    }

    /**
     * 更新
     * @param academicForum
     */
    private void update(AcademicForum academicForum){
        academicForumMapper.updateByPrimaryKeySelective(academicForum);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        academicForumMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public AcademicForumContentDto findContent(Long id){
        AcademicForumContent academicForumContent = academicForumContentMapper.selectByPrimaryKey(id);
        if (academicForumContent==null){
            return null;
        }
        return CopyUtil.copy(academicForumContent, AcademicForumContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param academicForumContentDto
     * @return
     */
    public int saveContent(AcademicForumContentDto academicForumContentDto){
        AcademicForumContent academicForumContent = CopyUtil.copy(academicForumContentDto,AcademicForumContent.class);
        int i = academicForumContentMapper.updateByPrimaryKeyWithBLOBs(academicForumContent);
        if (i == 0){
            i = academicForumContentMapper.insert(academicForumContent);
        }
        return i;

    }

    public AcademicForumDto searchItem(Long id) {
        AcademicForum academicForum = academicForumMapper.selectByPrimaryKey(id);
        AcademicForumDto academicForumDto = CopyUtil.copy(academicForum,AcademicForumDto.class);
        return academicForumDto;
    }
}
