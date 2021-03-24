<template>
  <router-view/>
</template>

<script>
import Vue from 'vue';

export default {
  data() {
    return {
      nameValidateForm:
        {
          name: '',
          password: '',
          ipp: 'http://192.168.101.55/',
        },
      radio: false
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('Name:' + this.nameValidateForm.name + ';Password:' + this.nameValidateForm.password);
            alert(this.nameValidateForm.ipp + this.nameValidateForm.name);
            $router.push("/bacbook")

            // console.log(this.nameValidateForm.name);
          } else {
            console.log('error submit!!');
            return false;
          }
        }
      );
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style>
.el-radio-group {
  display: flex;
  margin: 20px;
  /* 边缘 */
  justify-content: center;

}

.el-card {
  border-radius: 30px;
  width: 380px;
  /* box-shadow: 0 2px 12px 0 rgb(243, 102, 102); */
  /* box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); */
}

.grid-content {
  /* background: rgb(14, 214, 131); */
  border-radius: 4px;
  min-height: 80px;
}

.el-row {
  margin-bottom: 20px;
}

/* .el-input{
width: 250px;
} */
.el-form-item {
  width: 300px;
}

</style>
