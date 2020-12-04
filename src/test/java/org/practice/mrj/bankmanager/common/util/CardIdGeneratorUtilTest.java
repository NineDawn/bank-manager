package org.practice.mrj.bankmanager.common.util;

import org.junit.Test;

/**
 * ClassName: CardIdGeneratorUtilTest
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 18:59
 * @Version: 1.0
 */
public class CardIdGeneratorUtilTest {


    @Test
    public void test1() throws InterruptedException {

        for (int i = 0; i < 100; i++) {


            String cardId = CardIdGeneratorUtil.getCardId();
            System.out.println("cardId = " + cardId);
            Thread.sleep(100);
        }




    }


}
