package cn.edu.cqu.letao.controller;


import cn.edu.cqu.letao.entity.Buyer;
import cn.edu.cqu.letao.entity.LoginForm;
import cn.edu.cqu.letao.entity.User;
import cn.edu.cqu.letao.entity.vo.Result;
import cn.edu.cqu.letao.entity.vo.ResultBean;
import cn.edu.cqu.letao.service.IUserService;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * USER 前端控制器
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private IUserService userService;

/*    @RequestMapping("/register")
    public ResultBean<Integer> register(String username, String password, int user_type, int verification, int randomVerification) {
        int result = userService.register(username, password, user_type, verification, randomVerification);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("注册成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("注册失败！");
        }
        return bean;
    }*/
@RequestMapping("/register2")
public ResultBean<Integer> register2(String username, String password, int user_type, int verification, int randomVerification) {
    int result = userService.register(username, password, user_type, verification, randomVerification);
    ResultBean<Integer> bean = new ResultBean<>();
    if(result == 1) {
        bean.setCode("1");
        bean.setMsg("注册成功！");
    } else {
        bean.setCode("0");
        bean.setMsg("注册失败！");
    }
    return bean;
}
    @PostMapping("/login2")
    @CrossOrigin
    public ResultBean<Integer> login2(@RequestBody LoginForm loginForm) {
        System.err.println("------------->"+loginForm);
        int result = userService.login(loginForm.getUsername(), loginForm.getPassword(),1, 1);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("买家登陆成功！");
        } else if(result == 2) {
            bean.setCode("2");
            bean.setMsg("卖家登陆成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("登陆失败！");
        }
        return bean;
    }

    @RequestMapping("/register")
    public ResultBean<Integer> register(@RequestParam("username") String username, @RequestParam("password") String password) {
        int result = userService.register(username, password, 1, 1, 1);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("注册成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("注册失败！");
        }
        return bean;
    }


