package org.practice.mrj.bankmanager.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: BillVO
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/12 10:23
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillVO implements Serializable {

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
    private String tradeTime;

    /**
     * 交易金额
     */
    private Double tradeBalance;

}
