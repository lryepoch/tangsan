package com.vblog.controller;


import com.vblog.config.RespBean;
import com.vblog.entity.Article;
import com.vblog.service.ArticleService;
import com.vblog.util.SubjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-01-13
 */
@Api(description = "博客操作")
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @ApiOperation(value = "写新博客")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RespBean addNewArticle(Article article) {
        int result = articleService.addNewArticle(article);
        if (result == 1) {
            return new RespBean("success", article.getId() + "");
        } else {
            return new RespBean("error", article.getState() == 0 ? "文章保存失败!" : "文章发表失败!");
        }
    }

    @ApiOperation(value = "上传图片, 返回值为图片的地址")
    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
    public RespBean uploadImg(HttpServletRequest req, MultipartFile image) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        StringBuffer url = new StringBuffer();
        String filePath = "/blogimg/" + sdf.format(new Date());
        log.info("filePath:" + filePath);

        String imgFolderPath = req.getServletContext().getRealPath(filePath);
        log.info("imgFolderPath:" + imgFolderPath);

        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()) {
            imgFolder.mkdirs();
        }
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append(filePath);
        log.info("url:" + url);

        String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
        log.info("imgName:" + imgName);

        try {
            IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
            url.append("/").append(imgName);
            log.info("url:" + url);

            return new RespBean("success", url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RespBean("error", "上传失败!");
    }

    @ApiOperation(value = "查看各栏博客列表，0表示草稿箱，1表示已发表，2表示已删除，-1默认表示全部文章")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state,
                                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "count", defaultValue = "5") Integer count,
                                                 String keywords) {
        //获取用户在当前分栏下的博客数量
        int totalCount = articleService.getArticleCountByState(state, SubjectUtil.getCurrentUser().getId(), keywords);
        List<Article> articles = articleService.getArticleByState(state, page, count, keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("articles", articles);
        return map;
    }

    @ApiOperation(value = "根据id查看博客")
    @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
    public Article getArticleById(@PathVariable Integer aid) {
        return articleService.getArticleById(aid);
    }

    @ApiOperation(value = "更新博客状态")
    @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
    public RespBean updateArticleState(Integer[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @ApiOperation(value = "还原博客状态")
    @RequestMapping(value = "/restore", method = RequestMethod.PUT)
    public RespBean restoreArticle(Integer articleId) {
        if (articleService.restoreArticle(articleId)) {
            return new RespBean("success", "还原成功!");
        }
        return new RespBean("error", "还原失败!");
    }

    @ApiOperation(value = "访问统计")
    @GetMapping("/dataStatistics")
    public Map<String, Object> dataStatistics() {
        Map<String, Object> map = new HashMap<>();
        List<String> categories = articleService.getCategories();
        List<Integer> dataStatistics = articleService.getDataStatistics();
        map.put("categories", categories);
        map.put("ds", dataStatistics);
        return map;
    }
}

