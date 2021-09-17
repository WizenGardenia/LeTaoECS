package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * CMDTY_DETAILS
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
public class CmdtyDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cmdty_details_ID", type = IdType.AUTO)
    private Integer cmdtyDetailsId;

    @TableField("cmdty_ID")
    private Integer cmdtyId;

    @TableField("cmdty_price")
    private Float cmdtyPrice;

    @TableField("cmdty_volume")
    private Integer cmdtyVolume;

    @TableField("cmdty_stock")
    private Integer cmdtyStock;

    @TableField("cmdty_prmt")
    private String cmdtyPrmt;


}
