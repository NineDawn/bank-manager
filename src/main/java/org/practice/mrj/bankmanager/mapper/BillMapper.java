package org.practice.mrj.bankmanager.mapper;

import org.practice.mrj.bankmanager.domain.entity.BillDO;

import java.util.List;
import java.util.Map;

/**
 * InterfaceName: BillMapper
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:29
 * @Version: 1.0
 */
public interface BillMapper {

    /**
     * 查询账单信息
     * @param cardId 卡号
     * @return
     */
    List<BillDO> queryBills(String cardId);

    /**
     * 插入账单
     * @param billDO 账单内容
     */
    void insertBill(BillDO billDO);

}
