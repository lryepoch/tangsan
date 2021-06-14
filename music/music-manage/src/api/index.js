
//与业务相关的工具，这里引入http.js工具

import { get, post } from "./http";

//===================> 管理员API
//判断是否登录成功
export const getLoginStatus = (params) => post(`admin/login/status`, params);


//===================> 用户API
//返回所有用户
export const getAllUser = () => get(`user`)









//===================> 收藏列表API






//===================> 评论列表API





//===================> 歌手API






//===================> 歌曲API






//===================> 歌单API






//===================> 歌单歌曲API