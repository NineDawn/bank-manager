package org.practice.mrj.bankmanager.domain.param;

import lombok.Data;

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
    private String effectiveDate;

}
