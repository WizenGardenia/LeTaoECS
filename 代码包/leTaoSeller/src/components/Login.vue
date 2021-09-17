<template>
    <div class="login_container">
      <div class="login_box">
          <!-- img -->
      <div class="avatar_box">
      <img src="../assets/logo.png" alt="">
      </div>
      <!-- form-->
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="0px" class="login_form">

      <el-form-item prop="username">
      <el-input v-model="loginForm.username" prefix-icon="el-icon-user-solid" 
      ></el-input>
      </el-form-item>

      <el-form-item prop="password">
      <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
      </el-form-item>

      <el-form-item class="btns">
      <el-button type="primary" @click="login">登录</el-button>
      <el-button type="info" @click="resetLoginForm">重置</el-button>
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
          loginForm:{
              username:'admin',
              password:'123456',
              verification:1,
              randomVerification:1
          },
          loginFormRules:{
            username:[
            { required: true, message: '请输入登录名', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10个字符', trigger: 'blur' }],
            password:[ { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 10, message: '长度在 6 到 10个字符', trigger: 'blur' }]
          }
      }
  },
  methods:{
      resetLoginForm(){
          this.$refs.loginFormRef.resetFields();
      },
      login(){
           console.log("执行了。。。。。");
          this.$refs.loginFormRef.validate(async valid=>{
              if(!valid)return;
        //       const { data: res } = await this.$http.post('http://localhost:8080/user/login', this.loginForm)
        // // console.log(res)
        // 
        this.axios.post("http://localhost:8080/user/login2",this.loginForm).then((response)=>{
            console.log("-------------->"+response.data.code)
            if(response.data.code==="0") {
                this.$message.error('登录失败')
            }else{
                this.$message.success('登录成功')
                this.$router.push('/home')
            }
        
          });

            
        })
        
      },
      register(){
        this.$router.push('/register2')
      }

  }
}         
    
    
</script>

<style lang="less" scoped>
.login_container{
    height: 100%;
    background-color:rgb(32, 117, 167);
}
.login_box{
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
.login_form{
    position:absolute;
    bottom: 0%;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
}
</style>

