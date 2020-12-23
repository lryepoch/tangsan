package com.blog.service;

import com.blog.bean.Category;
import com.blog.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/27 18:40
 * @description TODO 栏目管理
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    public int addCategory(Category category) {
        if ("".equals(category.getCateName())||category.getCateName()==null){
            return -1;
        }
        int result = categoryMapper.check(category.getCateName());
        if (result>0){
            return -2;
        }
        return categoryMapper.addCategory(category.getCateName());
    }

    public int updateCategory(Category category) {
        if ("".equals(category.getCateName())||category.getCateName()==null){
            return -1;
        }
        int result = categoryMapper.check(category.getCateName());
        if (result>0){
            return -2;
        }
        return categoryMapper.updateCategory(category.getCateName());
    }

    public int deleteCategory(String ids) {
        String[] split = ids.split(",");
        return categoryMapper.deleteCategory(split);
    }
}
