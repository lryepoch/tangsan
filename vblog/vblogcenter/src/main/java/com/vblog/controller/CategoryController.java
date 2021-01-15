package com.vblog.controller;


import com.vblog.config.RespBean;
import com.vblog.entity.Category;
import com.vblog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 * @description
 */
@Api(description = "标签操作")
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "查询全部栏目")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.list();
    }

    @ApiOperation(value = "批量删除栏目")
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteById(@PathVariable String ids) {
        boolean result = categoryService.deleteCategoryByIds(ids);
        if (result) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @ApiOperation(value = "新增栏目")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespBean addNewCate(Category category) {

        if ("".equals(category.getCateName()) || category.getCateName() == null) {
            return new RespBean("error", "请输入栏目名称!");
        }

        category.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        boolean flag = categoryService.save(category);

        if (flag) {
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }

    @ApiOperation(value = "编辑栏目")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public RespBean updateCate(Category category) {
        category.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        boolean flag = categoryService.updateById(category);
        if (flag) {
            return new RespBean("success", "修改成功!");
        }
        return new RespBean("error", "修改失败!");
    }
}

