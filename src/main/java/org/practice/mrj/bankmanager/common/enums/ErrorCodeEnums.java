package org.practice.mrj.bankmanager.common.enums;

import org.practice.mrj.bankmanager.common.exception.IexceptionCode;

/**
 * EnumName: ErrorCodeEnums
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:48
 * @Version: 1.0
 */
public enum ErrorCodeEnums implements IexceptionCode {

    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(1000,"用户名或密码错误!"),
    /**
     * 参数异常
     */
    PARAM(1001, "参数异常"),
    /**
     * 服务器内部错误
     */
    SERVER_INTERVAL_EXCEPTION(1002, "内部服务异常"),
    /**
     * 系统繁忙
     */
    SYSTEM_BUSY(1003, "系统繁忙！"),
    /**
     * 鉴权无权限
     */
    AUTH_FAIL(403, "无权限"),
    /**
     * 参数不能为空
     */
    PARAM_CAN_NOT_BE_NULL(1004, "参数不能为空"),
    /**
     * 已过期
     */
    CARD_EXPIRED(1005,"银行卡已过期!"),
    /**
     * 用户未登录
     */
    USER_NOT_LOGIN(10000,"用户未登录!"),

    BALANCE_NOT_ENOUGH(1006,"余额不足!"),

    CARD_ID_NOT_EXIST(1007,"卡号不存在!"),
    ;

    private int code;
    private String msg;

    ErrorCodeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
