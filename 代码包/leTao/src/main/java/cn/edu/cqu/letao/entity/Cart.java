package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * CART
 * </p>
 *
 * @author just
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cart_ID", type = IdType.AUTO)
    private Integer cartId;

    @TableField("user_ID")
    private Integer userId;

    @TableField("cmdty_ID")
    private Integer cmdtyId;

    @TableField("cmdty_num")
    private Integer cmdtyNum;


}
