package org.practice.mrj.bankmanager.common.util;

/**
 * ClassName: CardIdGeneratorUtil
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 18:54
 * @Version: 1.0
 */
public class CardIdGeneratorUtil {

    public static String getCardId(){


        String cardId = "6214";

        Long time = System.currentTimeMillis() / 1000;

        int rand1  = (int) (Math.random() * 9);
        int rand2  = (int)(Math.random() * 9);

        cardId += time.toString() + rand1 + "" + rand2;

        return cardId;

    }


}
