package cn.edu.cqu.letao.service;

import cn.edu.cqu.letao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * USER 服务类
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
public interface IUserService extends IService<User> {

    int register(String username, String password, int user_type, int verification, int randomVerification);

    int login(String username, String password, int verification, int randomVerification);

    User showInformation(String username);

    boolean isUsernameExist(String username);

    int getID(String username);

    String getPassword(String username);

    int getType(String username);

    int verify();

    int changeNickname(String username, String password, String newNickname);

    int changePassword(String username, String password, String newPassword);

    int changeTelephone(String username, String password, String newTelephone);

    int changeAddress(String username, String password, String newAddress);

}
