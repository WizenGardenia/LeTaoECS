package cn.edu.cqu.letao.entity.vo;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultBean<T> {
    private String code; //返回码
    private String msg;
    private List<T> data;
    private Integer total;
}


