package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * CMDTY
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
public class Cmdty implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cmdty_ID", type = IdType.AUTO)
    private Integer cmdtyId;

    @TableField("cmdty_name")
    private String cmdtyName;

    @TableField("shop_ID")
    private Integer shopId;

    @TableField("cmdty_type")
    private String cmdtyType;

    @TableField("cmdty_prev")
    private String cmdtyPrev;

    @TableField("cmdty_details")
    private String cmdtyDetails;


}
