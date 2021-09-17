package cn.edu.cqu.letao.service;

import cn.edu.cqu.letao.entity.Cart;
import cn.edu.cqu.letao.entity.CartCommodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * CART 服务类
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
public interface ICartService extends IService<Cart> {

//    void addCommodity(int user_ID, int cmdty_ID, int number);
//
//    boolean deleteCommodity(int cart_ID);
//
//    Cart showInformation(int cart_ID);
//
//    boolean isCartIDExist(int user_ID, int cmdty_ID);
//
//    int getID(int user_ID, int cmdty_ID);
//
//    Cart order(int cart_ID);

    Cart getCartInfo(Integer user_ID, Integer cmdty_ID);

    List<CartCommodity> cartCmdty(Integer user_ID, Integer cmdty_ID);

    List<CartCommodity> cartCmdties(Integer user_ID);

    Integer getCartId (Integer user_ID, Integer cmdty_ID);
}
