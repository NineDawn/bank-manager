package org.practice.mrj.bankmanager.mapper;

import org.practice.mrj.bankmanager.domain.entity.AccountDO;
import org.practice.mrj.bankmanager.domain.param.LoginParam;

/**
 * InterfaceName: AccountMapper
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:27
 * @Version: 1.0
 */
public interface AccountMapper {

    void insertAccount(AccountDO accountDO);

    AccountDO getAccountByCardIdAndPassword(LoginParam loginParam);

}
