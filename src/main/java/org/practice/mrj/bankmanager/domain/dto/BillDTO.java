package org.practice.mrj.bankmanager.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: BillDTO
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 19:08
 * @Version: 1.0
 */
@Data
public class BillDTO {

    private Long id;

    /**
     * 卡号
     */
    private String cardId;

    /**
     * 交易类型
     */
    private String affairType;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 交易金额
     */
    private Double tradeBalance;

}
