<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="width:60%">
    <el-form-item label="电影名称" prop="mMovieName">
      <el-input v-model="ruleForm.mMovieName" readonly></el-input>
    </el-form-item>

    <el-form-item label="导演" prop="mDirector">
      <el-input v-model="ruleForm.mDirector"></el-input>
    </el-form-item>

    <el-form-item label="主角" prop="mProtagonist">
      <el-input v-model="ruleForm.mProtagonist"></el-input>
    </el-form-item>

    <el-form-item label="配角" prop="mSupport">
      <el-input v-model="ruleForm.mSupport"></el-input>
    </el-form-item>

    <el-form-item label="上映日期" prop="mScreen">
      <el-input v-model="ruleForm.mScreen"></el-input>
    </el-form-item>

    <el-form-item label="电影简介" prop="desc">
      <el-input v-model="ruleForm.desc"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
      <el-button @click="test">testGetData</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "MovieUpdate",
  data() {
    return {
      ruleForm: {
        mMovieName: '',
        mDirector: '',
        mProtagonist: '',
        mSupport: '',
        mScreen: '',
        desc: ''
      },
      rules: {
        mMovieName: [
          {required: true, message: '请输入电影名称', trigger: 'blur'}
        ],
        mDirector: [
          {required: true, message: '请输入导演姓名', trigger: 'blur'}
        ],
        mProtagonist: [
          {required: true, message: '请输入主演姓名', trigger: 'blur'}
        ],
        mSupport: [
          {required: true, message: '请输入配角姓名', trigger: 'blur'}
        ],
        mScreen: [
          {required: true, message: '请输入上映时间', trigger: 'blur'}
        ],
        desc: [
          {required: true, message: '请输入电影简介', trigger: 'blur'}
        ],
      }
    };
  },
  methods: {
    test() {
      console.log(this.ruleForm)
    },
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //传递对象参数时,不需要使用 + 拼接参数使用 , 传递一个对象即可
          axios.put('http://localhost:9999/api/movies/update', this.ruleForm).then(resp => {
            if (resp.data === 'success')
                //alert('添加成功');
              this.open1()
            //跳转回到 电影管理界面(AddMovies.vue)
            _this.$router.push('/pageOne')
          })

        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    open1() {
      const h = this.$createElement;
      var str = "电影名称:" + this.ruleForm.mMovieName + "\n 电影导演:" + this.ruleForm.mDirector + "\n...."
      this.$notify({
        title: '修改成功',
        message: h('i', {style: 'color: teal'}, str)
      });
    }
  },
  created() {
    axios.get('http://localhost:9999/api/movies/findById/' + this.$route.query.mid).then((resp) => {
      console.log(resp.data)
      this.ruleForm.mMovieName = resp.data.mmovieName
      this.ruleForm.mDirector = resp.data.mdirector
      this.ruleForm.mProtagonist = resp.data.mprotagonist
      this.ruleForm.mSupport = resp.data.msupport
      this.ruleForm.mScreen = resp.data.mscreen
      this.ruleForm.desc = resp.data.mdesc
    })
  }
}
</script>

<style scoped>

</style>
