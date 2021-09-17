<template>
  <div>
    <!-- 面包屑导航区 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>订单管理</el-breadcrumb-item>
      <el-breadcrumb-item>订单列表</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图 -->
    <el-card>
      <el-row>
      <el-col :span="15">
                       <el-input placeholder="请输入店铺号" v-model="input" class="input-with-select">
                  <el-button slot="append" icon="el-icon-search" @click="getOrder(input)"></el-button>
                  </el-input>
                  </el-col>

      </el-row>

      <!-- 订单列表 -->
      <el-table
      :data="orderlist"
      :key="certinfokey"
      height="250"
          border
          stripe
          style="width: 100%" >
        <el-table-column type="index" label="#"></el-table-column>
        <el-table-column label="订单编号" prop="orderID"></el-table-column>
        <el-table-column label="商品ID" prop="cmdtyDetailsID"></el-table-column>
        <el-table-column label="商品单价" prop="cmdtyDetails"></el-table-column>
        <el-table-column label="商品数量" prop="cmdtyNum"></el-table-column>
        <el-table-column label="是否付款" prop="orderState"></el-table-column>
        <el-table-column label="是否发货" prop="logState"></el-table-column>
        <el-table-column label="下单时间" prop="cmdtyDate"></el-table-column>
        <el-table-column label="地址" prop="userAddress"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="setOrderLog(scope.row.orderID)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页区域 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pagenum"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="queryInfo.pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-card>


  </div>
</template>

<script>
import cityData from './citydata.js'

export default {
  data () {
    return {
      // 订单列表查询参数
      queryInfo: {
        code:'',
         msg:'',
         data:[]
      },
      input:'',
      total: 0,
      // 订单列表


      orderlist:[],
      cityData,


      certinfokey:''
    }
  },
  created () {

  },
  methods: {



    getOrder(shopId){
       this.axios.get("http://localhost:8080/order-form/showOrder?shopid="+shopId,this.queryInfo).then((response)=>{
                    console.log(response)
                    this.orderlist=response.data.data[0].model.myOrder
                    this.total=response.data.total
                    console.log(this.orderlist)
                    this.certinfokey=Math.random();
                    console.log(this.certinfokey)
                })

    },
    setOrderLog(id){
       this.axios.get("http://localhost:8080/order-form/updateOrder?id="+id+"&state=已发货",this.queryInfo).then((response)=>{
                           console.log(response)
                           if(response.data.code==="0") {
                                                      this.$message.error('确认发货失败')
                                                      }else{
                                                      this.$message.success('确认发货成功,请刷新页面')


                                                      }
                       })



    }



  }
}
</script>

<style lang="less" scoped>
.el-cascader {
  width: 100%;
}
</style>
