package org.practice.mrj.bankmanager.controller;

import org.practice.mrj.bankmanager.common.constant.CommonConstant;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.mapper.AccountEntityMapper;
import org.practice.mrj.bankmanager.domain.param.AccountParam;
import org.practice.mrj.bankmanager.domain.param.LoginParam;
import org.practice.mrj.bankmanager.domain.vo.AccountVO;
import org.practice.mrj.bankmanager.response.Response;
import org.practice.mrj.bankmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * ClassName: AccountController
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:32
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/bank/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody @Valid LoginParam loginParam, HttpSession session){

        AccountDTO account = accountService.getAccountByCardIdAndPassword(loginParam);

        session.setAttribute(CommonConstant.ACCOUNT_SESSION_KEY,account);
        session.setMaxInactiveInterval(7200);
        AccountVO accountVO = new AccountVO();
        accountVO.setId(account.getId());
        accountVO.setCardId(account.getCardId());
        accountVO.setType(account.getType());
        accountVO.setUsername(account.getUsername());
        return Response.success(accountVO);
    }

    @RequestMapping(value = "/getNewCard",method = RequestMethod.GET)
    @ResponseBody
    public Response getNewCard(){

        AccountVO newCard = accountService.getNewCard();
        return Response.success(newCard);
    }

    @RequestMapping(value = "/addAccount",method = RequestMethod.POST)
    @ResponseBody
    public Response addAccount(@RequestBody @Valid AccountParam accountParam){
        AccountDTO accountDTO = AccountEntityMapper.INSTANCE.accountParam2Dto(accountParam);
        accountDTO.setAccountBalance(0.0);
        accountService.addAccount(accountDTO);
        return Response.success(true);
    }

    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    @ResponseBody
    public Response resetPassword(@RequestBody AccountParam accountParam,HttpSession session){

        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        accountService.changePassword(accountDTO.getId(),accountParam.getNewPassword());
        session.removeAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        return Response.success(true);

    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public Response logout(HttpSession session){
        session.removeAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        return Response.success(true);
    }

    @RequestMapping(value = "/getAccountBalance",method = RequestMethod.GET)
    @ResponseBody
    public Response getAccountBalance(HttpSession session){

        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        AccountDTO res = accountService.getAccountBalance(accountDTO.getId());
        return Response.success(AccountEntityMapper.INSTANCE.accountDto2Vo(res));
    }


    @RequestMapping(value = "/withdraw",method = RequestMethod.POST)
    @ResponseBody
    public Response withdraw(@RequestBody AccountParam accountParam,HttpSession session){
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        accountParam.setId(accountDTO.getId());
        accountService.withdraw(AccountEntityMapper.INSTANCE.accountParam2Dto(accountParam));
        return Response.success(true);
    }

    @RequestMapping(value = "/deposit",method = RequestMethod.POST)
    @ResponseBody
    public Response deposit(@RequestBody AccountParam accountParam,HttpSession session){
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        accountParam.setId(accountDTO.getId());
        accountService.deposit(AccountEntityMapper.INSTANCE.accountParam2Dto(accountParam));
        return Response.success(true);
    }

    @RequestMapping(value = "/transfer",method = RequestMethod.POST)
    @ResponseBody
    public Response transfer(@RequestBody AccountParam accountParam,HttpSession session){
        AccountDTO accountDTO = (AccountDTO) session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        accountParam.setId(accountDTO.getId());
        accountService.transfer(AccountEntityMapper.INSTANCE.accountParam2Dto(accountParam));
        return Response.success(true);
    }

}
