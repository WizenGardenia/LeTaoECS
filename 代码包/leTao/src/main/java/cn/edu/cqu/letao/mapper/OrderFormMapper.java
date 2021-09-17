package cn.edu.cqu.letao.mapper;

import cn.edu.cqu.letao.entity.OrderForm;
import cn.edu.cqu.letao.entity.vo.OrdersVO;
import cn.edu.cqu.letao.entity.vo.sellerOrderVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * ORDER_FORM Mapper 接口
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface OrderFormMapper extends BaseMapper<OrderForm> {


    OrderForm getShopId(Integer cmdty_details_id);
    List<OrdersVO> showOrders(Integer userId);
    List<OrdersVO> orderState(Integer userId);
    List<sellerOrderVO> sellerOrder(Integer shopID);
}
