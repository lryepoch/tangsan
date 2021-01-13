package com.vblog.service;

import com.vblog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
public interface CategoryService extends IService<Category> {

    boolean deleteCategoryByIds(String ids);
}
