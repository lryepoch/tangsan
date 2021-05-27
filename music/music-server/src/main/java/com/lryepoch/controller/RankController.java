package com.lryepoch.controller;


import com.alibaba.fastjson.JSONObject;
import com.lryepoch.entity.Rank;
import com.lryepoch.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 评分控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    /**
    * 获取指定歌单的评分
    */
    @GetMapping(value = "/rank")
    public Object rankOfSongListId(HttpServletRequest request) {
        String songListId = request.getParameter("songListId");
        return rankService.rankOfSongListId(Long.parseLong(songListId));
    }

    /**
    * 提交评分
    */
    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    public Object addRank(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        String score = req.getParameter("score").trim();

        Rank rank = new Rank();
        rank.setSongListId(Integer.valueOf(songListId));
        rank.setConsumerId(Integer.valueOf(consumerId));
        rank.setScore(Integer.parseInt(score));

        boolean res = rankService.addRank(rank);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "评价成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "评价失败");
            return jsonObject;
        }
    }


}

