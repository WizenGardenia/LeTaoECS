package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.CmdtyDetails;
import cn.edu.cqu.letao.entity.vo.CommodityVO;
import cn.edu.cqu.letao.entity.vo.ResultBean;
import cn.edu.cqu.letao.service.ICmdtyDetailsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * CMDTY_DETAILS 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/cmdty-details")
public class CmdtyDetailsController {

    @Resource
    private ICmdtyDetailsService cmdtyDetailsService;

/*    @RequestMapping("/showCmdDetails")
    public ResultBean<CommodityVO> showCmdDetails(String cmdty_name)
    {
        List<CommodityVO> list =cmdtyDetailsService.showCommodity(cmdty_name);
        ResultBean<CommodityVO> bean= new ResultBean<>();
        if(list.size()!=0)
        {
            bean.setCode("200");
            bean.setMsg("用户请求成功");
            bean.setData(list);
        }
        else
        {
            bean.setMsg("用户请求失败");
            bean.setCode("0");
        }
        return bean;
    }*/

    @PostMapping("/showCmdDetails")
    public ResultBean<CommodityVO> showCmdDetails(@RequestParam("cmdty_id") String cmdty_id)
    {
        List<CommodityVO> list =cmdtyDetailsService.showCommodity(cmdty_id);
        ResultBean<CommodityVO> bean= new ResultBean<>();
        if(list.size()!=0)
        {
            bean.setCode("200");
            bean.setMsg("用户请求成功");
            bean.setData(list);
        }
        else
        {
            bean.setMsg("用户请求失败");
            bean.setCode("0");
        }
        return bean;
    }

    @RequestMapping("/creatCD")
    public ResultBean creatCD(int cmdtyid, float price, int volume, int stock, String prmt){
        ResultBean bean = new ResultBean();
        CmdtyDetails cmdtyDetails = CmdtyDetails.builder().cmdtyId(cmdtyid).cmdtyPrice(price)
                .cmdtyVolume(volume).cmdtyStock(stock).cmdtyPrmt(prmt)
                .build();
        boolean flg = cmdtyDetailsService.save(cmdtyDetails);

        if(flg) {
            bean.setMsg("创建成功");
            bean.setCode("1");

        }else{
            bean.setMsg("创建失败");
            bean.setCode("0");
        }
        return bean;
    }

    @RequestMapping("/showCD")
    public ResultBean<ModelAndView> showCD(String cmdtyID){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        QueryWrapper<CmdtyDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cmdty_ID",cmdtyID);

        List<CmdtyDetails> CmdtyDetails = cmdtyDetailsService.list(queryWrapper);
        mv.addObject("CmdtyDetails",CmdtyDetails);
        mv.setViewName("detailsList");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("商品详情查询完成");

        return bean;
    }

    @RequestMapping("/goUpdateCD")
    public ResultBean<ModelAndView> goUpdateCD(String id, float price, int volume, int stock, String prmt){
        ResultBean<ModelAndView> bean = new ResultBean<>();
        ModelAndView mv = new ModelAndView();
        mv.addObject("cmdtyDetails_ID",id);
        mv.addObject("cmdty_price",price);
        mv.addObject("cmdty_volume",volume);
        mv.addObject("cmdty_stock",stock);
        mv.addObject("cmdty_prmt",prmt);
        mv.setViewName("updateCmdtyDetails");
        List<ModelAndView> mvlist = new ArrayList<>();
        mvlist.add(mv);
        bean.setData(mvlist);
        bean.setCode("1");
        bean.setMsg("前往修改");
        return bean;

    }

    @RequestMapping("/updateCD")
    public ResultBean updateCD(CmdtyDetails CD){
        ResultBean bean = new ResultBean();
        CmdtyDetails cmdtyDetails = CmdtyDetails.builder().cmdtyDetailsId(CD.getCmdtyDetailsId()).cmdtyPrice(CD.getCmdtyPrice())
                .cmdtyVolume(CD.getCmdtyVolume()).cmdtyStock(CD.getCmdtyStock()).cmdtyPrmt(CD.getCmdtyPrmt())
                .build();


        boolean flg = cmdtyDetailsService.updateById(cmdtyDetails);
        if(flg) {
            bean.setMsg("更新成功");
            bean.setCode("1");

        }else{
            bean.setMsg("更新失败");
            bean.setCode("0");
        }
        return bean;

    }

    @RequestMapping("/delDetails")
    public ResultBean delDetails(String id){
        ResultBean bean = new ResultBean();
        boolean flg = cmdtyDetailsService.removeById(id);

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
