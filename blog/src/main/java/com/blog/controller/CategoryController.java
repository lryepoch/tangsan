package com.blog.controller;

import com.blog.bean.Category;
import com.blog.config.ResultUtil;
import com.blog.config.ResultEnum;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/27 18:40
 * @description TODO 栏目管理
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResultUtil getAllCategories() {
        List<Category> categories = categoryService.getAllCategory();
        if (categories != null) {
            return ResultUtil.success(categories);
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    @PostMapping("/add")
    public ResultUtil addCategory(Category category) {
        int result = categoryService.addCategory(category);
        if (result == -1) {
            return ResultUtil.fail(ResultEnum.NO_DATA.getCode(), ResultEnum.NO_DATA.getMsg());
        }
        if (result==-2){
            return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
        }
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public ResultUtil updateCategory(Category category) {
        int result = categoryService.updateCategory(category);
        if (result == -1) {
            return ResultUtil.fail(ResultEnum.NO_DATA.getCode(), ResultEnum.NO_DATA.getMsg());
        }
        if (result==-2){
            return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
        }
        return ResultUtil.success();
    }

    @DeleteMapping("/delete")
    public ResultUtil deleteCategory(String ids){

        int result = categoryService.deleteCategory(ids);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());

    }

}
