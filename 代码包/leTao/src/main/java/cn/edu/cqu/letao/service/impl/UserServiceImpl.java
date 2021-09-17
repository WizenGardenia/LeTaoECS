package cn.edu.cqu.letao.service.impl;

import cn.edu.cqu.letao.entity.User;
import cn.edu.cqu.letao.mapper.UserMapper;
import cn.edu.cqu.letao.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * USER 服务实现类
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private  UserMapper userMapper;


    @Override
    public int register(String username, String password, int user_type, int verification, int randomVerification){
        if(verification != randomVerification){
            System.out.println("验证码错误！");
            return 0;
        }
        if(isUsernameExist(username)) {
            System.out.println("用户名已存在！");
            return 0;
        }
        userMapper.register(username, password, user_type);
        return 1;
    }




    @Override
    public int login(String username, String password, int verification, int randomVerification) {
        System.err.println("login执行了。。。。。。。。。。。。。。。");
        if(!isUsernameExist(username)) {
            System.out.println("用户名不存在！");
            return 4;
        }
        if(!password.equals(getPassword(username))){
            System.out.println("密码错误！");
            return 5;
        }
        if(verification != randomVerification){
            System.out.println("验证码错误！");
            return 6;
        }
        System.out.println("登录成功！");
        System.err.println("111111111111111");
        int type = getType(username);
        System.err.println("type------------>"+type);
        return type;
    }


    @Override
    public User showInformation(String username){
        return userMapper.showInformation(username);
    }


    @Override
    public boolean isUsernameExist(String username) {
        User user = userMapper.isUsernameExist(username);
        return (user != null);
    }


    @Override
    public int getID(String username){
        return userMapper.getID(username);
    }


    @Override
    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }


    @Override
    public int getType(String username){
        return userMapper.getType(username);
    }


    @Override
    public int verify(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    @Override
    public int changeNickname(String username, String password, String newNickname){
        String truePassword = getPassword(username);
        if(password.equals(truePassword)){
            userMapper.changeNickname(username, newNickname);
            System.out.println("修改成功！");
            return 1;
        } else {
            System.out.println("修改失败！");
            return 0;
        }
    }


    @Override
    public int changePassword(String username, String password, String newPassword){
        String truePassword = getPassword(username);
        if(password.equals(truePassword)){
            userMapper.changePassword(username, newPassword);
            System.out.println("修改成功！");
            return 1;
        } else {
            System.out.println("修改失败！");
            return 0;
        }
    }


    @Override
    public int changeTelephone(String username, String password, String newTelephone){
        String truePassword = getPassword(username);
        if(password.equals(truePassword)){
            userMapper.changeTelephone(username, newTelephone);
            System.out.println("修改成功！");
            return 1;
        } else {
            System.out.println("修改失败！");
            return 0;
        }
    }


    @Override
    public int changeAddress(String username, String password, String newAddress){
        String truePassword = getPassword(username);
        if(password.equals(truePassword)){
            userMapper.changeAddress(username, newAddress);
            System.out.println("修改成功！");
            return 1;
        } else {
            System.out.println("修改失败！");
            return 0;
        }
    }
}
