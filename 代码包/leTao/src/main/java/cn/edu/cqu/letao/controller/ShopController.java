package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.Shop;
import cn.edu.cqu.letao.entity.User;
import cn.edu.cqu.letao.entity.vo.ResultBean;
import cn.edu.cqu.letao.service.IShopService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * SHOP 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Resource
    private IShopService shopService;

    @RequestMapping("/createShop")

    public ResultBean createShop(Integer userid, String name){
        ResultBean bean = new ResultBean();
        Shop shop = Shop.builder().userId(userid).shopName(name).build();

        boolean flg = shopService.save(shop);

        if(flg==true) {
            bean.setMsg("创建成功");
            bean.setCode("1");

        }else{
            bean.setMsg("创建失败");
            bean.setCode("0");
        }
        return bean;
    }

    @RequestMapping("/delShop")

    public ResultBean delShop(String id){
        ResultBean bean = new ResultBean();
        boolean flg = shopService.removeById(id);

        if(flg) {
            bean.setMsg("删除成功");
            bean.setCode("1");

        }else{
            bean.setMsg("删除失败");
            bean.setCode("0");
        }
        return bean;
    }

    @GetMapping("/showShop")
    @ResponseBody
    public ResultBean<ModelAndView> showShop(String id){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_ID",id);

        List<Shop> myShop = shopService.list(queryWrapper);
        mv.addObject("myShop",myShop);
        mv.setViewName("shopList");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("所有店铺查询完成");
        return bean;
    }

    @RequestMapping("/goUpdateShop")
    public ResultBean<ModelAndView> goUpdateShop(String id, String userID, String name){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        mv.addObject("shop_ID",id);
        mv.addObject("user_ID",userID);
        mv.addObject("shop_name",name);
        mv.setViewName("updateShop");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("前往修改");
        return bean;

    }

    @RequestMapping("/updateShop")
    public ResultBean updateShop(Integer shopId, String shopName){
        ResultBean bean = new ResultBean();

        Shop newShop=Shop.builder().shopId(shopId).shopName(shopName).build();
        boolean flg = shopService.updateById(newShop);
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
