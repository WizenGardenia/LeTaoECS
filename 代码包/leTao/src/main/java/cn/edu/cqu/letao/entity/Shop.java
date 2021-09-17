package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * SHOP
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
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "shop_ID", type = IdType.AUTO)
    private Integer shopId;

    @TableField("user_ID")
    private Integer userId;

    @TableField("shop_name")
    private String shopName;


}
