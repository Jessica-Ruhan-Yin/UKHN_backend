package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicReport;
import com.UKHN_backend.server.domain.AcademicReport;
import com.UKHN_backend.server.domain.AcademicReportContent;
import com.UKHN_backend.server.domain.AcademicReportExample;
import com.UKHN_backend.server.dto.academic.AcademicReportDto;
import com.UKHN_backend.server.dto.academic.AcademicReportContentDto;
import com.UKHN_backend.server.dto.academic.AcademicReportDto;
import com.UKHN_backend.server.dto.PageDto;
import com.UKHN_backend.server.mapper.AcademicReportContentMapper;
import com.UKHN_backend.server.mapper.AcademicReportMapper;
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
 * @Date 2021/11/21
 */
@Service
public class AcademicReportService {

    private static final Logger LOG = LoggerFactory.getLogger(AcademicReportService.class);


    @Resource
    private AcademicReportContentMapper academicReportContentMapper;

    @Resource
    private AcademicReportMapper academicReportMapper;

    /**
     * 查询图文
     */
    public void list(PageDto pageDto){
        AcademicReportExample academicReportExample = new AcademicReportExample();
        academicReportExample.setOrderByClause("date desc");
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<AcademicReport> academicReportList = academicReportMapper.selectByExample(academicReportExample);

        PageInfo<AcademicReport> pageInfo = new PageInfo<>(academicReportList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        pageDto.setTotal(pageInfo.getTotal());

        List<AcademicReportDto> academicReportDtoList = CopyUtil.copyList(academicReportList,AcademicReportDto.class);
        pageDto.setList(academicReportDtoList);
    }

    /**
     * 保存
     */
    public void save(AcademicReportDto academicReportDto){
        AcademicReport academicReport = CopyUtil.copy(academicReportDto,AcademicReport.class);
        if (StringUtils.isEmpty(academicReportDto.getId())){
            this.insert(academicReport);
        }else {
            this.update(academicReport);
        }
    }

    /**
     * 新增
     * @param academicReport
     */
    private void insert(AcademicReport academicReport){
        academicReportMapper.insert(academicReport);
    }

    /**
     * 更新
     * @param academicReport
     */
    private void update(AcademicReport academicReport){
        academicReportMapper.updateByPrimaryKeySelective(academicReport);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        academicReportMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找内容
     * @param id
     * @return
     */
    public AcademicReportContentDto findContent(Long id){
        AcademicReportContent academicReportContent = academicReportContentMapper.selectByPrimaryKey(id);
        if (academicReportContent==null){
            return null;
        }
        return CopyUtil.copy(academicReportContent, AcademicReportContentDto.class);
    }

    /**
     * 保存内容，包含新增和修改
     * @param academicReportContentDto
     * @return
     */
    public int saveContent(AcademicReportContentDto academicReportContentDto){
        AcademicReportContent academicReportContent = CopyUtil.copy(academicReportContentDto,AcademicReportContent.class);
        int i = academicReportContentMapper.updateByPrimaryKeyWithBLOBs(academicReportContent);
        if (i == 0){
            i = academicReportContentMapper.insert(academicReportContent);
        }
        return i;

    }

    public AcademicReportDto searchItem(Long id) {
        AcademicReport academicReport = academicReportMapper.selectByPrimaryKey(id);
        AcademicReportDto academicReportDto = CopyUtil.copy(academicReport,AcademicReportDto.class);
        return academicReportDto;
    }
}
