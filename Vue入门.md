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