/*    @PostMapping("/login")
    @CrossOrigin
    public ResultBean<Integer> login(@RequestBody LoginForm LoginUser) {
        System.err.println("------------->"+LoginUser);
        int result = userService.login(LoginUser.getUsername(), LoginUser.getPassword(), LoginUser.getVerification(), LoginUser.getRandomVerification());
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("买家登陆成功！");
        } else if(result == 2) {
            bean.setCode("2");
            bean.setMsg("卖家登陆成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("登陆失败！");
        }
        return bean;
    }*/

       @PostMapping("/login")
       @ResponseBody
       @CrossOrigin
        public Result login(@RequestParam("username")String username, @RequestParam("password")String password) {
////           System.err.println(LoginUser.getUsername()+"---------->"+LoginUser.getPassword());
       //     System.err.println("------------->"+LoginUser);
//            int result = userService.login(LoginUser.getUsername(), LoginUser.getPassword(), 1,1);
           System.err.println("------------->"+username);
           System.err.println("------------->"+password);

           int result = userService.login(username, password, 1,1);
           System.err.println("result---------->"+result);
            Result result1= new Result();
            Buyer buyer = new Buyer();
            if(result == 1) {
               result1.setCode("1");
                result1.setMsg("买家登陆成功！");
                buyer.setUserName(username);
                buyer.setUser_id(userService.getID(username));
                result1.setData(buyer);
                System.err.println("登录成功");
            }
//            else if(result == 2) {
//                bean.setCode("2");
//                bean.setMsg("卖家登陆成功！");
//
//            }
            else {
                result1.setCode("0");
                result1.setMsg("登陆失败！");
                System.err.println("hello");
            }
            return result1;
        }
    @RequestMapping("/showInformation")
    public ResultBean<User> showInformation(String username) {
        User information = userService.showInformation(username);
        ResultBean<User> bean = new ResultBean<>();
        List<User> result = new ArrayList<>();
        result.add(information);
        bean.setCode("1");
        bean.setMsg("获取用户信息");
        bean.setData(result);
        return bean;
    }


    @RequestMapping("/isUsernameExist")
    public ResultBean<Integer> isUsernameExist(@RequestParam("username") String username) {
        boolean result = userService.isUsernameExist(username);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result){
            bean.setCode("1");
            bean.setMsg("用户名已存在");
        } else {
            bean.setCode("0");
            bean.setMsg("用户名不存在");
        }
        return bean;
    }


    @RequestMapping("/getID")
    public ResultBean<Integer> getID(String username) {
        int ID = userService.getID(username);
        ResultBean<Integer> bean = new ResultBean<>();
        List<Integer> result = new ArrayList<>();
        result.add(ID);
        bean.setCode("1");
        bean.setMsg("获取用户ID");
        bean.setData(result);
        return bean;
    }


    @RequestMapping("/getPassword")
    public ResultBean<String> getPassword(String username) {
        String password = userService.getPassword(username);
        ResultBean<String> bean = new ResultBean<>();
        List<String> result = new ArrayList<>();
        result.add(password);
        bean.setCode("1");
        bean.setMsg("获取用户密码");
        bean.setData(result);
        return bean;
    }


    @RequestMapping("/getType")
    public ResultBean<Integer> getType(String username) {
        int type = userService.getType(username);
        ResultBean<Integer> bean = new ResultBean<>();
        if(type == 1){
            bean.setCode("1");
            bean.setMsg("该用户为买家");
        } else {
            bean.setCode("2");
            bean.setMsg("该用户为卖家");
        }
        return bean;
    }


    @RequestMapping("/verify")
    public ResultBean<Integer> verify(){
        int verification = userService.verify();
        ResultBean<Integer> bean = new ResultBean<>();
        List<Integer> result = new ArrayList<>();
        result.add(verification);
        bean.setCode("1");
        bean.setMsg("生成验证码");
        bean.setData(result);
        return bean;
    }


    @RequestMapping("/changeNickname")
    public ResultBean<Integer> changeNickname(String username, String password, String newNickname){
        int result = userService.changeNickname(username, password, newNickname);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("修改昵称成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("修改昵称失败！");
        }
        return bean;
    }


    @RequestMapping("/changePassword")
    public ResultBean<Integer> changePassword(String username, String password, String newPassword){
        int result = userService.changePassword(username, password, newPassword);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("修改密码成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("修改密码失败！");
        }
        return bean;
    }


    @RequestMapping("/changeTelephone")
    public ResultBean<Integer> changeTelephone(String username, String password, String newTelephone){
        int result = userService.changeTelephone(username, password, newTelephone);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("修改电话成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("修改电话失败！");
        }
        return bean;
    }


    @RequestMapping("/changeAddress")
    public ResultBean<Integer> changeAddress(String username, String password, String newAddress){
        int result = userService.changeAddress(username, password, newAddress);
        ResultBean<Integer> bean = new ResultBean<>();
        if(result == 1) {
            bean.setCode("1");
            bean.setMsg("修改地址成功！");
        } else {
            bean.setCode("0");
            bean.setMsg("修改地址失败！");
        }
        return bean;
    }

    @RequestMapping("/pay")
    public ResultBean pay(Integer userId,Float expense,String password)
    {
        User user = userService.getById(userId);
        ResultBean bean = new ResultBean<>();
        String passWord=user.getUserPassword();
        if(password.equals(passWord))
        {
            if(expense<=user.getUserAccount())
            {
                User user1= User.builder().userId(userId).userAccount(user.getUserAccount()-expense).build();
                boolean flg =userService.updateById(user1);
                bean.setCode("200");
                bean.setMsg("支付成功");

            }
            else
            {
                bean.setCode("0");
                bean.setMsg("余额不足");
            }

        }
        else
        {
            bean.setCode("0");
            bean.setMsg("密码错误");
        }

     return bean;
    }

    @RequestMapping("/updateUser")
    public ResultBean updateUser(Integer userId, String nick, String add,String tel){
        ResultBean bean = new ResultBean();

        User newUser=User.builder().userId(userId).userNickname(nick).userAddress(add).userTelephone(tel).build();
        boolean flg = userService.updateById(newUser);
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
