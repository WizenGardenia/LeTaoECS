package cn.edu.cqu.letao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * USER
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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_ID", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_username")
    private String userUsername;

    @TableField("user_password")
    private String userPassword;

    @TableField("user_type")
    private Integer userType;

    @TableField("user_state")
    private Boolean userState;

    @TableField("user_nickname")
    private String userNickname;

    @TableField("user_telephone")
    private String userTelephone;

    @TableField("user_account")
    private Float userAccount;

    @TableField("user_address")
    private String userAddress;

    @TableField("user_perference")
    private String userPerference;


}
