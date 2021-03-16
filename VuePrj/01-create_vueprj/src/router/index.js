import Vue from 'vue'
import Router from 'vue-router'
import Index from '../views/Index'
import Login from '../views/Login'
import Article from '../Issue/Article'
import UserList from '../views/user/UserList'
import Profile from '../views/user/Profile'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children: [
        {path: '/user/profile',name: Profile,  component: Profile},
        {path: '/user/userList',name: UserList,  component: UserList},

      ]
    },
    {
      path: '/login',
      name: 'login',
      component: Login

    },
    {
      path: '/article',
      name: 'Article',
      component: Article
    }
  ]
})
