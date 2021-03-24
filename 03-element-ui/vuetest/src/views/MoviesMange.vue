<template>
  <div>
    <el-table
        :data="movies"
        border
        style="width: 60%">
      <el-table-column
          fixed
          prop="mId"
          label="电影id"
          width="150">
      </el-table-column>
      <el-table-column
          prop="mMovieName"
          label="电影名称"
          width="120">
      </el-table-column>
      <el-table-column
          prop="mDirector"
          label="导演"
          width="120">
      </el-table-column>
      <el-table-column
          prop="mProtagonist"
          label="主角"
          width="120">
      </el-table-column>
      <el-table-column
          prop="mScreen"
          label="上映时间"
          width="300">
      </el-table-column>
      <el-table-column
          prop="mSupport"
          label="配角"
          width="120">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click='del(scope.row)' type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        background
        layout="prev, pager, next"
        page-Size='5'
        :total="100"
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    edit(row) {
      this.$router.push({
        path:'/update',
        query:{
          mid:row.mid
        }
      })
      console.log(row.mid);
        //
    },
    del(row){
      row.mid
      axios.delete("http://localhost:9999/api/movies/delete/"+row.mid).then((resp)=>{
        if(resp.data == "success"){
          alert("删除成功")
          window.loading.reload();//重新刷新页面
        }else{
          alert("删除失败")
        }

      })
    },
    page(currentPage) {
      const _this = this
      axios.get("http://localhost:9999/api/movies/findAll/"+currentPage+"/5").then(resp => {
        console.log(resp.data)
        _this.movies = resp.data.content
        // _this.$set(_this,'movies',resp.data.content)
        _this.total = resp.data.totalElements
      })
    }
  },
  data() {
    return {
      total:null,
      movies:null,
    }
  },
  created() {//该方法页面被加载的时候自动调用
    const _this = this
    axios.get("http://localhost:9999/api/movies/findAll/1/5").then(resp => {
      console.log(resp.data)
      _this.movies = resp.data.content
      console.log(_this.movies)
      // _this.tableData = resp.data.content
      // _this.total = resp.data.totalElements
    })
  }
}
</script>
