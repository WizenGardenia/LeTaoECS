package cn.edu.cqu.letao.service.impl;


import cn.edu.cqu.letao.entity.Cart;
import cn.edu.cqu.letao.entity.CartCommodity;
import cn.edu.cqu.letao.mapper.CartMapper;
import cn.edu.cqu.letao.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * CART 服务实现类
 * </p>
 *
 * @author just
 * @since 2021-07-17
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    @Resource
    private CartMapper cartMapper;


//    @Override
//    public void addCommodity(int user_ID, int cmdty_ID, int number){
//        cartMapper.addCommodity(user_ID, cmdty_ID, number);
//    }
//
//
//    @Override
//    public boolean deleteCommodity(int cart_ID){
//        Cart cart = cartMapper.showInformation(cart_ID);
//        if(cart == null) {
//            return false;
//        } else {
//            cartMapper.deleteCommodity(cart_ID);
//            return true;
//        }
//    }
//
//
//    @Override
//    public Cart showInformation(int cart_ID){
//        return cartMapper.showInformation(cart_ID);
//    }
//
//
//    @Override
//    public boolean isCartIDExist(int user_ID, int cmdty_ID){
//        Cart cart = cartMapper.isCartIDExist(user_ID, cmdty_ID);
//        return (cart != null);
//    }
//
//
//    @Override
//    public int getID(int user_ID, int cmdty_ID){
//        if(!isCartIDExist(user_ID, cmdty_ID)){
//            return -1;
//        }
//        return cartMapper.getID(user_ID, cmdty_ID);
//    }
//
//
//    @Override
//    public Cart order(int cart_ID){
//        return cartMapper.showInformation(cart_ID);
//    }

    @Override
    public Cart getCartInfo(Integer user_ID,Integer cmdty_ID) {
        Cart cart = cartMapper.getCartInfo(user_ID,cmdty_ID);
        return  cart;
    }

    @Override
    public  List<CartCommodity> cartCmdty(Integer user_ID, Integer cmdty_ID) {
       List<CartCommodity> cartCommodity = cartMapper.cartCmdty(user_ID,cmdty_ID);
        return cartCommodity;
    }

    @Override
    public List<CartCommodity> cartCmdties(Integer user_ID) {
        List<CartCommodity> cartCommodities = cartMapper.cartCmdties(user_ID);
        return cartCommodities;
    }

    @Override
    public Integer getCartId(Integer user_ID, Integer cmdty_ID) {
        Integer cartId = cartMapper.getCartId(user_ID, cmdty_ID);
        return cartId;
    }


}
