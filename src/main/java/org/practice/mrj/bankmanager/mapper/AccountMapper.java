package org.practice.mrj.bankmanager.mapper;

import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
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

    /**
     * 新增账户
     * @param accountDO 账户内容
     */
    void insertAccount(AccountDO accountDO);

    /**
     * 登录接口
     * @param loginParam 登录参数
     * @return 账户内容
     */
    AccountDO getAccountByCardIdAndPassword(LoginParam loginParam);

    /**
     * 获取帐号余额
     * @param id 用户id
     * @return 余额and信用额度
     */
    AccountDO getAccountBalance(Long id);

    /**
     * 更新余额
     * @param accountDO 用户id和余额
     */
    void updateAccountBalance(AccountDO accountDO);

    /**
     * 根据cardId获取用户信息
     * @param cardId 卡号
     * @return 用户内容
     */
    AccountDO getAccountByCardId(String cardId);

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    AccountDO getAccountById(Long id);

}
