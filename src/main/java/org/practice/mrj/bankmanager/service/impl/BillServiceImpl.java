package org.practice.mrj.bankmanager.service.impl;

import org.practice.mrj.bankmanager.domain.dto.BillDTO;
import org.practice.mrj.bankmanager.service.BillService;
import org.springframework.stereotype.Service;

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
    @Override
    public List<BillDTO> queryBills(String cardId) {
        return null;
    }
}
