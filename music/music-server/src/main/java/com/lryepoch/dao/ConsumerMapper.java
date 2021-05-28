package com.lryepoch.dao;

import com.lryepoch.entity.Consumer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface ConsumerMapper extends BaseMapper<Consumer> {

    int verifyPassword(@Param("username") String username, @Param("password") String password);
}
