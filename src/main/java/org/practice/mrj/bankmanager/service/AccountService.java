package org.practice.mrj.bankmanager.service;

import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.param.LoginParam;

/**
 * InterfaceName: AccountService
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:30
 * @Version: 1.0
 */
public interface AccountService {


    String getNewCardId();

    void addAccount(AccountDTO accountDTO);

    AccountDTO getAccountByCardIdAndPassword(LoginParam loginParam);

}
