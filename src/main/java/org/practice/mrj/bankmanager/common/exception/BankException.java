package org.practice.mrj.bankmanager.common.exception;


import org.practice.mrj.bankmanager.common.enums.ErrorCodeEnums;

/**
 * ClassName: BankException
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:43
 * @Version: 1.0
 */
public class BankException extends RuntimeException{
    protected int code;
    protected String msg;

    public BankException(){
        this.code = ErrorCodeEnums.SERVER_INTERVAL_EXCEPTION.getCode();
        this.msg = ErrorCodeEnums.SERVER_INTERVAL_EXCEPTION.getMsg();
    }

    public BankException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public BankException(int code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public BankException(IexceptionCode exception) {
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String getMessage() {
        return super.getMessage() == null ? this.toString() : msg;
    }

    @Override
    public String toString() {
        return "BankException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

}
