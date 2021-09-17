import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import Login from '@/components/Login'
import Home from '@/components/Home'
import Welcome from '@/components/Welcome'
import Users from '@/components/user/Users'
import Goods from '@/components/goods/Goods'
import Order from '@/components/order/Order'
import Register from '@/components/Register'
import Shop from '@/components/user/Shop'

Vue.use(Router)

const router= new Router({
    routes: [
        {
            path: '/',
            redirect: '/login2'
        },
        // 下面都是固定的写法
        {
            path: '/login2',
            name: 'Login',
            component: Login
        },
        {
            path: '/register2',
            name: 'Register',
            component: Register
        },
        {
            path: '/home',
            name: 'Home',
            component: Home,
            redirect:'/welcome',
            children:[{path:'/welcome',component:Welcome},
                      {path:'/1',component:Welcome},
                      {path:'/2',component:Users},
                      {path:'/3',component:Shop},
                      {path:'/4',component:Order},
                      {path:'/5',component:Goods}]
        },
    ]
})

/*// 挂载路由导航守卫,to表示将要访问的路径，from表示从哪里来，next是下一个要做的操作 next('/login')强制跳转login
router.beforeEach((to, from, next) => {
    // 访问登录页，放行
    if (to.path === '/login') return next()
    // 获取token
    const tokenStr = window.sessionStorage.getItem('token')
    // 没有token, 强制跳转到登录页
    if (!tokenStr) return next('/login')
    next()
  })*/


  export default router