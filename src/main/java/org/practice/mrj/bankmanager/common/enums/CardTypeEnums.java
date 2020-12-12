package org.practice.mrj.bankmanager.common.enums;

/**
 * EnumName: CardTypeEnums
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/12 9:35
 * @Version: 1.0
 */
public enum CardTypeEnums {

    CREDIT_CARD(1,"信用卡"),
    DEBIT_CARD(2,"借记卡"),
    ;
    private int code;
    private String desc;

    CardTypeEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
