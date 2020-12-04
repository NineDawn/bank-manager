package org.practice.mrj.bankmanager.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.practice.mrj.bankmanager.common.exception.BankException;


import java.io.Serializable;

/**
 * ClassName: Response
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:48
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6724401478874316373L;

    private static final int SUCCESS_CODE = 200;
    private static final int FAILED_CODE = 400;
    private static final String SUCCESS_MESSAGE = "请求成功";
    private static final String FAILED_MESSAGE = "请求异常";

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static <T> Response<T> success(String msg, T data) {
        return Response.<T>builder()
                .code(SUCCESS_CODE)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> Response<T> success() {
        return Response.<T>builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_MESSAGE)
                .build();
    }

    public static <T> Response<T> fail(BankException e) {
        return Response.<T>builder()
                .code(e.getCode())
                .msg(e.getMsg())
                .build();
    }

    public static <T> Response<T> fail(BankException e, T data) {
        return Response.<T>builder()
                .code(e.getCode())
                .msg(e.getMsg())
                .data(data)
                .build();
    }

    public static <T> Response<T> fail() {
        return Response.<T>builder()
                .code(FAILED_CODE)
                .msg(FAILED_MESSAGE)
                .build();
    }

    public static <T> Response<T> fail(Integer code, String msg) {
        return Response.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }


    public static <T> Response<T> fail(Integer code, String msg, T data) {
        return Response.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> Response<T> fail(Response<T> source) {
        return Response.<T>builder()
                .code(source.getCode())
                .msg(source.getMsg())
                .build();
    }

}
