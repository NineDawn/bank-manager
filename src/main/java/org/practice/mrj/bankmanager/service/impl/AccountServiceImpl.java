package org.practice.mrj.bankmanager.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import org.practice.mrj.bankmanager.common.constant.CommonConstant;
import org.practice.mrj.bankmanager.common.enums.CardTypeEnums;
import org.practice.mrj.bankmanager.common.enums.ErrorCodeEnums;
import org.practice.mrj.bankmanager.common.exception.BankException;
import org.practice.mrj.bankmanager.common.util.CardIdGeneratorUtil;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.entity.AccountDO;
import org.practice.mrj.bankmanager.domain.entity.BillDO;
import org.practice.mrj.bankmanager.domain.mapper.AccountEntityMapper;
import org.practice.mrj.bankmanager.domain.param.LoginParam;
import org.practice.mrj.bankmanager.domain.vo.AccountVO;
import org.practice.mrj.bankmanager.mapper.AccountMapper;
import org.practice.mrj.bankmanager.mapper.BillMapper;
import org.practice.mrj.bankmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * ClassName: AccountServiceImpl
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:30
 * @Version: 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BillMapper billMapper;

    @Override
    public AccountVO getNewCard() {

        Date effectiveDate = DateUtil.offsetMonth(new Date(),240).toJdkDate();

        return AccountVO.builder()
                .cardId(CardIdGeneratorUtil.getCardId())
                .effectiveDate(DateUtil.format(effectiveDate,"yyyy-MM-dd"))
                .creditLimit(10000.0)
                .build();
    }

    @Override
    public void addAccount(AccountDTO accountDTO) {

        accountDTO.setPassword(SecureUtil.md5(accountDTO.getPassword()));
        accountMapper.insertAccount(AccountEntityMapper.INSTANCE.accountDto2Do(accountDTO));

    }

    @Override
    public AccountDTO getAccountByCardIdAndPassword(LoginParam loginParam) {
        loginParam.setPassword(SecureUtil.md5(loginParam.getPassword()));
        AccountDO account = accountMapper.getAccountByCardIdAndPassword(loginParam);

        if (account ==null){
            throw new BankException(ErrorCodeEnums.USERNAME_OR_PASSWORD_ERROR);
        }
        Date effectiveDate = account.getEffectiveDate();
        if (effectiveDate.compareTo(new Date())<0){
            throw new BankException(ErrorCodeEnums.CARD_EXPIRED);
        }
        return AccountEntityMapper.INSTANCE.accountDo2Dto(account);
    }

    @Override
    public AccountDTO getAccountBalance(Long id) {

        AccountDO accountDO = accountMapper.getAccountBalance(id);

        return AccountEntityMapper.INSTANCE.accountDo2Dto(accountDO);
    }

    @Override
    @Transactional(rollbackFor = {Error.class,Exception.class},isolation = Isolation.DEFAULT)
    public void withdraw(AccountDTO accountDTO) {
        AccountDO account = accountMapper.getAccountById(accountDTO.getId());
        String type = account.getType();
        Double balance = account.getAccountBalance();
        if (type.equals(CardTypeEnums.CREDIT_CARD.getDesc())){
            if (balance-accountDTO.getAmount()<(0-account.getCreditLimit())){
                throw new BankException(ErrorCodeEnums.BALANCE_NOT_ENOUGH);
            }
        }else {
            if (balance-accountDTO.getAmount()<0){
                throw new BankException(ErrorCodeEnums.BALANCE_NOT_ENOUGH);
            }
        }
        AccountDO accountDO = new AccountDO();
        accountDO.setId(accountDTO.getId());
        accountDO.setAccountBalance(balance-accountDTO.getAmount());
        accountMapper.updateAccountBalance(accountDO);

        BillDO billDO = generateBill(CommonConstant.WITHDRAW,accountDTO.getAmount(), account.getCardId());
        billMapper.insertBill(billDO);

    }

    @Override
    @Transactional(rollbackFor = {Error.class,Exception.class},isolation = Isolation.DEFAULT)
    public void deposit(AccountDTO accountDTO) {
        AccountDO account = accountMapper.getAccountById(accountDTO.getId());
        Double balance = account.getAccountBalance();
        AccountDO accountDO = AccountDO.builder()
                .id(accountDTO.getId())
                .accountBalance(balance + accountDTO.getAmount())
                .build();
        accountMapper.updateAccountBalance(accountDO);

        BillDO billDO = generateBill(CommonConstant.DEPOSIT,accountDTO.getAmount(), account.getCardId());
        billMapper.insertBill(billDO);
    }

    @Override
    @Transactional(rollbackFor = {Error.class,Exception.class},isolation = Isolation.DEFAULT)
    public void transfer(AccountDTO accountDTO) {

        AccountDO sourceAccount = accountMapper.getAccountById(accountDTO.getId());
        String type = sourceAccount.getType();
        Double sourceBalance = sourceAccount.getAccountBalance();
        if (type.equals(CardTypeEnums.CREDIT_CARD.getDesc())){
            if (sourceBalance-accountDTO.getAmount()<(0-sourceAccount.getCreditLimit())){
                throw new BankException(ErrorCodeEnums.BALANCE_NOT_ENOUGH);
            }
        }
        else if (type.equals(CardTypeEnums.DEBIT_CARD.getDesc())){
            if (sourceBalance-accountDTO.getAmount()<0){
                throw new BankException(ErrorCodeEnums.BALANCE_NOT_ENOUGH);
            }
        }
        AccountDO targetAccountDO = accountMapper.getAccountByCardId(accountDTO.getCardId());
        if (targetAccountDO == null){
            throw new BankException(ErrorCodeEnums.CARD_ID_NOT_EXIST);
        }
        targetAccountDO.setAccountBalance(targetAccountDO.getAccountBalance() + accountDTO.getAmount());
        accountMapper.updateAccountBalance(targetAccountDO);
        AccountDO sourceAccountDO = new AccountDO();
        sourceAccountDO.setAccountBalance(sourceBalance - accountDTO.getAmount());
        sourceAccountDO.setId(accountDTO.getId());
        accountMapper.updateAccountBalance(sourceAccountDO);

        BillDO billDO = generateBill(CommonConstant.TRANSFER,accountDTO.getAmount(), sourceAccount.getCardId());
        billMapper.insertBill(billDO);

    }


    private BillDO generateBill(String affairType,Double tradeBalance,String cardId){

        return BillDO.builder()
                .affairType(affairType)
                .cardId(cardId)
                .tradeBalance(tradeBalance)
                .tradeTime(new Date())
                .build();
    }




}
