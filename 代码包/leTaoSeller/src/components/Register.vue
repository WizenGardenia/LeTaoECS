<template>
    <div class="register_container">
      <div class="register_box">
          <!-- img -->
      <div class="avatar_box">
      <img src="../assets/logo.png" alt="">
      </div>
      <!-- form-->
      <el-form ref="registerFormRef" :model="registerForm" :rules="registerFormRules" label-width="0px" class="register_form">

      <el-form-item prop="username">
      <el-input v-model="registerForm.username" prefix-icon="el-icon-user-solid" 
      ></el-input>
      </el-form-item>

      <el-form-item prop="password">
      <el-input v-model="registerForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
      </el-form-item>

      <el-form-item class="btns">
      <el-button type="info" @click="resetRegisterForm">重置</el-button>
      <el-button type="success" @click="register">注册</el-button>
      </el-form-item>

      </el-form>
      </div>
    </div>
</template>

<script>
    export default {
  data(){
      return{
          registerForm:{
              username:'admin',
              password:'123456',
              usertype:1,
              verification:1,
              randomVerification:1
          },
          registerFormRules:{
            username:[
            { required: true, message: '请输入登录名', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10个字符', trigger: 'blur' }],
            password:[ { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 10, message: '长度在 6 到 10个字符', trigger: 'blur' }]
          }
      }
  },
  methods:{
      resetRegisterForm(){
          this.$refs.registerFormRef.resetFields();
      },
      register(){
            console.log("执行了。。。。。");
          this.$refs.registerFormRef.validate(async valid=>{
              if(!valid)return;
        //       const { data: res } = await this.$http.post('http://localhost:8080/user/register', this.registerForm)
        // // console.log(res)
        // if (res.meta.status !== 1) return this.$message.error('登录失败')
        this.axios.post("http://localhost:8080/user/register2",{username:this.registerForm.username,password:this.registerForm.password,usertype:this.registerForm.usertype,verification:this.registerForm.verification,randomVerification:this.registerForm.randomVerification}).then((response)=>{
            console.log(response)
        })
        // this.$message.success('登录成功')
        // window.sessionStorage.setItem('token', res.data.token)
        // 通过编程式导航跳转到后台主页, 路由地址为：/home
        // this.$router.push('/home')
          });
      },
     

  }
}         
    
    
</script>

<style lang="less" scoped>
.register_container{
    height: 100%;
    background-color:#545454;
}
.register_box{
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;
    position:absolute;
    left:50%;
    top:50%;
    transform:translate(-50%,-50%) ;

    .avatar_box{
        height: 130px;
        width: 130px;
        border:1px solid #eee;
        border-radius:50% ;
        padding: 10px;
        box-shadow: 0 0 10px #ddd;
        position: absolute;
        left:50%;
        transform:translate(-50%,-50%);
        background-color: #fff;
        img{
            height: 100%;
            width: 100%;
            border-radius:50% ;
            background-color: antiquewhite;
        }
    }
}
.btns{
    display: flex;
    justify-content: flex-end;
}
.register_form{
    position:absolute;
    bottom: 0%;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
}
</style>