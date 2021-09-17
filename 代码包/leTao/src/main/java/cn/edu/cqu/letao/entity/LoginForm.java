package cn.edu.cqu.letao.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginForm implements Serializable {
  private String username;
  private String password;
  private int verification;
  private int randomVerification;
}
