package com.vblog.service.impl;

import com.vblog.entity.Category;
import com.vblog.dao.CategoryMapper;
import com.vblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public boolean deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        List<String> stringList= Arrays.asList(split);
        return removeByIds(stringList);
    }
}
