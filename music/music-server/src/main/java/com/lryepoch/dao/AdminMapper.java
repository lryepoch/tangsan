package com.lryepoch.dao;

import com.lryepoch.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 验证密码是否正确
     */
    int verifyPassword(@Param("username") String username, @Param("password") String password);

}
