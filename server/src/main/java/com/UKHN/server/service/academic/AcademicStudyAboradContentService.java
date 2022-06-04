package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicStudyAbroadContent;
import com.UKHN_backend.server.domain.AcademicStudyAbroadContentExample;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentDto;
import com.UKHN_backend.server.mapper.AcademicStudyAbroadContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.AcademicStudyAbroadCust;
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
public class AcademicStudyAboradContentService {
    @Resource
    private AcademicStudyAbroadContentMapper academicStudyAbroadContentMapper;
    
    @Resource
    private AcademicStudyAbroadCust academicStudyAbroadCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public AcademicStudyAbroadContentDto list(Long id){
        AcademicStudyAbroadContent content = academicStudyAbroadContentMapper.selectByPrimaryKey(id);
        academicStudyAbroadCust.increaseViewCount(id);
        AcademicStudyAbroadContentDto contentDto = new AcademicStudyAbroadContentDto();
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
     */
    public void save(AcademicStudyAbroadContentDto academicStudyAbroadContentDto) {
        AcademicStudyAbroadContent academicStudyAbroadContent = CopyUtil.copy(academicStudyAbroadContentDto, AcademicStudyAbroadContent.class);
        AcademicStudyAbroadContentExample example = new AcademicStudyAbroadContentExample();
        example.createCriteria().andIdEqualTo(academicStudyAbroadContentDto.getId());
        List<AcademicStudyAbroadContent> list = academicStudyAbroadContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicStudyAbroadContent);
        } else {
            this.update(academicStudyAbroadContent);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicStudyAbroadContent academicStudyAbroadContent) {

        academicStudyAbroadContentMapper.insert(academicStudyAbroadContent);
    }

    /**
     * 更新
     */
    private void update(AcademicStudyAbroadContent academicStudyAbroadContent) {
        academicStudyAbroadContentMapper.updateByPrimaryKeyWithBLOBs(academicStudyAbroadContent);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicStudyAbroadContentMapper.deleteByPrimaryKey(id);
    }
}