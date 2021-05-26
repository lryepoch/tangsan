package com.lryepoch.service;

import com.lryepoch.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
public interface AdminService extends IService<Admin> {

    /**
     * 验证密码是否正确
     */
    boolean verifyPassword(String username, String password);
}
