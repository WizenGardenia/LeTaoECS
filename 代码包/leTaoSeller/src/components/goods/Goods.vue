<template>
    <div>
        <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">商品</a></el-breadcrumb-item>
        <el-breadcrumb-item>信息</el-breadcrumb-item>
        <el-breadcrumb-item>具体信息</el-breadcrumb-item>
        </el-breadcrumb>

        <el-card class="box-card">
            <el-row gutter="20">
            <el-col :span="15">
                    <el-input placeholder="请输入店铺号" v-model="input" class="input-with-select">
                       <el-button slot="append" icon="el-icon-search" @click="getGoodsList(input)"></el-button>
                    </el-input>
            </el-col>

                </el-row>
        <el-table
    :data="Goodslist"
    :key="certinfokey"
    height="250"
    border
    stripe
    style="width: 100%">
    <el-table-column type="index"></el-table-column>
    <el-table-column
      prop="cmdtyId"
      label="商品号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="cmdtyName"
      label="商品名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="cmdtyType"
      label="商品类型">
    </el-table-column>
    <el-table-column
          prop="cmdtyDetails"
          label="商品价格">
        </el-table-column>
        <el-table-column
              prop="cmdtyPrev"
              label="商品预览图">
            </el-table-column>

    <el-table-column
      label="操作" width="180px">
      <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="updateForm(scope.row.cmdtyId,scope.row.cmdtyName,scope.row.cmdtyType,scope.row.cmdtyPrev,scope.row.cmdtyDetails);editDialogVisible=true"></el-button>
          <el-button type="warning" icon="el-icon-delete" size="mini" @click="delGood(scope.row.cmdtyId)"></el-button>
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

<el-dialog title="编辑店铺" :visible.sync="editDialogVisible" width="50%" @close="addDialogClosed">
              <!-- 内容主体 -->
              <el-form
                :model="shop"
                ref="addShopFormRef"

                label-width="100px"
              >
                <el-form-item label="商品名" prop="name">
                  <el-input v-model="editGoodForm.name"></el-input>
                </el-form-item>
                <el-form-item label="价格" prop="name">
                                  <el-input v-model="editGoodForm.price"></el-input>
                                </el-form-item>
                                <el-form-item label="预览图" prop="name">
                                                  <el-input v-model="editGoodForm.prev"></el-input>
                                                </el-form-item>
                                                <el-form-item label="商品类型" prop="name">
                                                                  <el-input v-model="editGoodForm.type"></el-input>
                                                                </el-form-item>

              </el-form>
              <span slot="footer" class="dialog-footer">
                <el-button @click="editDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editGood(editGoodForm.id,editGoodForm.name,editGoodForm.type,editGoodForm.prev,editGoodForm.price)">确 定</el-button>
              </span>
            </el-dialog>

   </div>
</template>
<script>
export default{
    data(){
        return{
            queryInfo:{

            },
            Goodslist:[],
            total:0,
            editDialogVisible:false,
            input:'',
            certinfokey:'',
            editGoodForm:{
            id:'',
            name:'',
            type:'',
            prev:'',
            price:''



            }
        }
    },
    created(){

    },
    methods:{
        getGoodsList(shopId){
        this.axios.get("http://localhost:8080/cmdty/showCmdty?shopid="+shopId,this.queryInfo).then((response)=>{
                            console.log(response)
                            this.Goodslist=response.data.data[0].model.myCmdty
                            this.total=response.data.total
                            console.log(this.Goodslist)
                            this.certinfokey=Math.random();
                            console.log(this.certinfokey)
                        })
          

        },
        editGood(id, name , type , prev , price){

        this.axios.get("http://localhost:8080/cmdty/updateCmdty?id="+id+"&name="+name+"&type="+type+"&prev="+prev+"&details="+price,this.queryInfo).then((response)=>{
                                            console.log(response)

                               if(response.data.code==="0") {
                                   this.$message.error('编辑失败')
                                        }else{
                                        this.$message.success('编辑成功')
                                        // 隐藏编辑商品对话框
                                        this.editDialogVisible = false
                                        location.reload();
                                        }

                           })

        },
        delGood(shopId){
        this.axios.get("http://localhost:8080/cmdty/delCmdty?id="+shopId,this.queryInfo).then((response)=>{
                                            console.log(response)


                                            if(response.data.code==="0") {
                                                            this.$message.error('删除失败')
                                                        }else{
                                                            this.$message.success('删除成功')
                                                            this.certinfokey=Math.random();
                                                        }
                                        })

        },

                 updateForm(id, name , type , prev , price){
                      this.editGoodForm.id=id
                      this.editGoodForm.name=name
                      this.editGoodForm.type=type
                      this.editGoodForm.prev=prev
                      this.editGoodForm.price=price
                      console.log(this.editGoodForm)

                 }

        
    }

}
</script>
<style lang="less" scoped>

</style>
