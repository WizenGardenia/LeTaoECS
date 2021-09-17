package cn.edu.cqu.letao.entity.vo;


import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class sellerOrderVO {

    private static final long serialVersionUID = 1L;
    private Integer orderID;
    private String userAddress;
    private boolean orderState;
    private String logState;
    private Integer cmdtyDetailsID;
    private Integer cmdtyNum;
    private LocalDate cmdtyDate;
    private Float cmdtyDetails;

}
