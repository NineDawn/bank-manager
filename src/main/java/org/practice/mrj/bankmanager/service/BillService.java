package org.practice.mrj.bankmanager.service;

import org.practice.mrj.bankmanager.domain.dto.BillDTO;

import java.util.List;

/**
 * InterfaceName: BillService
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:30
 * @Version: 1.0
 */
public interface BillService {


    List<BillDTO> queryBills(Long id);



}
