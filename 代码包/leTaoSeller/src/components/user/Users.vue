<template>
    <div>
        <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">卖家信息管理</a></el-breadcrumb-item>

        </el-breadcrumb>

        <el-card class="box-card">
            <el-row gutter="20">

            <el-col :span="4" >
                <el-button type="primary" @click="editDialogVisible=true">编辑</el-button>
                </el-col>
                </el-row>

         <div class="text item">
         {{'昵称:  '+User.userNickname}}
         </div>
         <div class="text item">
                  {{'地址:  '+User.userAddress}}
         </div>
         <div class="text item">
                  {{'电话:  '+User.userTelephone}}
         </div>
         <div class="text item">
                  {{'余额:  ￥'+User.userAccount}}
         </div>

        </el-card>

        <el-dialog title="编辑信息" :visible.sync="editDialogVisible" width="50%" @close="addDialogClosed">
              <!-- 内容主体 -->
              <el-form
                :model="shop"
                ref="addShopFormRef"

                label-width="100px"
              >
                <el-form-item label="昵称" prop="name">
                  <el-input v-model="User.userNickname"></el-input>
                </el-form-item>

                <el-form-item label="电话" prop="tel">
                                  <el-input v-model="User.userTelephone"></el-input>
                                </el-form-item>

                <el-form-item label="地址" prop="add">
                                  <el-input v-model="User.userAddress"></el-input>
                                </el-form-item>

              </el-form>
              <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editUser(User.userId,User.userNickname,User.userAddress,User.userTelephone)">确 定</el-button>
              </span>
            </el-dialog>

   </div>
</template>
<script>
export default{
data(){
    return{
        queryInfo:{
                        code:'',
                        msg:'',
                        data:[]
                    },
        User:{
              userAccount: 0.0,
              userAddress: null,
              userId: 1,
              userNickname: "1",
              userPassword: "adminadmin",
              userPerference: null,
              userState: true,
              userTelephone: null,
              userType: 2,
              userUsername: "just",
        },
        editDialogVisible:false
    }
},
created(){
    this.getUser('just')
},
methods:{
    getGoodsList(){
          this.$refs.loginFormRef.validate(async valid=>{
              if(!valid)return;
        //       const { data: res } = await this.$http.post('http://localhost:8080/user/login', this.loginForm)
        // // console.log(res)
        // if (res.meta.status !== 1) return this.$message.error('登录失败')
        this.axios.get("http://localhost:8080/user/login",this.loginForm).then((response)=>{
            console.log(response)
        })
        // this.$message.success('登录成功')
        // window.sessionStorage.setItem('token', res.data.token)
        // 通过编程式导航跳转到后台主页, 路由地址为：/home
        // this.$router.push('/home')
          });
    },

    getUser(userName){
       this.axios.get("http://localhost:8080/user/showInformation?username="+userName,this.queryInfo).then((response)=>{
                        console.log(response)
                        this.User=response.data.data[0]
                        console.log(this.User)

       })
    },

    editUser(id,nick,add,tel){
        this.axios.get("http://localhost:8080/user/updateUser?userId="+id+"&nick="+nick+"&add="+add+"&tel="+tel,this.queryInfo).then((response)=>{
                            console.log(response)

               if(response.data.code==="0") {
                   this.$message.error('编辑失败')
                        }else{
                        this.$message.success('编辑成功')
                        // 隐藏添加店铺对话框
                        this.addDialogVisible = false
                        location.reload();
                        }

           })

    }





}
}
</script>
<style lang="less" scoped>

</style>
