package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicReportUrl;
import com.UKHN_backend.server.domain.AcademicReportUrlExample;
import com.UKHN_backend.server.dto.academic.AcademicReportUrlDto;
import com.UKHN_backend.server.mapper.AcademicReportUrlMapper;
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
 * @Date 2021/12/06
 */

@Service
public class AcademicReportUrlService {
    @Resource
    private AcademicReportUrlMapper academicReportUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        AcademicReportUrl url = academicReportUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicReportUrlDto academicReportUrlDto) {
        AcademicReportUrl academicReportUrl = CopyUtil.copy(academicReportUrlDto, AcademicReportUrl.class);
        AcademicReportUrlExample example = new AcademicReportUrlExample();
        example.createCriteria().andIdEqualTo(academicReportUrlDto.getId());
        List<AcademicReportUrl> list = academicReportUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicReportUrl);
        } else {
            this.update(academicReportUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicReportUrl academicReportUrl) {

        academicReportUrlMapper.insert(academicReportUrl);
    }

    /**
     * 更新
     */
    private void update(AcademicReportUrl academicReportUrl) {
        academicReportUrlMapper.updateByPrimaryKey(academicReportUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicReportUrlMapper.deleteByPrimaryKey(id);
    }
}