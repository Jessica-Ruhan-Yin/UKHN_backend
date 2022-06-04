package com.UKHN.server.mapper.CustMapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/8/28
 */
public interface HomeNewsCust {

    public void increaseViewCount(@Param("id") Long id);

}
