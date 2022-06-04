package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicReportContent;
import com.UKHN_backend.server.domain.AcademicReportContentExample;
import com.UKHN_backend.server.dto.academic.AcademicReportContentDto;
import com.UKHN_backend.server.mapper.AcademicReportContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.AcademicReportCust;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Tiffany
 * @Version v
 * @Date 2021/11/20
 */
@Service
public class AcademicReportContentService {

    @Resource
    private AcademicReportContentMapper academicReportContentMapper;

    @Resource
    private AcademicReportCust academicReportCust;
    /**
     * 列表查询
     * @param id
     * @return
     */
    public AcademicReportContentDto list(Long id){
        AcademicReportContent content = academicReportContentMapper.selectByPrimaryKey(id);
        academicReportCust.increaseViewCount(id);
        AcademicReportContentDto contentDto = new AcademicReportContentDto();
        if (ObjectUtils.isEmpty(content.getContent())){
            contentDto.setContent("");
            contentDto.setView(content.getView());
            return contentDto;
        }else {
            contentDto.setContent(content.getContent());
            contentDto.setView(content.getView());
            return contentDto;
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     * @param academicReportContentDto
     */
    public void save(AcademicReportContentDto academicReportContentDto){
        AcademicReportContent academicReportContent = CopyUtil.copy(academicReportContentDto,AcademicReportContent.class);
        AcademicReportContentExample example = new AcademicReportContentExample();
        example.createCriteria().andIdEqualTo(academicReportContentDto.getId());
        List<AcademicReportContent> list = academicReportContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(academicReportContent);
        }else {
            this.update(academicReportContent);
        }
    }

    /**
     * 新增
     * @param academicReportContent
     */
    private void insert(AcademicReportContent academicReportContent){
        academicReportContentMapper.insert(academicReportContent);
    }

    /**
     * 更新
     * @param academicReportContent
     */
    private void update(AcademicReportContent academicReportContent){
        academicReportContentMapper.updateByPrimaryKeyWithBLOBs(academicReportContent);
    }

    public void delete(Long id){
        academicReportContentMapper.deleteByPrimaryKey(id);
    }
}
