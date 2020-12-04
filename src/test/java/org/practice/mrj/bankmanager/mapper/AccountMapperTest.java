package org.practice.mrj.bankmanager.mapper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import org.junit.Test;
import org.practice.mrj.bankmanager.BaseTest;
import org.practice.mrj.bankmanager.domain.entity.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * ClassName: AccountMapperTest
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 18:27
 * @Version: 1.0
 */
public class AccountMapperTest extends BaseTest {


    @Autowired
    private AccountMapper accountMapper;


    @Test
    public void testInsertAccount(){
        AccountDO accountDO = new AccountDO();

        accountDO.setUsername("郑云鹤");
        accountDO.setPassword(SecureUtil.md5("123456"));
        accountDO.setCardId("1111222233334444");
        accountDO.setAddress("沈阳市");
        accountDO.setIdentify("21010619981212031X");
        accountDO.setMobile("18640018707");
        accountDO.setType("信用卡");
        accountDO.setCreditLimit(5000.0);
        accountDO.setAccountBalance(0.0);
        accountDO.setEffectiveDate(DateUtil.offsetMonth(new Date(),240).toJdkDate());
        accountMapper.insertAccount(accountDO);
    }


}
