package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicStudyAbroadContentFile;
import com.UKHN_backend.server.domain.AcademicStudyAbroadContentFileExample;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentFileDto;
import com.UKHN_backend.server.mapper.AcademicStudyAbroadContentFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@Service
public class AcademicStudyAbroadContentFileService {
    @Resource
    private AcademicStudyAbroadContentFileMapper academicStudyAbroadContentFileMapper;

    /**
     * 列表查询
     */
    public List<AcademicStudyAbroadContentFileDto> list(Long slideId) {
        AcademicStudyAbroadContentFileExample example = new AcademicStudyAbroadContentFileExample();
        AcademicStudyAbroadContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<AcademicStudyAbroadContentFile> fileList = academicStudyAbroadContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, AcademicStudyAbroadContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicStudyAbroadContentFileDto academicStudyAbroadContentFileDto) {
        AcademicStudyAbroadContentFile academicStudyAbroadContentFile = CopyUtil.copy(academicStudyAbroadContentFileDto, AcademicStudyAbroadContentFile.class);
        if (StringUtils.isEmpty(academicStudyAbroadContentFileDto.getId())) {
            this.insert(academicStudyAbroadContentFile);
        } else {
            this.update(academicStudyAbroadContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicStudyAbroadContentFile academicStudyAbroadContentFile) {
        academicStudyAbroadContentFileMapper.insert(academicStudyAbroadContentFile);
    }

    /**
     * 更新
     */
    private void update(AcademicStudyAbroadContentFile academicStudyAbroadContentFile) {
        academicStudyAbroadContentFileMapper.updateByPrimaryKey(academicStudyAbroadContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicStudyAbroadContentFileMapper.deleteByPrimaryKey(id);
    }
}
