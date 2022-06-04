package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.AcademicForumUrl;
import com.UKHN_backend.server.domain.AcademicForumUrlExample;
import com.UKHN_backend.server.dto.academic.AcademicForumUrlDto;
import com.UKHN_backend.server.mapper.AcademicForumUrlMapper;
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
public class AcademicForumUrlService {
    @Resource
    private AcademicForumUrlMapper academicForumUrlMapper;

    /**
     * 列表查询
     */
    public String list(Long id) {
        AcademicForumUrl url = academicForumUrlMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(url)){
            return "";
        }else{
            return url.getUrl();
        }
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(AcademicForumUrlDto academicForumUrlDto) {
        AcademicForumUrl academicForumUrl = CopyUtil.copy(academicForumUrlDto, AcademicForumUrl.class);
        AcademicForumUrlExample example = new AcademicForumUrlExample();
        example.createCriteria().andIdEqualTo(academicForumUrlDto.getId());
        List<AcademicForumUrl> list = academicForumUrlMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            this.insert(academicForumUrl);
        } else {
            this.update(academicForumUrl);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicForumUrl academicForumUrl) {

        academicForumUrlMapper.insert(academicForumUrl);
    }

    /**
     * 更新
     */
    private void update(AcademicForumUrl academicForumUrl) {
        academicForumUrlMapper.updateByPrimaryKey(academicForumUrl);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicForumUrlMapper.deleteByPrimaryKey(id);
    }
}