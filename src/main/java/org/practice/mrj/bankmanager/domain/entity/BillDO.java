package org.practice.mrj.bankmanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * ClassName: BillDO
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:24
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BillDO extends BaseDO{

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
