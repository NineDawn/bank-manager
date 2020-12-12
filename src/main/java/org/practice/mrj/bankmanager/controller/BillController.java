package org.practice.mrj.bankmanager.controller;

import org.practice.mrj.bankmanager.common.constant.CommonConstant;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.dto.BillDTO;
import org.practice.mrj.bankmanager.domain.mapper.BillEntityMapper;
import org.practice.mrj.bankmanager.response.Response;
import org.practice.mrj.bankmanager.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName: BillController
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:34
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/bank/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/queryBills",method = RequestMethod.GET)
    @ResponseBody
    public Response queryBills(HttpSession session){

        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);

        List<BillDTO> billDTOList = billService.queryBills(accountDTO.getId());

        return Response.success(BillEntityMapper.INSTANCE.billDtoList2VoList(billDTOList));

    }




}
