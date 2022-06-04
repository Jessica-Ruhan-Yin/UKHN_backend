package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicStudyAbroadUrl;
import com.UKHN_backend.server.domain.AcademicStudyAbroadUrlExample;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadUrlDto;
import com.UKHN_backend.server.mapper.AcademicStudyAbroadUrlMapper;
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
public class AcademicStudyAboradUrlService {
    @Resource
    private AcademicStudyAbroadUrlMapper academicStudyAbroadUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        AcademicStudyAbroadUrl url = academicStudyAbroadUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicStudyAbroadUrlDto academicStudyAbroadUrlDto) {
        AcademicStudyAbroadUrl academicStudyAbroadUrl = CopyUtil.copy(academicStudyAbroadUrlDto, AcademicStudyAbroadUrl.class);
        AcademicStudyAbroadUrlExample example = new AcademicStudyAbroadUrlExample();
        example.createCriteria().andIdEqualTo(academicStudyAbroadUrlDto.getId());
        List<AcademicStudyAbroadUrl> list = academicStudyAbroadUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicStudyAbroadUrl);
        } else {
            this.update(academicStudyAbroadUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicStudyAbroadUrl academicStudyAbroadUrl) {

        academicStudyAbroadUrlMapper.insert(academicStudyAbroadUrl);
    }

    /**
     * 更新
     */
    private void update(AcademicStudyAbroadUrl academicStudyAbroadUrl) {
        academicStudyAbroadUrlMapper.updateByPrimaryKey(academicStudyAbroadUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicStudyAbroadUrlMapper.deleteByPrimaryKey(id);
    }
}