package com.blog.controller;

import com.blog.bean.Article;
import com.blog.config.ResultUtil;
import com.blog.config.ResultEnum;
import com.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author lryepoch
 * @date 2020/5/28 9:30
 * @description TODO 博客管理
 */
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
    * @description 新增博客、修改博客
    * @author lryepoch
    * @date 2020/5/29 9:46
    *
    */
    @PostMapping("/add")
    public ResultUtil addArticle(Article article) {
        int result = articleService.addArticle(article);
        if (result != 0 && result != -1) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
     * @description 图片上传,返回值是图片地址
     * @author lryepoch
     * @date 2020/5/28 15:01
     */
    @PostMapping("/uploadimg")
    public ResultUtil uploadImg(HttpServletRequest request, MultipartFile image) {
        StringBuffer url = new StringBuffer();
        String filePath = "/blogimg" + new SimpleDateFormat("yyyyMMdd").format(new Date());
        log.info("filePath:" + filePath);

        String imgFolderPath = request.getServletContext().getRealPath(filePath);
        log.info("imgFolderPath:" + imgFolderPath);

        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()){
            imgFolder.mkdirs();
        }
        //request.getScheme() 返回当前链接使用的协议；一般应用返回http;SSL返回https;
        url.append(request.getScheme())
                .append("://")
                .append(request.getServerName())
                .append(":")
                .append(request.getServerPort())
                .append(request.getContextPath())
                .append(filePath);
        log.info("url:" + url);

        String imgName = UUID.randomUUID()+"_"+image.getOriginalFilename().replaceAll(" ","");
        log.info("imgName:" + imgName);

        try {
            IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
            url.append("/").append(imgName);
            log.info("url:" + url);

            return ResultUtil.success(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(),"上传失败");
    }

    /**
    * @description 根据博客状态获取当前用户的各类博客
     *              state = -1，代表个人的全部文章，包括草稿箱、已发表、已删除
    * @author lryepoch
    * @date 2020/5/29 9:30
    *
    */
    @GetMapping("/all")
    public ResultUtil getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "5") Integer count, String keyword) {
        List<Article> articles = articleService.getArticleByState(state, page, count, keyword);
        if (articles != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 根据文章id获取具体内容
    * @author lryepoch
    * @date 2020/5/29 9:49
    *
    */
    @GetMapping("/{aid}")
    public ResultUtil getArticleById(@PathVariable Integer aid) {
        Article article = articleService.getArticleById(aid);
        if (article != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 对已发表和草稿箱中的博客进行删除
    * @author lryepoch
    * @date 2020/5/29 9:49
    *
    */
    @PutMapping("/dustbin")
    public ResultUtil updateArticleState(Integer[] aids, Integer state) {
        int result = articleService.updateArticleState(aids, state);
        if (result != 0) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

    /**
    * @description 获取数据统计
    * @author lryepoch
    * @date 2020/5/29 9:50
    *
    */
    @RequestMapping("/dataStatistics")
    public ResultUtil dataStatistics() {
        List<Map<Object, Object>> list = articleService.getData();
        if (list != null) {
            return ResultUtil.success();
        }
        return ResultUtil.fail(ResultEnum.ERR.getCode(), ResultEnum.ERR.getMsg());
    }

}
