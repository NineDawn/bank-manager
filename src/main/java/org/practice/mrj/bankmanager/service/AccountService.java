package org.practice.mrj.bankmanager.service;

import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.entity.AccountDO;
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

    /**
     * 获取新卡的卡号，信用额度，有效期
     * @return AccountVO
     */
    AccountVO getNewCard();

    /**
     * 新增帐号
     * @param accountDTO 新增内容
     */
    void addAccount(AccountDTO accountDTO);


    /**
     * 登录
     * @param loginParam 卡号and密码
     * @return 用户信息
     */
    AccountDTO getAccountByCardIdAndPassword(LoginParam loginParam);

    AccountDTO getAccountBalance(Long id);

    void withdraw(AccountDTO accountDTO);

    void deposit(AccountDTO accountDTO);

    void transfer(AccountDTO accountDTO);

    void changePassword(Long id,String newPassword);

}
