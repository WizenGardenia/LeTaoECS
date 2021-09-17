package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.Cmdty;
import cn.edu.cqu.letao.entity.CmdtyDetails;
import cn.edu.cqu.letao.entity.vo.ResultBean;
import cn.edu.cqu.letao.service.ICmdtyDetailsService;
import cn.edu.cqu.letao.service.ICmdtyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * CMDTY 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/cmdty")
@CrossOrigin
public class CmdtyController {

    @Resource
    private ICmdtyService cmdtyService;
    @Resource
    private ICmdtyDetailsService cmdtyDetailsService;

    @PostMapping("/findByKeyword")
    public ResultBean<Cmdty> findByKeyword(@RequestParam("keyword") String keyword) {
        String cmdty_type = keyword;
        String cmdty_name = keyword;
        List<Cmdty> list = cmdtyService.findByName(cmdty_name);
        ResultBean<Cmdty> beans = new ResultBean<>();

        if(list.size()!=0)
        {
                beans.setMsg("用户请求成功");
                beans.setCode("200");
             //   List<List<Cmdty>> data = new ArrayList<>();
              //  data.add(list);

                beans.setData(list);
                beans.setTotal(list.size());
                return beans;
        }

        else
        {
            List<Cmdty> list1 = cmdtyService.findByType(cmdty_type);
            ResultBean<Cmdty> beans1 = new ResultBean<>();

            if(list1.size()!=0)
            {
                    beans1.setMsg("用户请求成功");
                    beans1.setCode("200");
                 //   List<List<Cmdty>> data1 = new ArrayList<>();
                 //   data1.add(list1);
                    beans1.setData(list1);
                    beans1.setTotal(list1.size());
            }
            else
            {

                beans1.setMsg("用户请求失败");
                beans1.setCode("0");
            }

            return  beans1;
        }
    }


    @PostMapping("/showCmdties")
    public ResultBean<Cmdty> showCmdties()
    {
        List<Cmdty> cmdties = new ArrayList<>();
        ResultBean<Cmdty> bean = new ResultBean<>();
        cmdties=cmdtyService.showAll();
        if(cmdties.size()!=0)
        {
            bean.setMsg("用户请求成功");
            bean.setCode("1");
            bean.setData(cmdties);
            bean.setTotal(cmdties.size());
        }
        else
        {
            bean.setMsg("用户请求失败");
            bean.setCode("0");
        }
        return bean;
    }


    @RequestMapping("/creatCmdty")
    public ResultBean creatCmdty(String name, int shopid, String type, String prev, String details){
        ResultBean bean = new ResultBean();
        Cmdty cmdty = Cmdty.builder().shopId(shopid).cmdtyName(name).cmdtyType(type).cmdtyPrev(prev).cmdtyDetails(details).build();
        boolean flg = cmdtyService.save(cmdty);

        if(flg) {
            bean.setMsg("创建成功");
            bean.setCode("1");

        }else{
            bean.setMsg("创建失败");
            bean.setCode("0");
        }
        return bean;
    }

    @RequestMapping("/showCmdty")
    public ResultBean<ModelAndView> showCmdty(String shopid){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        QueryWrapper<Cmdty> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_ID",shopid);

        List<Cmdty> myCmdty = cmdtyService.list(queryWrapper);
        mv.addObject("myCmdty",myCmdty);
        mv.setViewName("CmdtyList");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("所有商品查询完成");

        return bean;
    }

    @RequestMapping("/goUpdateCmdty")
    public ResultBean<ModelAndView> goUpdateCmdty(String id, String name, String type, String prev, String details){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        mv.addObject("cmdty_ID",id);
        mv.addObject("cmdty_name",name);
        mv.addObject("cmdty_type",type);
        mv.addObject("cmdty_prev",prev);
        mv.addObject("cmdty_details",details);
        mv.setViewName("updateCmdty");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("前往修改");
        return bean;

    }

/*    @RequestMapping("/updateCmdty")
    public ResultBean updateCmdty(Cmdty cmdty){
        ResultBean bean = new ResultBean();

        Cmdty newCmdty=Cmdty.builder().cmdtyId(cmdty.getCmdtyId()).cmdtyName(cmdty.getCmdtyName())
                .cmdtyPrev(cmdty.getCmdtyPrev()).cmdtyDetails(cmdty.getCmdtyDetails()).build();
        boolean flg = cmdtyService.updateById(newCmdty);
        if(flg) {
            bean.setMsg("更新成功");
            bean.setCode("1");

        }else{
            bean.setMsg("更新失败");
            bean.setCode("0");
        }
        return bean;

    }

    @RequestMapping("/delCmdty")
    public ResultBean delCmdty(String id){
        ResultBean bean = new ResultBean();
        QueryWrapper<CmdtyDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cmdty_ID",id);
        List<CmdtyDetails> CmdtyDetails = cmdtyDetailsService.list(queryWrapper);
        for(int i = 0; i<CmdtyDetails.size(); i++){
            boolean flgD = cmdtyDetailsService.removeById(CmdtyDetails.get(i).getCmdtyDetailsId());
            if(flgD){
                System.out.println("成功删除第"+i+"种子商品");
            }else{
                System.out.println("删除第"+i+"种子商品失败");
            }
        }

        boolean flg = cmdtyService.removeById(id);

        if(flg) {
            bean.setMsg("删除成功");
            bean.setCode("1");

        }else{
            bean.setMsg("删除失败");
            bean.setCode("0");
        }
        return bean;

    }*/
@RequestMapping("/updateCmdty")
public ResultBean updateCmdty(Integer id , String name, String type, String prev, String details){
    ResultBean bean = new ResultBean();

    Cmdty newCmdty=Cmdty.builder().cmdtyId(id).cmdtyName(name).cmdtyType(type)
            .cmdtyPrev(prev).cmdtyDetails(details).build();
    boolean flg = cmdtyService.updateById(newCmdty);
    if(flg) {
        bean.setMsg("更新成功");
        bean.setCode("1");

    }else{
        bean.setMsg("更新失败");
        bean.setCode("0");
    }
    return bean;

}

    @RequestMapping("/delCmdty")
    public ResultBean delCmdty(String id){
        ResultBean bean = new ResultBean();
        /*QueryWrapper<CmdtyDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cmdty_ID",id);
        List<CmdtyDetails> CmdtyDetails = cmdtyDetailsService.list(queryWrapper);
        for(int i = 0; i<CmdtyDetails.size(); i++){
            boolean flgD = cmdtyDetailsService.removeById(CmdtyDetails.get(i).getCmdtyDetailsId());
            if(flgD){
                System.out.println("成功删除第"+i+"种子商品");
            }else{
                System.out.println("删除第"+i+"种子商品失败");
            }
        }*/

        boolean flg = cmdtyService.removeById(id);

        if(flg) {
            bean.setMsg("删除成功");
            bean.setCode("1");

        }else{
            bean.setMsg("删除失败");
            bean.setCode("0");
        }
        return bean;

    }


}