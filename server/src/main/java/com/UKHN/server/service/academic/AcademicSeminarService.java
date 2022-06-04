package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicSeminar;
import com.UKHN_backend.server.domain.AcademicSeminarContent;
import com.UKHN_backend.server.domain.AcademicSeminar;
import com.UKHN_backend.server.domain.AcademicSeminarExample;
import com.UKHN_backend.server.dto.academic.AcademicSeminarDto;
import com.UKHN_backend.server.dto.academic.AcademicSeminarContentDto;
import com.UKHN_backend.server.dto.academic.AcademicSeminarDto;
import com.UKHN_backend.server.dto.academic.AcademicSeminarPageDto;
import com.UKHN_backend.server.mapper.AcademicSeminarContentMapper;
import com.UKHN_backend.server.mapper.AcademicSeminarMapper;
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
 * @Date 2021/11/8
 */
@Service
public class AcademicSeminarService {

    private static final Logger LOG = LoggerFactory.getLogger(AcademicSeminarService.class);

    @Resource
    private AcademicSeminarMapper academicSeminarMapper;

    @Resource
    private AcademicSeminarContentMapper academicSeminarContentMapper;

    /**
     * 查询轮播图文
     */
    public void list(AcademicSeminarPageDto req) {
        AcademicSeminarExample academicSeminarExample = new AcademicSeminarExample();
        academicSeminarExample.setOrderByClause("id desc");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<AcademicSeminar> academicSeminarList = academicSeminarMapper.selectByExample(academicSeminarExample);

        PageInfo<AcademicSeminar> pageInfo = new PageInfo<>(academicSeminarList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        req.setTotal(pageInfo.getTotal());
        List<AcademicSeminarDto> academicSeminarDtoList = CopyUtil.copyList(academicSeminarList, AcademicSeminarDto.class);
        req.setList(academicSeminarDtoList);
    }

    /**
     * 保存
     */
    public void save(AcademicSeminarDto academicSeminarDto) {
        AcademicSeminar academicSeminar = CopyUtil.copy(academicSeminarDto, AcademicSeminar.class);
        if (StringUtils.isEmpty(academicSeminarDto.getId())) {
            this.insert(academicSeminar);
        } else {
            this.update(academicSeminar);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicSeminar academicSeminar) {
        academicSeminarMapper.insert(academicSeminar);
    }

    /**
     * 更新
     */
    private void update(AcademicSeminar academicSeminar) {
        academicSeminarMapper.updateByPrimaryKeySelective(academicSeminar);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicSeminarMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public AcademicSeminarContentDto findContent(Long id) {
        AcademicSeminarContent content = academicSeminarContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, AcademicSeminarContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(AcademicSeminarContentDto contentDto) {
        AcademicSeminarContent content = CopyUtil.copy(contentDto, AcademicSeminarContent.class);
        int i = academicSeminarContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = academicSeminarContentMapper.insert(content);
        }
        return i;
    }

    public AcademicSeminarDto searchItem(Long id) {
        AcademicSeminar academicSeminar = academicSeminarMapper.selectByPrimaryKey(id);
        AcademicSeminarDto academicSeminarDto = CopyUtil.copy(academicSeminar,AcademicSeminarDto.class);
        return academicSeminarDto;
    }
}
