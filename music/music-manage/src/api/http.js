
//工具类

import axios from 'axios';
axios.defaults.timeout = 5000;  //设置超时时间是5秒
axios.defaults.withCredentials = true; //true允许跨域
//Content-Type响应头
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
//基础URL
axios.defaults.baseURL = "http://localhost:8888"

//统一响应拦截器
axios.interceptors.response.use(
    response => {
        //如果response里面的status是200，说明访问到接口了，可以正常拿到数据
        // 否则的话抛出错误
        if(response.status == 200){
            return Promise.resolve(response);
        } else{
            return Promise.reject(response);
        }
    },
    // 服务器状态码不是2开头的的情况
    error => {
        if(error.response.status){
            switch(error.response.status){
                //未登录
                case 401:   
                    router.replace({    //重定向
                        path:'/',        //根目录
                        query:{
                            redirect: router.currentRoute.fullPath
                        }
                    });
                    break;

                case 403:
                    console.log('管理员权限已修改，请重新登录')
                    // 跳转登录页面，并将要浏览的页面fullPath传过去，登录成功后跳转需要访问的页面
                    setTimeout(() => {
                        router.replace({
                            path:'/',
                            query: {
                                redirect: router.currentRoute.fullPath
                            }
                        });
                    }, 1000);
                    break;

                //404没找到
                case 404:  
                    console.log('请求页面飞到火星去了') 
                    break;
            }
            return Promise.reject(error.response);
        }
    }
);

/**
 * 封装get方法
 */
export function get(url, params= {}){
    return new Promise((resolve, reject) => {        //Promise是异步访问
        axios.get(url, {params : params})
            .then(response =>{
                resolve(response.data);
            })
            .catch(err =>{
                reject(err);
            })
    });
}


/**
 * 封装post方法
 */
 export function post(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.post(url, data)
            .then(response =>{
                resolve(response.data);
            })
            .catch(err =>{
                reject(err);
            })
    });
}

/**
 * 封装put请求
 */
export function put(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.put(url, data)
            .then(response => {
                resolve(response.data)
            }, err => {
                reject(err)
            })
    })
}

/**
 * 封装delete请求
 */
 export function deletes(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios.delete(url, data)
            .then(response => {
                resolve(response.data)
            }, err => {
                reject(err)
            })
    })
}