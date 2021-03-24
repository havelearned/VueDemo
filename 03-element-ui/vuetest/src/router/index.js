import Vue from 'vue'
import VueRouter from 'vue-router'
import app from '../App'
import Index from '../views/index'

import JsonViewer from 'vue-json-viewer'

Vue.use(JsonViewer)
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '电影列表',
        component: Index,
        show:true,
        redirect:'/pageOne',
        children: [
            {
                path: '/pageOne',
                show:true,
                name: '电影管理',
                component: () => import('../views/MoviesMange.vue')
            }, {
                path: '/pageTwo',
                name: '添加电影',
                show:true,
                component: () => import( '../views/AddMovies.vue')
            },
            {
                path: '/update',
                show:false,
                component: () => import('../views/MovieUpdate.vue')
            }
        ]
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
