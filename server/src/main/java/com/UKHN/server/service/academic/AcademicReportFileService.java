package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicReportFile;
import com.UKHN_backend.server.domain.AcademicReportFileExample;
import com.UKHN_backend.server.dto.academic.AcademicReportFileDto;
import com.UKHN_backend.server.mapper.AcademicReportFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcademicReportFileService {

    @Resource
    private AcademicReportFileMapper academicReportFileMapper;

    /**
     * 列表查询
     */
    public List<AcademicReportFileDto> list(Long id){
        AcademicReportFileExample example = new AcademicReportFileExample();
        AcademicReportFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<AcademicReportFile> fileList = academicReportFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,AcademicReportFileDto.class);
    }
    /**
     * 保存
     */
    public void save(AcademicReportFileDto academicReportFileDto){
        AcademicReportFile academicReportFile = CopyUtil.copy(academicReportFileDto,AcademicReportFile.class);
        if (StringUtils.isEmpty(academicReportFileDto.getId())){
            this.insert(academicReportFile);
        }else {
            this.update(academicReportFile);
        }
    }

    /**
     * 新增
     * @param academicReportFile
     */
    private void insert(AcademicReportFile academicReportFile){
        academicReportFileMapper.insert(academicReportFile);
    }

    /**
     * 更新
     * @param academicReportFile
     */
    private void update(AcademicReportFile academicReportFile){
        academicReportFileMapper.updateByPrimaryKeySelective(academicReportFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        academicReportFileMapper.deleteByPrimaryKey(id);
    }
}
