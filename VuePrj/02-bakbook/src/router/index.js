import Vue from 'vue'
import Router from 'vue-router'
import Main from '../views/Main'
import Bacbook from '../views/Bacbook'
import ElementUI from "_element-ui@2.15.1@element-ui";

Vue.use(Router)
Vue.use(ElementUI)

export default new Router({
  routes: [
    {
      path: '/main_index',
      name: 'Main',
      component: Main
    },
    {
      path: '/bacbook_text',
      name: 'Bacbook',
      component: Bacbook
    }
  ]
})
