package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * ORDER_FORM
 * </p>
 *
 * @author just
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_ID", type = IdType.AUTO)
    private Integer orderId;

    @TableField("user_ID")
    private Integer userId;

    @TableField("shop_ID")
    private Integer shopId;

    @TableField("order_state")
    private Boolean orderState;

    @TableField("log_state")
    private String logState;

    @TableField("cmdty_details_ID")
    private Integer cmdtyDetailsId;

    @TableField("cmdty_num")
    private Integer cmdtyNum;

    @TableField("cmdty_date")
    private LocalDate cmdtyDate;


}
