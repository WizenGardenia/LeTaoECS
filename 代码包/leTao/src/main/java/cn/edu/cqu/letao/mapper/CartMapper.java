package cn.edu.cqu.letao.mapper;

import cn.edu.cqu.letao.entity.Cart;
import cn.edu.cqu.letao.entity.CartCommodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * CART Mapper 接口
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
public interface CartMapper extends BaseMapper<Cart> {

//    void addCommodity(int user_ID, int cmdty_ID, int number);
//
//    void deleteCommodity(int cart_ID);
//
//    Cart showInformation(int cart_ID);
//
//    Cart isCartIDExist(int user_ID, int cmdty_ID);
//
//    int getID(int user_ID, int cmdty_ID);

    Cart getCartInfo(Integer user_ID,Integer cmdty_ID);
    List<CartCommodity> cartCmdty(Integer user_ID, Integer cmdty_ID);
    List<CartCommodity> cartCmdties(Integer user_ID);
    Integer getCartId (Integer user_ID, Integer cmdty_ID);
}
