package cn.edu.cqu.letao.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartCommodity implements Serializable {
    private String cmdtyName;
    private String cmdtyPrev;
    private String cmdtyDetails;
    private Integer cmdtyNum;
    private Integer cmdtyId;
    private Integer maxNum=10;
    private boolean check=false;
    private Integer cartId;
}