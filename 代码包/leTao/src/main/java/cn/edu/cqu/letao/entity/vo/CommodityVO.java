package cn.edu.cqu.letao.entity.vo;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cmdtyName;
    private String cmdtyDetails;
    private Integer cmdtyDetailsId;
    private Float cmdtyPrice;
    private Integer cmdtyVolume;
    private Integer cmdtyStock;
    private String cmdtyPrmt;
    private String cmdtyPrev;

}
