<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router :default-openeds="['0', '1']">
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''"  >
          <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
          <el-menu-item :class="$route.path === item2.path ? 'is-active' : ''" v-for="(item2,index2) in item.children" :index="item2.path"
            v-if="item2.show">
            {{item2.name}}
          </el-menu-item>
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
