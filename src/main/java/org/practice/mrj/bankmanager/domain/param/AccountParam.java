package org.practice.mrj.bankmanager.domain.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * ClassName: AccountParam
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 20:14
 * @Version: 1.0
 */
@Data
public class AccountParam {

    private Long id;

    /**
     * 姓名
     */
    @NotBlank
    private String username;

    /**
     * 身份证号
     */
    @NotBlank
    private String identify;

    /**
     * 手机号
     */
    @NotBlank
    private String mobile;

    /**
     * 地址
     */
    @NotBlank
    private String address;

    /**
     * 卡号
     */
    @NotBlank
    private String cardId;


    /**
     * 密码
     */
    @NotBlank
    private String password;

    /**
     * 类型
     */
    @NotBlank
    private String type;

    /**
     * 透支额度
     */
    @NotNull
    private Double creditLimit;

    /**
     * 有效期
     */
    @NotBlank
    private String effectiveDate;

}
