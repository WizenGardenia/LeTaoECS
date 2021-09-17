<!--
 * @Description: 首页组件
 * @Author: hai-27
 * @Date: 2020-02-07 16:23:00
 * @LastEditors: hai-27
 * @LastEditTime: 2020-02-27 13:36:12
 -->
<template>
  <div class="home" id="home" name="home">
    <!-- 轮播图 -->
    <div class="block">
      <el-carousel height="460px">
        <el-carousel-item v-for="item in carousel" :key="item.cmdtyName">
          <!-- <img style="height:460px;" :src="$target + item.imgPath" :alt="item.cmdtyType" /> -->
          <img style="height:460px;" :src="item.cmdtyPrev" :alt="item.cmdtyType" />
          <!-- <img style="height:460px;" :src="item.cmdtyPrev" /> -->
        </el-carousel-item>
      </el-carousel>
    </div>
    <!-- 轮播图END -->
    <div class="main-box">
      <div class="main">
        <!-- 手机商品展示区域 -->
        <div class="phone">
          <div class="box-hd">
            <div class="title">手机</div>
          </div>

          <div class="box-bd">
            <div class="promo-list">
              <router-link to>
                 <img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c583f2edc613f1be20fa415910b13ce3.jpg?" /> 
              </router-link>
            </div> 

              <div class="list">
              <MyList :list="phoneList" :isMore="true"></MyList>
              </div>

            </div>

          </div>
        </div>
        <!-- 手机商品展示区域END -->

        <!-- 家电商品展示区域 -->
        <div class="appliance" id="promo-menu">

          <div class="box-hd">
            <div class="title">家电</div>
            <div class="more" id="more">
               <!-- <MyMenu :val="2" @fromChild="getChildMsg">
                <span slot="1">热门</span>
                <span slot="2">电视影音</span>
              </MyMenu>  -->
            </div>
          </div>
          <div class="box-bd">
            <div class="promo-list">
              <ul>
                <li>
                   <img src="http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/116fc43816b87192be4e67cf762e8da5.jpeg?" /> 
                </li>
                <li>
                  <img src="http://106.15.179.105:3000/public/imgs/appliance/appliance-promo1.png" />
                </li>
              </ul>
            </div> -->
             <div class="list">
              <MyList :list="miTvList" :isMore="true"></MyList>
            </div>
          </div>
        </div>
        <!-- 家电商品展示区域END -->

        <!-- 配件商品展示区域 -->
        <div class="accessory" id="promo-menu">
          <div class="box-hd">
            <div class="title">智能</div>
            <div class="more" id="more">
              <!-- <MyMenu :val="3" @fromChild="getChildMsg2">
                <span slot="1">热门</span>
                <span slot="2">保护套</span>
                <span slot="3">充电器</span>
              </MyMenu> -->
            </div>
          </div>
          <div class="box-bd">
            <div class="promo-list">
              <ul>
                <li>
                  <img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a660ce095e8f553a9ed1515265f4e9fc.jpg?" /> 
                </li>
                <li>
                  <img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/ffe114f73fac3a45e5622c3eff56106b.jpg?" /> 
                </li>
              </ul>
            </div> 
             <div class="list">
              <MyList :list="accessoryList" :isMore="true"></MyList>
            </div>
          </div>
        </div>
        <!-- 配件商品展示区域END -->
      </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      carousel: "", // 轮播图数据
      phoneList: "", // 手机商品列表
      miTvList: "", // 小米电视商品列表
    //  applianceList: "", // 家电商品列表
      // applianceHotList: "", //热门家电商品列表
      accessoryList: "", //配件商品列表
      // accessoryHotList: "", //热门配件商品列表
      // protectingShellList: "", // 保护套商品列表
      // chargerList: "", //充电器商品列表
      // applianceActive: 1, // 家电当前选中的商品分类
      // accessoryActive: 1 // 配件当前选中的商品分类
    };
  },
  watch: {
    // 家电当前选中的商品分类，响应不同的商品数据
    applianceActive: function(val) {
      // 页面初始化的时候把applianceHotList(热门家电商品列表)直接赋值给applianceList(家电商品列表)
      // 所以在切换商品列表时判断applianceHotList是否为空,为空则是第一次切换,把applianceList赋值给applianceHotList
      if (this.applianceHotList == "") {
        this.applianceHotList = this.applianceList;
      }
      if (val == 1) {
        // 1为热门商品
        this.applianceList = this.applianceHotList;
        return;
      }
      if (val == 2) {
        // 2为电视商品
        this.applianceList = this.miTvList;
        return;
      }
    },
    accessoryActive: function(val) {
      // 页面初始化的时候把accessoryHotList(热门配件商品列表)直接赋值给accessoryList(配件商品列表)
      // 所以在切换商品列表时判断accessoryHotList是否为空,为空则是第一次切换,把accessoryList赋值给accessoryHotList
      if (this.accessoryHotList == "") {
        this.accessoryHotList = this.accessoryList;
      }
      if (val == 1) {
        // 1为热门商品
        this.accessoryList = this.accessoryHotList;
        return;
      }
      if (val == 2) {
        // 2为保护套商品
        this.accessoryList = this.protectingShellList;
        return;
      }
      if (val == 3) {
        //3 为充电器商品
        this.accessoryList = this.chargerList;
        return;
      }
    }
  },
  created() {
    // 获取轮播图数据
    //  const dateFormat2 = new FormData();
    //  dateFormat2.append=('keyword', "轮播图")
    this.$axios
      .post("/api/cmdty/findByKeyword?keyword=轮播图")
      .then(res => {
        this.carousel = res.data.data;
      })
      .catch(err => {
        return Promise.reject(err);
      });
    // 获取各类商品数据
    this.getPromo("手机", "phoneList");
    this.getPromo("家电", "miTvList");
     this.getPromo("智能", "accessoryList");
    // this.getPromo("充电器", "chargerList");
    // this.getPromo(
    //   ["电视机", "空调", "洗衣机"],
    //   "applianceList",
    //   "/api/product/getHotProduct"
    // );
    // this.getPromo(
    //   ["保护套", "保护膜", "充电器", "充电宝"],
    //   "accessoryList",
    //   "/api/product/getHotProduct"
    // );
  },
  methods: {
   
    getPromo(categoryName, val, api) {
      const dateFormat= new FormData();
      dateFormat.append('keyword',categoryName)
      api = api != undefined ? api : "/api/cmdty/findByKeyword";
      this.$axios
        .post(api, 
          dateFormat
        )
        .then(res => {
          this[val] = res.data.data;
        })
        .catch(err => {
          return Promise.reject(err);
        });
    }
  }
 };
 </script>
 <style scoped>
 @import "../assets/css/index.css";
 </style>