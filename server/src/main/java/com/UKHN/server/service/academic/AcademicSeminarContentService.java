package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicSeminarContent;
import com.UKHN_backend.server.domain.AcademicSeminarContentExample;
import com.UKHN_backend.server.dto.academic.AcademicSeminarContentDto;
import com.UKHN_backend.server.mapper.AcademicSeminarContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.AcademicSeminarCust;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/16
 */
@Service
public class AcademicSeminarContentService {
    @Resource
    private AcademicSeminarContentMapper academicSeminarContentMapper;

    @Resource
    private AcademicSeminarCust academicSeminarCust;

    /**
     * 列表查询
     *
     * @param id
     * @return
     */
    public AcademicSeminarContentDto list(Long id) {
        AcademicSeminarContent content = academicSeminarContentMapper.selectByPrimaryKey(id);
        academicSeminarCust.increaseViewCount(id);
        AcademicSeminarContentDto contentDto = new AcademicSeminarContentDto();
        if (ObjectUtils.isEmpty(content.getContent())) {
            contentDto.setContent("");
            contentDto.setView(content.getView());
            return contentDto;
        } else {
            contentDto.setContent(content.getContent());
            contentDto.setView(content.getView());
            return contentDto;
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicSeminarContentDto academicSeminarContentDto) {
        AcademicSeminarContent academicSeminarContent = CopyUtil.copy(academicSeminarContentDto, AcademicSeminarContent.class);
        AcademicSeminarContentExample example = new AcademicSeminarContentExample();
        example.createCriteria().andIdEqualTo(academicSeminarContentDto.getId());
        List<AcademicSeminarContent> list = academicSeminarContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicSeminarContent);
        } else {
            this.update(academicSeminarContent);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicSeminarContent academicSeminarContent) {

        academicSeminarContentMapper.insert(academicSeminarContent);
    }

    /**
     * 更新
     */
    private void update(AcademicSeminarContent academicSeminarContent) {
        academicSeminarContentMapper.updateByPrimaryKeyWithBLOBs(academicSeminarContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicSeminarContentMapper.deleteByPrimaryKey(id);
    }
}