package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicForumFile;
import com.UKHN_backend.server.domain.AcademicForumFileExample;
import com.UKHN_backend.server.dto.academic.AcademicForumFileDto;
import com.UKHN_backend.server.mapper.AcademicForumFileMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcademicForumFileService {

    @Resource
    private AcademicForumFileMapper academicForumFileMapper;

    /**
     * 列表查询
     */
    public List<AcademicForumFileDto> list(Long id){
        AcademicForumFileExample example = new AcademicForumFileExample();
        AcademicForumFileExample.Criteria criteria = example.createCriteria();
        criteria.andSlideIdEqualTo(id);
        List<AcademicForumFile> fileList = academicForumFileMapper.selectByExample(example);
        return CopyUtil.copyList(fileList,AcademicForumFileDto.class);
    }
    /**
     * 保存
     */
    public void save(AcademicForumFileDto academicForumFileDto){
        AcademicForumFile academicForumFile = CopyUtil.copy(academicForumFileDto,AcademicForumFile.class);
        if (StringUtils.isEmpty(academicForumFileDto.getId())){
            this.insert(academicForumFile);
        }else {
            this.update(academicForumFile);
        }
    }

    /**
     * 新增
     * @param academicForumFile
     */
    private void insert(AcademicForumFile academicForumFile){
        academicForumFileMapper.insert(academicForumFile);
    }

    /**
     * 更新
     * @param academicForumFile
     */
    private void update(AcademicForumFile academicForumFile){
        academicForumFileMapper.updateByPrimaryKeySelective(academicForumFile);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        academicForumFileMapper.deleteByPrimaryKey(id);
    }
}
