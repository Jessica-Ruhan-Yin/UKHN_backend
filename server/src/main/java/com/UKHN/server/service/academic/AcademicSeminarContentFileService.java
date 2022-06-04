package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicSeminarContentFile;
import com.UKHN_backend.server.domain.AcademicSeminarContentFileExample;
import com.UKHN_backend.server.dto.academic.AcademicSeminarContentFileDto;
import com.UKHN_backend.server.mapper.AcademicSeminarContentFileMapper;
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
public class AcademicSeminarContentFileService {
    @Resource
    private AcademicSeminarContentFileMapper academicSeminarContentFileMapper;

    /**
     * 列表查询
     */
    public List<AcademicSeminarContentFileDto> list(Long slideId) {
        AcademicSeminarContentFileExample example = new AcademicSeminarContentFileExample();
        AcademicSeminarContentFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(slideId);
        List<AcademicSeminarContentFile> fileList = academicSeminarContentFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList, AcademicSeminarContentFileDto.class);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicSeminarContentFileDto academicSeminarContentFileDto) {
        AcademicSeminarContentFile academicSeminarContentFile = CopyUtil.copy(academicSeminarContentFileDto, AcademicSeminarContentFile.class);
        if (StringUtils.isEmpty(academicSeminarContentFileDto.getId())) {
            this.insert(academicSeminarContentFile);
        } else {
            this.update(academicSeminarContentFile);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicSeminarContentFile academicSeminarContentFile) {
        academicSeminarContentFileMapper.insert(academicSeminarContentFile);
    }

    /**
     * 更新
     */
    private void update(AcademicSeminarContentFile academicSeminarContentFile) {
        academicSeminarContentFileMapper.updateByPrimaryKey(academicSeminarContentFile);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicSeminarContentFileMapper.deleteByPrimaryKey(id);
    }
}
