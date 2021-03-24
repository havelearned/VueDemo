# Vue简介

Vue (读音 /vjuː/，类似于 view) 是一套用于构建[用户界面](https://baike.baidu.com/item/用户界面/6582461)的渐进式[JavaScript](https://baike.baidu.com/item/JavaScript/321142)框架。与其它大型[框架](https://baike.baidu.com/item/框架/1212667)不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库**只关注视图层**，方便与第三方库或既有项目整合。 

视图层：html css js 

渐进式是就是逐步更新实现新特性的意思

基于Angular的优点**模块化**和React的优点 **虚拟DOM**

但是Vue不支持通信，需要额外使用通信框架与服务器交互

Vue的特色就是：计算属性



## 关注点分离原则

1. 关注点分离原则，也叫正交原则，HTML CSS JS 分离 互不影响
2. 状态转移：js不去修改css 的样式（.style.color='red'），只修改css中的状态（addClass('active')）。

## Vue入门-01

下面是Vue的在线[cnd](https://baike.baidu.com/item/CDN/420951)

<script crossorigin="anonymous" integrity="sha512-eQ0ta/ODTFDM2vfYF86kMJhuHENG7y0vDsK9ub+X7PHan0CC2ozg7jXVFDYtAgCJZpyzFlaDyYKmus6k5+dC1g==" src="https://lib.baomitu.com/vue/3.0.5/vue.cjs.min.js"></script>

min.js是压缩版的 只有一行代码，运行效率较快



## 指令

带有v开头的在vue.js中称之为《指令》

- xmlns:v-bind="http://www.w3.org/1999/xhtml"

  v-bind 是vue.js 中的指令 给某一元素绑定一些特殊的行为

- v-if 条件判断

  ```html
  <body>
  
  <div id="app">
      <h1 v-if="ok">yes</h1>
      <h1 v-else>No</h1>
  
      <hr>
  
      <h2 v-if="type=='1'"> 我是A</h2>
      <h2 v-else-if="type=='2'"> 我是B</h2>
      <h2 v-else-if="type=='3'"> 我是C</h2>
      <h2 v-else-if="type=='4'"> 我是D</h2>
      <h2 v-else>我啥都不是</h2>
  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script>
      let vue = new Vue({
         el:"#app",
         data: {
             ok: true,
             type:"A"
         }
      });
  </script>
  
  
  </body>
  ```

  过于简单

  

- v-for 循环

```html
<body>


<div id="app">
    <li v-for="(itme,index) in itmes">{{itme.faset}}{{index}}

        <ul>
            {{itme.faset}}{{index}}
            <ul>
                {{itme.faset}}{{index}}
            </ul>
        </ul>
    </li>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    let vue = new Vue({
        el:"#app",
        data:{
            itmes: [
                {faset:'第一条数据'},
                {faset:'第二条数据'},
                {faset:'第三条数据'}
            ]
        }
    });
</script>

</body>
```

index是索引。只要不在父元素外都能用上itme



## 事件

需要命名空间：xmlns:v-on="http://www.w3.org/1999/xhtml"

```html
<body>

<div id="app">
    <button v-on:click="tow">{{message}}</button>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    var vue =new Vue({
        el: "#app",
        data:{
            message: "测试数据"
        },
        methods: {
            tow:function(){
                alert("测试数据");
            }
        }
    });
</script>
</body>
```

**将方法写在methods中**

v-on:事件="方法名"

vue中的事件和jquery中的差不多



## 双向绑定

即当视图方法改变时，数据也发生改变。当数据发生改变时，视图也发生改变。

使用指令 **on-model**

```html
<body>

<div id="app">
     请求输入文本:<input type="text" v-model="message" /> {{message}}<br>
    <textarea v-model="message"></textarea>{{message}} <br>

    性别 ：<input type="radio" name="sex" value="男"  v-model="message"/>男
            <input type="radio" name="sex" value="女" v-model="message"/>女
    <br><p>{{message}}</p>

    下拉款:<select v-model="message" >
            <option value="" disabled>请选择</option><!--如果没有第一个选项就用这种方式-->
            <option>a</option>
            <option>b</option>
            <option>c</option>
        </select>
    <span>value:{{message}}</span>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    var vue =new Vue({
        el: "#app",
        data:{
            message: ""
        }
    });
</script>
</body>

```



## 自定义组件

自定义组件就是可定制化的标签 ，像div span p 标签一样 自定一 一个mydiv 效果如下

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<div id="app">

<mydiv></mydiv>
     给组件传值
    <br>

    <!--先是循环 遍历 itmes 赋值给 itme itme 绑定给values values 是props中的变量可以给自定义标签传值-->
    <mydiv2 v-for=" itme in itmes" v-bind:values="itme"></mydiv2>


</div>


<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
<script>

    Vue.component("mydiv",{
        template:'<li>自定义组件\n' +
            '\n' +
            '        <ul>1\n' +
            '\n' +
            '            <ul>2</ul>\n' +
            '        </ul>\n' +
            '    </li>'

    });

    Vue.component("mydiv2",{
        props:["values"],
        template:'<li>{{values}}</li>'

    });


    var vue =new Vue({
        el: "#app",
        data:{
            itmes:['java','c++','c','c#'],
            message: "自定组件li标签",
            message2: "自定组件ui标签"
        }
    });
</script>
</body>
</html>
```



## 网络通信Axios

Axios是一个开源的可以用在浏览器和NodeJs的的异步框架，

她的主要作用就是实现Ajax异步通信

**优点：**

- 支持链式编程

- 取消请求
- 自动转换json数据
- 从node.js 创建http请求
- 客户端支持防御XSRF（跨站请求伪造）
- 拦截请求和响应



使用：

```html
<body>
<div id="app2">
    <h1>{{info.movieList}}</h1>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>

    var data =new  Vue({
        el: '#app2',
        data() {
            return {
                //定义的变量
               info:{
                   chiefBonus:null,
                   coming:null,
                   movieIds:null,
                   stid:null,
                   stids:null
               }
            }
        },
        mounted() { //在这个生命周期使用 axios 异步请求
            		//请求地址							对response操作返回 json数据
            axios.get("data.json").then(response => (this.info= response.data))
        }
    });

</script>

</body>
```



## 计算属性

Vue重要属性之一 ：computed 

计算属功能是，把返回的值缓存起来，调用属性那么去调用它

不需要加上（）就可以使用

````html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="app">
    <h1>methods方法 ：{{computed1()}}</h1>
    <h1>methods方法 ：{{computed2}}</h1>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
    var vue =new Vue({
        el: "#app",
        data: {
            message: "测试"
        },
        methods:{
            computed1: function(){
                return Date.now();//返回系统时间
            }
        },
        computed: {
            computed2: function(){
                return Date.now();
            }
        }
    });
</script>

</body>
</html>
````

## 插槽(动态拔插)

预定好元素位置 方便后来者修改:

列如:过年,过节 需要在某一块区域修改对应的节日气氛, 使用 插槽替换即可

- 插槽是一个标签 <slot></slot>

```js
//动态拔插,组件
Vue.compent('todo',{
    template: '<div>\
                    <slot></slot>\
                    <ul>\
                        <slot></slot>\
                    <ul>\
				</div>'
})

//再多两个组件
Vue.compent('todo-title',{
  template:'<div>标题</div>'  
})
Vue.compent('todo-items',{
    template:'<div>java</div>'
})

```



- 组件之间的使用就向是 html的标签一样使用

```html
<body>
    <todo> <!--动态热拔插,这个插槽有两个-->
    	<todo-title slot='todo-title'> <!--定义好的组件-->
        	<todo-tiems slot='todo-items'>
            </todo-tiems>
        </todo-title>
    </todo>
</body>
```



- 将todo-items中的内容变成动态的

  ```js
  Vue.compent('todo-title',{
      props:['title']
    template:'<div>{{title}}</div>'  
  })
  
  Vue.compent('todo-items',{
      props:['item']
      template:'<div>{{item}}</div>'
  })
  
  Vue.compent('todo',{
    template: '<div>\
                      <slot name='todo-title'></slot>\
                    <ul>\
                          <slot  name='todo-items'></slot>\
                      <ul>\
  				</div>'
  })
  
  ```

  props 属性 为改组件添加 绑定

    ```html
    <body>
        <todo> <!--动态热拔插,这个插槽有两个-->
            <todo-title slot='todo-title' :title> <!--定义好的组件-->
                <todo-tiems slot='todo-items' :items	>
                </todo-tiems>
            </todo-title>
        </todo>
    </body>
    ```

 

骚操作

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="app">

    <todo>
        <tod_title slot="tod_title" :title="message"></tod_title>
        <tod_body slot="tod_body" v-for="(time,index) in times" :body="time"
                  v-bind:index="index" v-on:remove="removeItem(index)"></tod_body>
    </todo>
</div>


<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>

    Vue.component('todo', {
        template: '<div>\
                        <slot name="tod_title"> </slot>\
                        <ul>\
                            <slot name="tod_body" > </slot>\
                        </ul>\
                </div>'
    });

    Vue.component('tod_title', {
        props:['title'],
        template: '<div>{{title}}</div>'
    });

    Vue.component('tod_body', {
        props:['body','index'],
        template: '<li>{{index}}-----{{body}} <button @click="removeItem">删除</button></li>',
        methods:{
            removeItem:function(index){
                this.$emit('remove',index)
            }
        }
    });


    var vue = new Vue({
        el: "#app",
        data: {
            message: "测试",
            message2: "java",
            times:[1,2,3,4,5,6,7,8]
        },
        methods:{
            removeItem:function(index){
                console.log("删除了--"+this.times[index])
                this.times.splice(index,1)//删除索引处元素
            }
        }
    });
</script>
</body>
</html>
```



## Vue的生命周期

Vue有拟人化的生命周期:

> 1. 开始创建
> 2. 初始化数据
> 3. 编译模板
> 4. 挂载DOM
> 5. 渲染
> 6. 更新
> 7. 卸载



阶段一  : craete Vue

![img](https://upload-images.jianshu.io/upload_images/11370083-f279314aef6741db.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1080)









vue的销毁并不是真正意义上的销毁,销毁之后还可以调用模板里的方法和属性,但是修改属性是无法生效的.

这样带来的好处是,处理一些定时任务 事件间隔定时器setInterval,如果类似这样的定时器再dom中有非常多的存在,运行负荷. vue的销毁就可以销毁这些

​	

# Vue-Cli 脚手架







![image-20210314094421490](/image-20210314094421490.png)





```bash
#检查是否安装 node 和 npm
node -v
node -v

#安装vue 依赖
cnpm install vue

#安装全局 的Vue 客户端
cnpm install --global vue-cli
#创建一个基于webpack模板的新项目, yes ,no要手动安装一些其他依赖

#vue init webpack '项目名' #在当项目下另外创建一个目录创建vue项目
vue init webpack -y #在当前的项目中创建

? Generate project in current directory? Yes  #如果是no 那么取消创建
? Project name 01-create_vueprj # 当前目录下创建一个名为 01-create_vueprj的目录
? Project description A Vue.js project #对正在创建项目的叙述
? Author 十里坡 <47898108+havelearned@users.noreply.github.com> #个人github地址
? Vue build standalone 
? Install vue-router? Yes #是否安装路由
? Use ESLint to lint your code? Yes #使用ESLint(严格代码检查)
? Pick an ESLint preset Standard
? Set up unit tests Yes #是否需要设置单元
? Pick a test runner jest
? Setup e2e tests with Nightwatch? Yes
? Should we run `npm install` for you after the project has been created? (recommended) npm


#安装scass和less
cnpm install --save sass-loader node-sass
cnpm install --save less-loader node-less


#进入目录
cd my_web

#安装依赖
npm install


#运行开发环境
npm run dev
  
  

```



这是成功的样子访问:http://localhost:8080 

```bash
 DONE  Compiled successfully in 3017ms                                                                      下午10:17:08

 I  Your application is running here: http://localhost:8080
```







添加Element-UI

```bash
cnpm i element-ui -S
```



想要使用Element的组件需要 导入sass   才能正常使用

```bash
npm install sass-loader@7.3.1 --save-dev
```



在main.js中添加

```js
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App) // Element,ES6语法 箭头函数
})

```





> Vue项目中的目录
>
> - build 
>
>   - build.js
>   - webpack.dev.conf.js
>   - webpack.prod.conf.js
>
>   .....
>
>   一些第三方的配置文件,像是webpack打包工具配置文件
>
> - config
>
>   - dev.env.js
>
>   ...
>
>   运行环境,开发环境配置
>
> - node_modules (不解释)
>
> - src
>
>   开发资源文件,main.js和App.vue 是重要文件
>
> - static
>
>   静态资源,和springBoot的文件结构类似
>
> - test
>
>   ​	测试用



> **关于路由router**
>
> 常规的在router目录下新建index 文件
>
> 导入**import Vue from 'vue'** ,**import Router from 'vue-router'**
>
> ```js
> import Vue from 'vue'
> import Router from 'vue-router'
> import Index from '../views/Index'
> 
> 
> Vue.use(Router)
> 
> export default new Router({
>   routes: [
>     {
>       path: '/',
>       name: 'Index',
>       component: Index,
>       children: [
>         {path: '/user/profile',name: Profile,  component: Profile},
>         {path: '/user/userList',name: UserList,  component: UserList},
>     }
>   ]
> })
> 
> ```
>
> Vue.use(Router) 使用模块
>
> 8-19 就是在配置路由了(路径),与springMVC 的RequestMapping相识,路由就是干这个的
>
> #### 在src目录下的main.js
>
> 导入 路由和一些其他模块
>
> ```js
> import Vue from 'vue'
> import App from './App'
> import router from './router'
> import ElementUI from 'element-ui'
> import 'element-ui/lib/theme-chalk/index.css'
> 
> Vue.config.productionTip = false
> 
> Vue.use(ElementUI)
> 
> /* eslint-disable no-new */
> new Vue({
>   el: '#app',
>   router,
>   components: { App },
>   template: '<App/>',
>   render: h => h(App) // Element,ES6语法 箭头函数
> })
> 
> ```
>





# Vue+Element-ui

## 简单导入

导入Element-ui 官网地址:https://element.eleme.cn/#/zh-CN/component/installation

```bash
npm i element-ui -S
或者
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
```



main.js中加入:

```js
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Element) //使用element

new Vue({
  router,
  store,
    
  render: h => h(App) //导入element
    
}).$mount('#app')
```





## Container布局容器

用于布局的容器组件，方便快速搭建页面的基本结构：

`<el-container>`：外层容器。当子元素中包含 `<el-header>` 或 `<el-footer>` 时，全部子元素会垂直上下排列，否则会水平左右排列。

`<el-header>`：顶栏容器。

`<el-aside>`：侧边栏容器。

`<el-main>`：主要区域容器。

`<el-footer>`：底栏容器。

其他必要元素:  实心黑点代表<标签></标签> && 空虚黑点代表属性  属性="值"

- <el-menu>:构建内容标签,常用的属性:

  - :default-openeds:默认展开的菜单,通过菜单的index值来关联

    列如:<el-menu :default-openeds="['1','2', '3']" > 类似于,其中['1' ....]就是默认展开123这样的ui标签列表

    

  - :default-active:默认选中的菜单,通过菜单的index值来关联的

    列如:<el-menu :default-openeds="['1','2', '3']" :default-active="'1-3'">

    类似于默认高亮第一个li标签下的第3个元素

- <el-submenu index=x>:可展开的菜单,常用属性:  二级菜单下,可在套这个标签变成三级菜单,它和<template>配套使用

  index:菜单的下标,参数时文本类型,不是数字类型

  

- template:对应el-submenu的菜单名.

- i:设置菜单的图片,通过class修改图标

  <i class="el-icon-message"> 

  <i class="el-icon-menu"> 

  <i class="el-icon-setting"> 

  ......

  

- el-menu-item: 菜单的子节点,不可再展开,常用属性
  
  - index="下标" :被选中时高亮,但是下标是唯一的,如果有相同的下标那么一起高亮



## 动态导航

- router文件

  router目录下index.js文件负责注册一些路由,路由就是页面的跳转,需要在该文件下导入vue模板文件

  导入有两种方式:

  - import 自定义名称 from 'vue模板文件路径.vue'  //.vue可以省略不写

  - ```js
    const routes = [
       
                {
                    path: '/pageOne',
                    name: 'PageOne',
                    component: () => import('../views/xxx.vue')  //这是es6的新语法导入方式
                },
    ```

- App.Vue 是整个网页的展示页面,它的模板建议只有

  ```
  <template>
    <router-view></router-view>
  </template>
  ```

  首页的就需要新建一个index.vue或者main.vue

  这里创建一个index.vue文件

  ```js
  <template>
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router>
          <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" >
            <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
            <el-menu-item v-for="(item2,index2) in item.children"  :index="item2.path">{{item2.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>xxxx</span>
        </el-header>
  
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </template>
  
  ```

  > 其中 :  demo_code1
  >
  > ```js
  > <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
  >       <el-menu router>
  >         <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" >
  >           <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
  >           <el-menu-item v-for="(item2,index2) in item.children"  :index="item2.path">{{item2.name}}</el-menu-item>
  >         </el-submenu>
  >       </el-menu>
  > </el-aside>
  > ```
  >
  > <el-aside> **是左侧栏,一般开发使用这样的容器作为后台开发**
  >
  > <el-menu router> 是左侧栏的菜单选项卡, router表示 需要路由接入管理(个人理解)
  >
  > <el-submenu> **一级菜单或者嵌套成二级 三级.....,配合 <template>使用,** 
  >
  > ​		其中 $router.options.routes 获取的是 router文件下的数组 routes对象 如下:
  >
  > ```js
  > const routes = [
  >     {	path: '/',
  >         name: '导航一',
  >         component: Index,
  >         children: [{
  >                 path: '/pageOne',
  >                 name: 'PageOne',
  >                 component: () => import(/* webpackChunkName: "about" */ '../views/PageOne.vue')},{
  >                 path: '/pageTwo',
  >                 name: 'PageTwo',
  >                 component: () => import(/* webpackChunkName: "about" */ '../views/PageTwo.vue')}]},
  >     ......]//为了方便阅读代码格式省略一些,继续
  > 
  > ```
  >
  > ​	 <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" >就是在遍历 routes这个数组对象
  >
  > ​		**v-for="(item,index)** index就是 当前的下标, 
  >
  > ​	 :index="index"	  绑定index(下标)使得页面元素被选中后可以展示它的下一级菜单
  >
  > 
  >
  > ​	<el-menu-item v-for="(item2,index2) in item.children"  :index="item2.path">{{item2.name}}</el-menu-item>
  >
  >  **v-for="(item2,index2) in item.children":**这个再遍历 routes里面还有一个数组:children,其实就是一个二维数组,当然childen里面还能套多个数组
  >
  >  **:index="item2.path"**  index 绑定的是 children数组下的path属性,path属性可以跳转到/pageOne页面
  >
  > **{{item2.name}}** : children数组下的name属性

  

### 可添加的细节

访问默认页面

router文件下的index.js,routes对象数组下可添加 redirect属性

```js
path: '/',
name: '导航一',
component: Index,
redirect:'/pageOne', //当访问 / 路径, 跳转到 /pageOne路径
```



页面地址栏输入动态选中并且默认展示 导航 一或二:

```js
 <el-menu router :default-openeds="['0', '1']"> //默认展开 0  到 1的导航列表
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" >
          <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
          <el-menu-item :class="$route.path === item2.path ? 'is-active' : ''" v-for="(item2,index2) in item.children" :index="item2.path">{{item2.name}}</el-menu-item>
        </el-submenu>
      </el-menu>
```



<el-menu router :default-openeds="['0', '1']">  :默认展开 0  到 1的导航列表

**:class="$route.path === item2.path ? 'is-active' : ''"**  更具浏览器地址栏 路径判断 是否等于 children数组中 path属性值,如果等于 那么个添加class='is-active' 	样式



完整代码

```js
<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router :default-openeds="['0', '1']">
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" >
          <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
          <el-menu-item :class="$route.path === item2.path ? 'is-active' : ''" v-for="(item2,index2) in item.children" :index="item2.path">{{item2.name}}</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>xxxx</span>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: "index"
}
</script>

<style scoped>

</style>

```



router/index.js

```js
import Vue from 'vue'
import VueRouter from 'vue-router'
import app from '../App'
import Index from '../views/index'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '导航一',
        component: Index,
        redirect:'/pageOne',
        children: [
            {
                path: '/pageOne',
                name: 'PageOne',
                component: () => import(/* webpackChunkName: "about" */ '../views/PageOne.vue')
            }, {
                path: '/pageTwo',
                name: 'PageTwo',
                component: () => import(/* webpackChunkName: "about" */ '../views/PageTwo.vue')
            }
        ]
    }, {
        path: '/navigation',
        name: '导航二',
        component: Index,
        children: [
            {
                path: '/pageThress',
                name: 'PageThress',
                component: () => import(/* webpackChunkName: "about" */ '../views/PageThress.vue')
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

```



### axios异步网络请求:

```js
axios.get('url').then(function(resp){  //链式编程 then的回调函数,里面就是响应回来的数据
	this.xxx = resp.data // resp参数携带了 responseBody 数据,返回了后台数据
    
})
```



:Model 双向绑定

```js
 <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
     </el-from>
```

:model="对象名称"  ,双向绑定 :movdel绑定的是对象

ref="ruleForm"  给对象一个名字,常用于点击事件时放入这个参数

## Element-ui校验规则

```js
 <el-form-item label="上映日期" prop="name">
      <el-input v-model="ruleForm.mScreen"></el-input>
    </el-form-item>

    <el-form-item label="电影简介" prop="name">
      <el-input v-model="ruleForm.desc"></el-input>
    </el-form-item>
......

rules: {	
    name: [
        { required: true, message: '请输入活动名称', trigger: 'blur' },
        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
        region: [
            { required: true, message: '请选择活动区域', trigger: 'change' }
        ],
       ......
```

v-movdel='对象名称.属性' ,绑定绑定对象的属性

**:rules 绑定数据校验数据**

:rules = '对象名称' 根据给的对象校验内容

```text
required: true | false #必填的或 可不填
message: 暗示提示
trigger: 什么事件下触发校验,

min :最小长度
max: 最大长度
message:不符合条件时弹出的消息
trigger: 不符合是触发的事件
```

一个属性可以绑定多个校验规则

根据prop 属性 给的值 判断对应位置校验内容



```js
  methods: {
    test(){
      console.log(this.ruleForm)
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('提交成功!');
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
```

submitForm() 方法 就是最终校验成功后获取到用户输入数据,

这时候就需要把数据传给后台

## 添加数据

```js
axios.post('').then(function(resp){
    
})
//使用箭头函数
axios.post('').then(resp =>{
    
})

 //传递对象参数时,不需要使用 + 拼接参数使用 , 传递一个对象即可
axios.post('http://localhost:9999/api/movies/save',_this.ruleForm).then(resp =>{
    if(resp.data === 'success')
        //alert('添加成功');
        this.open1()
    //跳转回到 电影管理界面(AddMovies.vue)
    _this.$router.push('/pageOne')
})     
```



## 修改数据

```js
<template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">删除</el-button>
          <el-button type="text" size="small">修改</el-button>
        </template>
```

edis(scope.row) 方法传递了参数 scope.row ,是当前行的数据

到具体的edis方法中可以获取到 当前行的数据:

```js
 methods: {
    edit(row) {
	this.$router.push('/update')
      console.log(row.mid);
    },
     ......
```

$router.push是可以携带参数的:

```js
this.$router.push({
    path:'/update',
    query:{
	    mid: row.mid
    }
    
})
```

/udpate 来到修改页面,推荐在Vue的声明周期初始化方法下获取 router传递过来的参数

```js
createed(){
    this.$ruote.query.id
        axios.get('xxxx/'+    this.$ruote.query.id).then((resp) => {
        console.log(resp.data)
    })
}
```

`1` 使用readonly 可以设置值不可修改

`2` 修改的方式和添加类似





## 删除数据



```js
<template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button type="text" size="small">删除</el-button>
        </template>
```

删除按钮添加事件 传入scope.row ,就是当前行数据

在事件方法直接发送axios.delete请求 根据id删除数据即可



`1`window.loading.reload();//重新刷新页面

`2` router/index routesd对象 添加 show:true |false 是可以在遍历这个对象时选择是否遍历的





# 关于SpringBoot后台接口

![image-20210324105801195](\image-20210324105801195.png)







config/CorsConfig.java

```java
package com.yinghua.vuespringboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决跨域问题:
 * 8080 访问 9998 这是一个跨域操作
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);  //sessionid 多次访问一致

        // 允许访问的客户端域名
        List<String> allowedOriginPatterns = new ArrayList<>();
        allowedOriginPatterns.add("*");
        corsConfiguration.setAllowedOriginPatterns(allowedOriginPatterns);
//        corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 允许任何头
        corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration()); // 对接口配置跨域设置
        return new CorsFilter(source);
    }


}

```



pojo/DMovies.java

```java
package com.yinghua.vuespringboot.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity //严格对应数据库中的表名称
@Data //set get
@Table(name = "d_movies")
public class DMovies {
    @Id //指定id
    @Column(name = "M_ID")//指定列名
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;

    @Column(name = "M_movie_name")
    private String mMovieName;

    @Column(name = "M_director")
    private String mDirector;

    @Column(name = "M_protagonist")
    private String mProtagonist;

    @Column(name = "M_support")
    private String mSupport;

    @Column(name = "M_screen")
    private String mScreen;

    @Column(name = "M_desc")
    private String mDesc;
}

```



接口

```java
package com.yinghua.vuespringboot.reponsitory;

import com.yinghua.vuespringboot.pojo.DMovies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DMoviesRepository extends JpaRepository<DMovies,Integer> {

}

```























