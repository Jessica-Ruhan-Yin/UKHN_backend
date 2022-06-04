package com.UKHN.server.service.academic;

import com.UKHN_backend.server.domain.*;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadDto;
import com.UKHN_backend.server.dto.academic.AcademicStudyAbroadContentDto;
import com.UKHN_backend.server.mapper.AcademicStudyAbroadContentMapper;
import com.UKHN_backend.server.mapper.AcademicStudyAbroadMapper;
import com.UKHN_backend.server.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/11/8
 */
@Service
public class AcademicStudyAbroadService {

    private static final Logger LOG = LoggerFactory.getLogger(AcademicStudyAbroadService.class);

    @Resource
    private AcademicStudyAbroadMapper academicStudyAbroadMapper;

    @Resource
    private AcademicStudyAbroadContentMapper academicStudyAbroadContentMapper;

    /**
     * 查询轮播图文
     */
    public List<AcademicStudyAbroadDto> list() {
        AcademicStudyAbroadExample academicStudyAbroadExample = new AcademicStudyAbroadExample();
        List<AcademicStudyAbroad> academicStudyAbroadList = academicStudyAbroadMapper.selectByExample(academicStudyAbroadExample);
        List<AcademicStudyAbroadDto> academicStudyAbroadDtoList = CopyUtil.copyList(academicStudyAbroadList, AcademicStudyAbroadDto.class);
        return academicStudyAbroadDtoList;
    }

    /**
     * 保存
     */
    public void save(AcademicStudyAbroadDto academicStudyAbroadDto) {
        AcademicStudyAbroad academicStudyAbroad = CopyUtil.copy(academicStudyAbroadDto, AcademicStudyAbroad.class);
        if (StringUtils.isEmpty(academicStudyAbroadDto.getId())) {
            this.insert(academicStudyAbroad);
        } else {
            this.update(academicStudyAbroad);
        }
    }

    /**
     * 新增
     */
    private void insert(AcademicStudyAbroad academicStudyAbroad) {
        academicStudyAbroadMapper.insert(academicStudyAbroad);
    }

    /**
     * 更新
     */
    private void update(AcademicStudyAbroad academicStudyAbroad) {
        academicStudyAbroadMapper.updateByPrimaryKeySelective(academicStudyAbroad);
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        academicStudyAbroadMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查找课程内容
     */
    public AcademicStudyAbroadContentDto findContent(Long id) {
        AcademicStudyAbroadContent content = academicStudyAbroadContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, AcademicStudyAbroadContentDto.class);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(AcademicStudyAbroadContentDto contentDto) {
        AcademicStudyAbroadContent content = CopyUtil.copy(contentDto, AcademicStudyAbroadContent.class);
        int i = academicStudyAbroadContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = academicStudyAbroadContentMapper.insert(content);
        }
        return i;
    }

    public AcademicStudyAbroadDto searchItem(Long id) {
        AcademicStudyAbroad academicStudyAbroad = academicStudyAbroadMapper.selectByPrimaryKey(id);
        AcademicStudyAbroadDto academicStudyAbroadDto = CopyUtil.copy(academicStudyAbroad,AcademicStudyAbroadDto.class);
        return academicStudyAbroadDto;
    }
}
