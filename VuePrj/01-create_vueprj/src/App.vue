<template>
  <el-container>
    <el-header>
      <!--   右边   -->
      <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
        点我打开
      </el-button>

      <el-drawer
        title="我是标题"
        :visible.sync="drawer"
        :with-header="false">
        <span> <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '3']">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>导航一</template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-menu"></i>导航二</template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="2-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-setting"></i>导航三</template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="3-1">选项1</el-menu-item>
            <el-menu-item index="3-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="3-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="3-4">
            <template slot="title">选项4</template>
            <el-menu-item index="3-4-1">选项4-1</el-menu-item>
          </el-submenu>
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
        <span>王小虎</span>
      </el-header>

      <el-main>
        <el-table :data="tableData">
          <el-table-column prop="date" label="日期" width="140">
          </el-table-column>
          <el-table-column prop="name" label="姓名" width="120">
          </el-table-column>
          <el-table-column prop="address" label="地址">
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </el-container></span>
      </el-drawer>
    </el-header>
    <el-container>

      <!-- 左边     -->
      <el-aside width="200px">
        <el-row class="tac">
          <el-col :span="12">
            <h5>
              <router-link to="/">作品</router-link>
            </h5>
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>我的</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">个人信息</el-menu-item>
                  <el-menu-item index="1-2">我的作品</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">笔记</span>
              </el-menu-item>
              <el-menu-item index="3">
                <i class="el-icon-document"></i>
                <span slot="title">
                    <router-link to="/article">发布</router-link>
                </span>
              </el-menu-item>
              <el-menu-item index="4">
                <i class="el-icon-document"></i>
                <span slot="title">专栏</span>
              </el-menu-item>
              <el-menu-item index="5">
                <i class="el-icon-setting"></i>
                <span slot="title">设置</span>
              </el-menu-item>
              <el-menu-item index="6">
                <i class="el-icon-setting"></i>
                <span slot="title">
                  <router-link to="/login">登录</router-link>
                </span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>

      <!-- 中间内容 -->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
    <el-container>
      <el-aside width="200px">
        <el-row class="tac">
          <el-col :span="12">
            <h5>
              <router-link to="/">后台</router-link>
            </h5>
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>查看</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">今日访问</el-menu-item>
                  <el-menu-item index="1-2">统计留言</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">图表
                </span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
    </el-container>

  </el-container>

</template>

<script>
export default {
  name: 'App',
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  data() {
    return {
      drawer: false,
    };
  }
}
</script>

<style>

</style>
