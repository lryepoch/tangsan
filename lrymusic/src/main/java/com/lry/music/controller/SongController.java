package com.lry.music.controller;

import com.lry.music.constant.Constant;
import com.lry.music.utils.ResultVOUtils;
import com.lry.music.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(Constant.prefixRequest + "song")
@Slf4j
public class SongController {

    /**
     * 音乐搜索
     */
    @GetMapping(value = "/search/song/key/{key}")
    public ResultVO searchMusic(@PathVariable("key") String key) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            String url = "https://c.y.qq.com/soso/fcgi-bin/search_for_qq_cp?_=1555419255194&g_tk=5381&uin=0&format=json&inCharset=utf-8&outCharset=utf-8&notice=0&platform=h5&needNewCode=1&w="+key+"&zhidaqu=1&catZhida=1&t=0&flag=1&ie=utf-8&sem=1&aggr=0&perpage=20&n=20&p=1&remoteplace=txt.mqq.all";
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Content-Type","application/jsonp");
            httpGet.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
            httpGet.setHeader("origin","http://c.y.qq.com");
            httpGet.setHeader("referer","https://c.y.qq.com/soso/fcgi-bin/search_for_qq_cp");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try{
                HttpEntity entity = response.getEntity();
                return ResultVOUtils.success(EntityUtils.toString(entity));
            } finally {
                response.close();
            }
        }finally {
            httpClient.close();
        }
    }
}
