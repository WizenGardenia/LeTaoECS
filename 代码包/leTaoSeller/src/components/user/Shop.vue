<template>
    <div>
        <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">店铺</a></el-breadcrumb-item>

        </el-breadcrumb>

        <el-card class="box-card">
            <el-row gutter="20">

            <el-col :span="4">
                <el-button type="primary" @click="addDialogVisible=true">添加</el-button>
                </el-col>
                </el-row>
        <el-table
    :data="Shopslist"
    height="250"
    border
    stripe
    style="width: 100%">
    <el-table-column type="index"></el-table-column>
    <el-table-column
      prop="shopId"
      label="店铺id"
      width="180">
    </el-table-column>
    <el-table-column
      prop="shopName"
      label="店铺名"
      width="600">
    </el-table-column>

    <el-table-column
      label="操作" width="180px">
      <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="updateForm(scope.row.shopId,scope.row.shopName);editDialogVisible=true"></el-button>
          <el-button type="danger" icon="el-icon-share" size="mini" @click="updateForm(scope.row.shopId,scope.row.shopName);addGoodDialogVisible=true" ></el-button>
          <el-button type="warning" icon="el-icon-delete" size="mini" @click="delShop(scope.row.shopId)"></el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[1, 2, 3, 4]"
      :page-size="18"
      layout="total, sizes, prev, pager, next, jumper"
      :total="8">
    </el-pagination>  
        </el-card>



<el-dialog title="添加店铺" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
      <!-- 内容主体 -->
      <el-form
        :model="shop"
        ref="addShopFormRef"

        label-width="100px"
      >
        <el-form-item label="店铺名" prop="name">
          <el-input v-model="shop.name"></el-input>
        </el-form-item>

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addShop(shop.name)">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="编辑店铺" :visible.sync="editDialogVisible" width="50%" @close="addDialogClosed">
              <!-- 内容主体 -->
              <el-form
                :model="shop"
                ref="addShopFormRef"

                label-width="100px"
              >
                <el-form-item label="店铺名" prop="name">
                  <el-input v-model="editShopForm.shopName"></el-input>
                </el-form-item>

              </el-form>
              <span slot="footer" class="dialog-footer">
                <el-button @click="editDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editShop(editShopForm.shopID,editShopForm.shopName)">确 定</el-button>
              </span>
            </el-dialog>

    <el-dialog title="添加商品" :visible.sync="addGoodDialogVisible" width="50%" @close="addDialogClosed">
          <!-- 内容主体 -->
          <el-form
            :model="shop"
            ref="addShopFormRef"

            label-width="100px"
          >
            <el-form-item label="商品名" prop="name">
              <el-input v-model="cmdty.name"></el-input>
            </el-form-item>
            <el-form-item label="类型" prop="type">
                 <el-input v-model="cmdty.type"></el-input>
            </el-form-item>
            <el-form-item label="预览" prop="prev">
                 <el-input v-model="cmdty.prev"></el-input>
            </el-form-item>
            <el-form-item label="价格" prop="price">
                 <el-input v-model="cmdty.price"></el-input>
            </el-form-item>




          </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="addGoodDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="addCmdty(cmdty.name, editShopForm.shopID, cmdty.type, cmdty.prev, cmdty.price)">确 定</el-button>
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

            shop:{
                name:''

            },

            editShopForm:{
                 shopID:'',
                 shopName:''
            },

            cmdty:{
                name:'',
                type:'',
                price:'',
                prev:''

            },

            Shopslist:[],
            total:0,
            addDialogVisible:false,
            addGoodDialogVisible:false,
            editDialogVisible:false
        }
    },
    created(){
        this.getShopsList(1)
    },
    methods:{

        handleSizeChange(newSize){
            console.log(newSize)

        }  ,
        handleCurrentChange(newPage){

        } ,
        getShopsList(userid){
                this.axios.get("http://localhost:8080/shop/showShop?id="+userid,this.queryInfo).then((response)=>{
                    console.log(response)
                    this.Shopslist=response.data.data[0].model.myShop
                    this.total=response.data.total
                    console.log(this.Shopslist)
                })


        },
        delShop(shopId){
                this.axios.get("http://localhost:8080/shop/delShop?id="+shopId,this.queryInfo).then((response)=>{
                                    console.log(response)


                                    if(response.data.code==="0") {
                                                    this.$message.error('删除失败')
                                                }else{
                                                    this.$message.success('删除成功')
                                                    location.reload();
                                                }
                                })

        },
        addShop (name) {
                this.axios.get("http://localhost:8080/shop/createShop?userid=1&name="+name,this.queryInfo).then((response)=>{
                                                    console.log(response)


                                                    if(response.data.code==="0") {
                                                                    this.$message.error('添加失败')
                                                                }else{
                                                                    this.$message.success('添加成功')
                                                                    // 隐藏添加店铺对话框
                                                                    this.addDialogVisible = false
                                                                    location.reload();
                                                                }


              })
            },
        addCmdty(name, shopid, type, prev, price){
                this.axios.get("http://localhost:8080/cmdty/creatCmdty?name="+name+"&shopid="+shopid+"&type="+type+"&prev="+prev+"&details="+price,this.queryInfo).then((response)=>{
                                                            console.log(response)
                if(response.data.code==="0") {
                                this.$message.error('添加失败')
                           }else{
                           this.$message.success('添加成功')
                            // 隐藏添加商品对话框
                            this.addGoodDialogVisible = false
                           location.reload();
                           }
        })
        },

        updateForm(id, name){
             this.editShopForm.shopID=id
             this.editShopForm.shopName=name
             console.log(this.editShopForm)

        },

        editShop(id,name){
                this.axios.get("http://localhost:8080/shop/updateShop?shopId="+id+"&shopName="+name,this.queryInfo).then((response)=>{
                                    console.log(response)

                       if(response.data.code==="0") {
                           this.$message.error('编辑失败')
                                }else{
                                this.$message.success('编辑成功')
                                // 隐藏编辑店铺对话框
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