package com.blog.controller.admin;

import com.blog.bean.Article;
import com.blog.config.ResultUtil;
import com.blog.config.ResultEnum;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lryepoch
 * @date 2020/5/29 8:56
 * @description TODO
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ArticleService articleService;

    /**
    * @description 不带状态查询所有人的博客
    * @author lryepoch
    * @date 2020/5/29 9:16
    *
    */
    @GetMapping("/article/all")
    public ResultUtil getArticleByStateByAdmin(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "5") Integer count, String keyword){
        List<Article> articles = articleService.getArticleByState(-2,page,count,keyword);
        if (articles!=null){
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(),ResultEnum.ERR.getMsg());
    }

    /**
     * @description 超管可任意删除所有人的博客
     * @author lryepoch
     * @date 2020/5/29 9:11
     *
     */
    @PutMapping("/article/dustbin")
    public ResultUtil updateArticleState(Integer[] aids, Integer state){
        int result = articleService.updateArticleState(aids, state);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

}

