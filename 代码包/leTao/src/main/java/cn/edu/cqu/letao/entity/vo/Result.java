package cn.edu.cqu.letao.entity.vo;

import cn.edu.cqu.letao.entity.Buyer;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {
    private String code; //返回码
    private String msg;
    private Buyer data;
}
