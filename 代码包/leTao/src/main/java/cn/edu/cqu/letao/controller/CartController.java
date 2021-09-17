package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.CartCommodity;
import cn.edu.cqu.letao.service.ICartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;
import cn.edu.cqu.letao.entity.Cart;
import cn.edu.cqu.letao.entity.vo.ResultBean;


/**
 * <p>
 * CART 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private ICartService cartService;


    @PostMapping("/addCommodity")
    public ResultBean<CartCommodity> addCommodity(Integer user_ID, Integer cmdty_ID) {
        ResultBean<CartCommodity> bean = new ResultBean<>();
        Cart cart= cartService.getCartInfo(user_ID,cmdty_ID);

        if(cart==null)
        {
//            Integer id =cartService.getID(user_ID,cmdty_ID);
            Cart cart1 = Cart.builder().cmdtyId(cmdty_ID).cmdtyNum(1).userId(user_ID).build();
            boolean flg = cartService.save(cart1);
            if(flg){
            bean.setCode("1");
            bean.setMsg("新加入购物车成功");
            List<CartCommodity> cartCommodity= cartService.cartCmdty(user_ID,cmdty_ID);
            bean.setData(cartCommodity);
            }

        }
        else if(cart.getCmdtyNum()>0&cart.getCmdtyNum()<10)
        {
            Integer id =cartService.getCartId(user_ID,cmdty_ID);
            Cart cart2 = Cart.builder().cartId(id).cmdtyNum(cart.getCmdtyNum()+1).build();
            boolean flg1 = cartService.updateById(cart2);
            if(flg1) {
                bean.setCode("2");
                bean.setMsg("该商品已经在购物车，数量+1");
            }
        }
        else
        {
            bean.setCode("3");
            bean.setMsg("添加失败，该商品数量达到限购数量");
        }


        return bean;
    }

    @PostMapping("/getCartInfo")
    public ResultBean<CartCommodity> getCartInfo(@RequestParam("user_ID") Integer user_ID)
    {
           List<CartCommodity> cartCommodities = cartService.cartCmdties(user_ID);
           ResultBean<CartCommodity> bean = new ResultBean<>();
           if(cartCommodities.size()!=0)
           {
               bean.setCode("1");
               bean.setMsg("查询成功");
               bean.setData(cartCommodities);
               bean.setTotal(cartCommodities.size());
           }
           else
           {
               bean.setCode("0");
               bean.setMsg("查询失败");
           }
           return bean;
    }

    @PostMapping("/updateCart")
    public ResultBean updateCart(@RequestParam("user_ID") Integer user_ID,@RequestParam("cmdty_ID") Integer cmdty_ID,@RequestParam("cmdty_num") Integer cmdty_num)
    {
        ResultBean bean = new ResultBean();
        Cart cart=Cart.builder().cartId(cartService.getCartId(user_ID,cmdty_ID)).cmdtyNum(cmdty_num).build();
        boolean flg = cartService.updateById(cart);
        if(flg)
        {
            bean.setCode("1");
            bean.setMsg("更新成功");

        }
        else
        {
            bean.setCode("0");
            bean.setMsg("更新失败");
        }
        return bean;
    }

    @PostMapping("delCart")
    public ResultBean delCart(@RequestParam("user_ID") Integer user_ID, @RequestParam("cmdty_ID") Integer cmdty_ID)
    {
        ResultBean bean = new ResultBean();
        boolean flg = cartService.removeById(cartService.getCartId(user_ID, cmdty_ID));
        if(flg)
        {
            bean.setCode("1");
            bean.setMsg("删除成功");
        }
        else
        {
            bean.setCode("0");
            bean.setMsg("删除失败");
        }
        return bean;
    }

    /*@RequestMapping("/deleteCommodity")
    public ResultBean<Integer> deleteCommodity(int cart_ID) {
        boolean result = cartService.deleteCommodity(cart_ID);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result){
            bean.setCode("1");
            bean.setMsg("删除成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("删除失败！");
        }
        return bean;
    }


    @RequestMapping("/showInformation")
    public ResultBean<Cart> showInformation(int cart_ID) {
        Cart information = cartService.showInformation(cart_ID);
        ResultBean<Cart> bean = new ResultBean<>();
        if(information == null){
            bean.setCode("0");
            bean.setMsg("获取信息失败！");
        } else {
            List<Cart> result = new ArrayList<>();
            result.add(information);
            bean.setCode("1");
            bean.setMsg("获取信息成功！");
            bean.setData(result);
        }
        return bean;
    }


    @RequestMapping("/isCartIDExist")
    public ResultBean<Integer> isCartIDExist(int user_ID, int cmdty_ID) {
        boolean result = cartService.isCartIDExist(user_ID, cmdty_ID);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result){
            bean.setCode("1");
            bean.setMsg("购物车ID存在！");
        } else {
            bean.setCode("0");
            bean.setMsg("购物车ID不存在！");
        }
        return bean;
    }


    @RequestMapping("/getID")
    public ResultBean<Integer> getID(int user_ID, int cmdty_ID) {
        int ID = cartService.getID(user_ID, cmdty_ID);
        ResultBean<Integer> bean = new ResultBean<>();
        if(ID == -1){
            bean.setCode("0");
            bean.setMsg("购物车ID不存在！");
        } else {
            List<Integer> result = new ArrayList<>();
            result.add(ID);
            bean.setCode("1");
            bean.setMsg("获取购物车ID");
            bean.setData(result);
        }
        return bean;
    }*/


//    @RequestMapping("/order")
//    public ResultBean<Cart> order(int cart_id) {
//        Cart order = cartService.order(cart_id);
//        ResultBean<Cart> bean = new ResultBean<>();
//        List<Cart> result = new ArrayList<>();
//        result.add(order);
//        bean.setCode("1");
//        bean.setMsg("返回下单信息");
//        bean.setData(result);
//        return bean;
//    }
}
