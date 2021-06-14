import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'music-manage',
      component: resolve => require(['../pages/Login.vue'], resolve)
    },
    
    {
      path: '/Home',
      component: resolve => require(['../components/Home.vue'], resolve),
      children: [
        {
          path: '/Info',
          component: resolve => require(['../pages/InfoPage.vue'], resolve),
          // 匹配规则是否大小写敏感？(默认值：false)
          // caseSensitive: true,
          meta: { title: 'Info' }
        },
        {
          path: '/song',
          component: resolve => require(['../pages/SongPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'Song' }
        },
        {
          path: '/Singer',
          component: resolve => require(['../pages/SingerPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'Singer' }
        },
        {
          path: '/SongList',
          component: resolve => require(['../pages/SongListPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'SongList' }
        },
        {
          path: '/ListSong',
          component: resolve => require(['../pages/ListSongPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'ListSong' }
        },
        {
          path: '/Comment',
          component: resolve => require(['../pages/CommentPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'Comment' }
        },
        {
          path: '/Consumer',
          component: resolve => require(['../pages/ConsumerPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'Consumer' }
        },
        {
          path: '/Collect',
          component: resolve => require(['../pages/CollectPage.vue'], resolve),
          // caseSensitive: true,
          meta: { title: 'Collect' }
        }
      ]
    }
  ]
})
