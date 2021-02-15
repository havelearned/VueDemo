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