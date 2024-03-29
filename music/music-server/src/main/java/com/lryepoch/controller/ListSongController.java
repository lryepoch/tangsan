package com.lryepoch.controller;


import com.alibaba.fastjson.JSONObject;
import com.lryepoch.entity.ListSong;
import com.lryepoch.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 歌单歌曲关系控制器
 * </p>
 *
 * @author lryepoch
 * @since 2021-05-24
 */
@RestController
public class ListSongController {

    @Autowired
    private ListSongService listSongService;


    /**
     * 返回歌单里包含的所有歌曲
     */
    @RequestMapping(value = "/listSong", method = RequestMethod.GET)
    public Object allListSong() {
        return listSongService.allListSong();
    }

    /**
     * 返回歌单里指定歌单ID的歌曲
     */
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest req) {
        String songListId = req.getParameter("songListId");
        return listSongService.listSongOfSongId(Integer.parseInt(songListId));
    }

    /**
     * 删除歌单里的歌曲
     */
    @RequestMapping(value = "/ListSong/delete", method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest req){
        String songId = req.getParameter("songId");
        return listSongService.deleteListSong(Integer.parseInt(songId));
    }

    /**
     * 给歌单添加歌曲
     */
    @RequestMapping(value = "/ListSong/add", method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();

        ListSong listsong = new ListSong();
        listsong.setSongId(Integer.parseInt(song_id));
        listsong.setSongListId(Integer.parseInt(song_list_id));

        boolean res = listSongService.addListSong(listsong);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "添加成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
            return jsonObject;
        }
    }

    /**
    * 更新歌单里面的歌曲信息
    */
    @RequestMapping(value = "/listSong/update", method = RequestMethod.POST)
    public Object updateListSongMsg(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();

        ListSong listsong = new ListSong();
        listsong.setId(Integer.parseInt(id));
        listsong.setSongId(Integer.parseInt(song_id));
        listsong.setSongListId(Integer.parseInt(song_list_id));

        boolean res = listSongService.updateListSongMsg(listsong);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }
    }

}

