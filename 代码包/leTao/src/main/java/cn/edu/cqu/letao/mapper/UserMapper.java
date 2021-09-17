package cn.edu.cqu.letao.mapper;

import cn.edu.cqu.letao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * USER Mapper 接口
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface UserMapper extends BaseMapper<User> {

    void register(String username, String password, int user_type);

    User showInformation(String username);

    User isUsernameExist(String username);

    int getID(String username);

    String getPassword(String username);

    int getType(String username);

    void changeNickname(String username, String nickname);

    void changePassword(String username, String newPassword);

    void changeTelephone(String username, String newTelephone);

    void changeAddress(String username, String newAddress);
}
