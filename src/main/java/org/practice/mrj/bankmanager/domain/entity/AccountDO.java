package org.practice.mrj.bankmanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * ClassName: AccountDO
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:20
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO extends BaseDO{

    /**
     * 姓名
     */
    private String username;

    /**
     * 身份证号
     */
    private String identify;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 地址
     */
    private String address;

    /**
     * 卡号
     */
    private String cardId;

    /**
     * 帐户余额
     */
    private Double accountBalance;

    /**
     * 密码
     */
    private String password;

    /**
     * 类型
     */
    private String type;

    /**
     * 透支额度
     */
    private Double creditLimit;

    /**
     * 有效期
     */
    private Date effectiveDate;

}
