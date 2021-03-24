<template>
  <div>
    <table>
      <tr>
        <td>id</td>
        <td>电影名称</td>
        <td>导演</td>
        <td>演员</td>
        <td>配角</td>
        <td>上映时间</td>
      </tr>
      <tr v-for="item in movies">
        <td>{{ item.mid }}</td>
        <td>{{ item.mmovieName }}</td>
        <td>{{ item.mdirector }}</td>
        <td>{{ item.mprotagonist }}</td>
        <td>{{ item.msupport }}</td>
        <td>{{ item.mscreen }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "Movies",

  data() { //这是一个方法
    return {
      msg: 'hello movies',
      movies: [{
        mid: '1',
        mdirector: '测试1',
        mmovieName: '测试2',
        mprotagonist: '测试3',
        mscreen: '测试4',
        msupport: '测试5'
      },
        {
          mid: '2',
          mdirector: '测试1',
          mmovieName: '测试2',
          mprotagonist: '测试3',
          mscreen: '测试4',
          msupport: '测试5'
        }

      ]
    }
  },
  created() { //初始化方法, Vue官方推荐的初始化 时调用的方法
    const _this = this
    axios.get("http://localhost:9999/api/movies/findAll").then(resp => {
      console.log(_this.movies)
      console.log(resp.headers)
      console.log( resp.request)
      console.log(  resp.status)
      console.log( resp.config)
      console.log( resp.statusText)
      console.log(resp.data)
      _this.movies = resp.data

    })
  }
}
</script>

<style scoped>

</style>
