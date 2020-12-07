package org.practice.mrj.bankmanager.interceptor;

import org.practice.mrj.bankmanager.common.constant.CommonConstant;
import org.practice.mrj.bankmanager.common.enums.ErrorCodeEnums;
import org.practice.mrj.bankmanager.common.exception.BankException;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName: AuthInterceptor
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/4 22:26
 * @Version: 1.0
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO)session.getAttribute(CommonConstant.ACCOUNT_SESSION_KEY);
        if (accountDTO == null){
            throw new BankException(ErrorCodeEnums.USER_NOT_LOGIN);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
