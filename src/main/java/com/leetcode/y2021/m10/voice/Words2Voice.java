package com.leetcode.y2021.m10.voice;

import java.io.File;
import java.io.IOException;

/**
 * @author duwenlei
 **/
public class Words2Voice {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("C:\\Users\\duwenlei\\Downloads\\balcon\\balcon.exe -n \"Microsoft Huihui Desktop\" Emily -t \"会员消费成功，医保刷卡1234元，现金支付256元，积分67890\" -s 0 -\n" +
                    "v 20");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
