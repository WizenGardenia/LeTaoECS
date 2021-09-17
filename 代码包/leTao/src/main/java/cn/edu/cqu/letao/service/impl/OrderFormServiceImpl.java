package cn.edu.cqu.letao.service.impl;

import cn.edu.cqu.letao.entity.OrderForm;
import cn.edu.cqu.letao.entity.vo.OrdersVO;
import cn.edu.cqu.letao.entity.vo.sellerOrderVO;
import cn.edu.cqu.letao.mapper.OrderFormMapper;
import cn.edu.cqu.letao.service.IOrderFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ORDER_FORM 服务实现类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormMapper, OrderForm> implements IOrderFormService {

    @Resource
    private OrderFormMapper orderFormMapper;

    @Override
    public OrderForm getShopId(Integer cmdty_details_ID) {
        OrderForm orderForm = orderFormMapper.getShopId(cmdty_details_ID);
        return  orderForm;
    }

    @Override
    public List<OrdersVO> showOrders(Integer userId) {
        List<OrdersVO> ordersVOS = orderFormMapper.showOrders(userId);
        return  ordersVOS;
    }

    @Override
    public List<OrdersVO> orderState(Integer userId) {
        List<OrdersVO> ordersVOS = orderFormMapper.orderState(userId);
        return  ordersVOS;
    }
    @Override
    public List<sellerOrderVO> sellerOrder(Integer shopID) {

        List<sellerOrderVO> sellerOrderVOS = orderFormMapper.sellerOrder(shopID);
        return sellerOrderVOS;
    }
}
