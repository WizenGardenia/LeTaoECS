import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import'./assets/css/global.css'
Vue.use(ElementUI);
// npm install --save axios vue-axios
// 配置axios
import axios from 'axios'
import VueAxios from 'vue-axios';
Vue.use(VueAxios,axios)

//axios.defaults.baseURL=''
//axios.interceptors.request.use(config => {
  //NProgress.start()
  // console.log(config)
  // 为请求头对象，添加token验证的Authorization字段
  //config.headers.Authorization = window.sessionStorage.getItem('token')
  // 在最后必须 return config
  //return config
//})
// response 拦截器中,  隐藏进度条NProgress.done()
//axios.interceptors.response.use(config => {
 // NProgress.done()
 // return config
//})
//Vue.prototype.$http = axios
//Vue.config.productionTip = false

new Vue({
  router,
  el: '#app',
  render: h => h(App)
}).$mount('#app')
