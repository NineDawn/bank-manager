package org.practice.mrj.bankmanager.service.impl;

import org.practice.mrj.bankmanager.common.constant.CommonConstant;
import org.practice.mrj.bankmanager.domain.dto.BillDTO;
import org.practice.mrj.bankmanager.domain.entity.AccountDO;
import org.practice.mrj.bankmanager.domain.entity.BillDO;
import org.practice.mrj.bankmanager.domain.mapper.BillEntityMapper;
import org.practice.mrj.bankmanager.mapper.AccountMapper;
import org.practice.mrj.bankmanager.mapper.BillMapper;
import org.practice.mrj.bankmanager.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BillServiceImpl
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:31
 * @Version: 1.0
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<BillDTO> queryBills(Long id) {
        AccountDO account = accountMapper.getAccountById(id);
        List<BillDO> billDOList = billMapper.queryBills(account.getCardId());
        if (billDOList == null){
            billDOList = new ArrayList<>();
        }
        int len = billDOList.size();
        if (len != CommonConstant.BILL_LIST_SIZE){
            for (int i = 0; i < CommonConstant.BILL_LIST_SIZE - len; i++) {
                billDOList.add(BillDO.builder().affairType("").cardId("").tradeBalance(null).tradeTime(null).build());
            }
        }

        return BillEntityMapper.INSTANCE.billDoList2DtoList(billDOList);
    }
}
