package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.OrderForm;
import cn.edu.cqu.letao.entity.CartCommodity;
import cn.edu.cqu.letao.entity.vo.OrdersVO;
import cn.edu.cqu.letao.entity.vo.ResultBean;
import cn.edu.cqu.letao.entity.vo.sellerOrderVO;
import cn.edu.cqu.letao.service.IOrderFormService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ORDER_FORM 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/order-form")
@CrossOrigin
public class OrderFormController {

   @Resource
   private IOrderFormService orderFormService;
/*   @RequestMapping("/submitOrder")
   public ResultBean submitOrder(@RequestParam(value = "cmdty_details_ID[]") List<Integer> cmdty_details_ID,
                                 Integer user_ID, Boolean order_state,
                                 @RequestParam(value = "cmdty_num[]") List<Integer> cmdty_num, Integer orderNum )
   {
      List<OrderForm> orderForms = new ArrayList<>();
      Integer i;
      OrderForm orderForm;


      for(i=0;i<orderNum;i++)
      {
         orderForm=orderFormService.getShopId(cmdty_details_ID.get(i));
         orderForm.setLogState("待发货");
         orderForm.setOrderState(order_state);
         orderForm.setCmdtyDate(LocalDate.now());
         orderForm.setCmdtyNum(cmdty_num.get(i));
         orderForm.setCmdtyDetailsId(cmdty_details_ID.get(i));
         orderForm.setUserId(user_ID);
         orderForms.add(orderForm);
      }

      ResultBean bean =new ResultBean();
      if(i==orderNum-1)
      {
      bean.setCode("200");
      bean.setMsg("用户请求成功");
      }
      else
      {
         bean.setCode("0");
         bean.setMsg("用户请求失败");
      }
      return bean;
   }*/

//   @PostMapping("/addOrders")
//   public ResultBean addOrders(@RequestParam("cartCommodities") String cartCommodities, @RequestParam("user_ID")  Integer user_ID)
//   {
//      Integer i;
//      ResultBean bean = new ResultBean();
//      JSONArray picArray = JSONArray.parseArray(cartCommodities);
//      for(i=0;i<cartCommodities.size();i++)
//      {
//          OrderForm orderForm = OrderForm.builder().
//                  cmdtyDetailsId(cartCommodities.get(i).getCmdtyId()).
//                  userId(user_ID).cmdtyDate(LocalDate.now()).
//                  cmdtyNum(cartCommodities.get(i).getCmdtyNum()).build();
//      }
//      if(i==cartCommodities.size()-1)
//      {
//         bean.setCode("1");
//         bean.setMsg("订单提交成功");
//      }
//      else
//      {
//         bean.setCode("0");
//         bean.setMsg("订单提交失败");
//      }
//      return bean;
//   }


   @RequestMapping("/dealOrder")
   public ResultBean dealOrder(@RequestParam(value = "order_ID[]") List<Integer> order_ID, Integer orderNums)
   {
       Integer i;
        for(i=0;i<orderNums;i++)
        {
          OrderForm orderForm = OrderForm.builder().orderId(order_ID.get(i)).logState("已发货").build();
          orderFormService.updateById(orderForm);
        }
      ResultBean bean =new ResultBean();
      if(i==orderNums-1)
      {
         bean.setCode("200");
         bean.setMsg("用户请求成功");
      }
      else
      {
         bean.setCode("0");
         bean.setMsg("用户请求失败");
      }
      return bean;
   }




   @RequestMapping("/showOrders")
   public ResultBean<OrdersVO> showOrders(Integer userId)
   {
      ResultBean<OrdersVO> bean = new ResultBean<>();
      List<OrdersVO> ordersVOS= orderFormService.showOrders(userId);
      if(ordersVOS.size()!=0)
      {
         bean.setCode("200");
         bean.setMsg("用户请求成功");
         bean.setData(ordersVOS);
      }
      else
      {
         bean.setCode("0");
         bean.setMsg("用户请求失败");
      }
      return bean;
   }
   @RequestMapping("/orderState")
   public ResultBean<OrdersVO> orderState(Integer userId)
   {
      ResultBean<OrdersVO> bean = new ResultBean<>();
      List<OrdersVO> ordersVOS= orderFormService.orderState(userId);
      if(ordersVOS.size()!=0)
      {
         bean.setCode("200");
         bean.setMsg("用户请求成功");
         bean.setData(ordersVOS);
      }
      else
      {
         bean.setCode("0");
         bean.setMsg("用户请求失败");
      }
      return bean;
   }
/*
   @RequestMapping("/showOrder")
   public ResultBean<ModelAndView> showOrder(String shopid){
      ResultBean<ModelAndView> bean = new ResultBean<>();
      ModelAndView mv = new ModelAndView();
      QueryWrapper<OrderForm> queryWrapper = new QueryWrapper<>();
      queryWrapper.eq("shop_ID",shopid);

      List<OrderForm> myOrder = orderFormService.list(queryWrapper);
      mv.addObject("myOrder",myOrder);
      mv.setViewName("orderList");
      List<ModelAndView> mvlist = new ArrayList<>();
      mvlist.add(mv);
      bean.setData(mvlist);
      bean.setCode("1");
      bean.setMsg("所有订单查询完成");

      return bean;
   }
*/
@RequestMapping("/showOrder")
public ResultBean<ModelAndView> showOrder(Integer shopid){
   ResultBean<ModelAndView> bean = new ResultBean<>();
   ModelAndView mv = new ModelAndView();

   List<sellerOrderVO> myOrder = orderFormService.sellerOrder(shopid);

   mv.addObject("myOrder",myOrder);
   mv.setViewName("orderList");
   List<ModelAndView> mvlist = new ArrayList<>();
   mvlist.add(mv);
   bean.setData(mvlist);
   bean.setCode("1");
   bean.setMsg("所有订单查询完成");

   return bean;
}



/*   @RequestMapping("/updateOrder")
   public ResultBean updateOrder(OrderForm order){
      OrderForm updateOrder=OrderForm.builder().orderId(order.getOrderId()).logState(String.valueOf(order.getOrderState())).build();
      ResultBean bean = new ResultBean();
      boolean flg = orderFormService.updateById(updateOrder);
      if(flg) {
         bean.setMsg("更新成功");
         bean.setCode("1");

      }else{
         bean.setMsg("更新失败");
         bean.setCode("0");
      }
      return bean;
   }*/

   @RequestMapping("/updateOrder")
   public ResultBean updateOrder(Integer id, String state){
      OrderForm updateOrder=OrderForm.builder().orderId(id).logState(state).build();
      ResultBean bean = new ResultBean();
      boolean flg = orderFormService.updateById(updateOrder);
      if(flg) {
         bean.setMsg("更新成功");
         bean.setCode("1");

      }else{
         bean.setMsg("更新失败");
         bean.setCode("0");
      }
      return bean;
   }
}
