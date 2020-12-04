package org.practice.mrj.bankmanager.service;

import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.param.LoginParam;
import org.practice.mrj.bankmanager.domain.vo.AccountVO;

/**
 * InterfaceName: AccountService
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:30
 * @Version: 1.0
 */
public interface AccountService {


    AccountVO getNewCard();

    void addAccount(AccountDTO accountDTO);

    AccountDTO getAccountByCardIdAndPassword(LoginParam loginParam);

}
