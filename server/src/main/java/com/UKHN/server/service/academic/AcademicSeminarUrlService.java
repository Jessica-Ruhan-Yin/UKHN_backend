package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicSeminarUrl;
import com.UKHN_backend.server.domain.AcademicSeminarUrlExample;
import com.UKHN_backend.server.dto.academic.AcademicSeminarUrlDto;
import com.UKHN_backend.server.mapper.AcademicSeminarUrlMapper;
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
public class AcademicSeminarUrlService {
    @Resource
    private AcademicSeminarUrlMapper academicSeminarUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        AcademicSeminarUrl url = academicSeminarUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicSeminarUrlDto academicSeminarUrlDto) {
        AcademicSeminarUrl academicSeminarUrl = CopyUtil.copy(academicSeminarUrlDto, AcademicSeminarUrl.class);
        AcademicSeminarUrlExample example = new AcademicSeminarUrlExample();
        example.createCriteria().andIdEqualTo(academicSeminarUrlDto.getId());
        List<AcademicSeminarUrl> list = academicSeminarUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicSeminarUrl);
        } else {
            this.update(academicSeminarUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicSeminarUrl academicSeminarUrl) {

        academicSeminarUrlMapper.insert(academicSeminarUrl);
    }

    /**
     * 更新
     */
    private void update(AcademicSeminarUrl academicSeminarUrl) {
        academicSeminarUrlMapper.updateByPrimaryKey(academicSeminarUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicSeminarUrlMapper.deleteByPrimaryKey(id);
    }
}