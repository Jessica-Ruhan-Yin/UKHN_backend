package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicForumContent;
import com.UKHN_backend.server.domain.AcademicForumContentExample;
import com.UKHN_backend.server.dto.academic.AcademicForumContentDto;
import com.UKHN_backend.server.mapper.AcademicForumContentMapper;
import com.UKHN_backend.server.mapper.CustMapper.AcademicForumCust;
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
public class AcademicForumContentService {

    @Resource
    private AcademicForumContentMapper academicForumContentMapper;

    @Resource
    private AcademicForumCust academicForumCust;

    /**
     * 列表查询
     * @param id
     * @return
     */
    public AcademicForumContentDto list(Long id){
        AcademicForumContent content = academicForumContentMapper.selectByPrimaryKey(id);
        academicForumCust.increaseViewCount(id);
        AcademicForumContentDto contentDto = new AcademicForumContentDto();
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
     * @param academicForumContentDto
     */
    public void save(AcademicForumContentDto academicForumContentDto){
        AcademicForumContent academicForumContent = CopyUtil.copy(academicForumContentDto,AcademicForumContent.class);
        AcademicForumContentExample example = new AcademicForumContentExample();
        example.createCriteria().andIdEqualTo(academicForumContentDto.getId());
        List<AcademicForumContent> list = academicForumContentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            this.insert(academicForumContent);
        }else {
            this.update(academicForumContent);
        }
    }

    /**
     * 新增
     * @param academicForumContent
     */
    private void insert(AcademicForumContent academicForumContent){
        academicForumContentMapper.insert(academicForumContent);
    }

    /**
     * 更新
     * @param academicForumContent
     */
    private void update(AcademicForumContent academicForumContent){
        academicForumContentMapper.updateByPrimaryKeyWithBLOBs(academicForumContent);
    }

    public void delete(Long id){
        academicForumContentMapper.deleteByPrimaryKey(id);
    }
}
