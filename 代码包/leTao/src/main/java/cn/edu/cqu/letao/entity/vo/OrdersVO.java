package cn.edu.cqu.letao.entity.vo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cmdtyName;
    private String cmdtyPrev;
    private Float cmdtyPrice;
    private String cmdtyPrmt;
    private String shopName;
    private String logState;
    private Integer cmdtyNum;
    private LocalDate cmdtyDate;
}
