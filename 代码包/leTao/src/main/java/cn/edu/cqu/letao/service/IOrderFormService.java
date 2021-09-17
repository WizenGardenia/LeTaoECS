package cn.edu.cqu.letao.service;

import cn.edu.cqu.letao.entity.OrderForm;
import cn.edu.cqu.letao.entity.vo.OrdersVO;
import cn.edu.cqu.letao.entity.vo.sellerOrderVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * ORDER_FORM 服务类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface IOrderFormService extends IService<OrderForm> {

    OrderForm getShopId (Integer cmdty_details_ID);
    List<OrdersVO> showOrders(Integer userId);
    List<OrdersVO> orderState(Integer userId);
    List<sellerOrderVO> sellerOrder(Integer shopID);
}
