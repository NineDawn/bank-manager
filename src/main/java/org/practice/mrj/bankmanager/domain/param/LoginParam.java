package org.practice.mrj.bankmanager.domain.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName: LoginParam
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 19:55
 * @Version: 1.0
 */
@Data
public class LoginParam {

    @NotNull
    private String cardId;

    @NotNull
    private String password;

}
