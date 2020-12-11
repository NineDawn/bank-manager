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

    List<BillDO> queryBills(Map<String,Object> params);

}
