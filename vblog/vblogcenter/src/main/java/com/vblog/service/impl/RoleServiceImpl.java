package com.vblog.service.impl;

import com.vblog.entity.Role;
import com.vblog.dao.RoleMapper;
import com.vblog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
