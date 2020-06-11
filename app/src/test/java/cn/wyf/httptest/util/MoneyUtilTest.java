package cn.wyf.httptest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyUtilTest {

    @Test
    public void toChinese() {
        System.out.println(MoneyUtil.toChinese("0.19"));
        System.out.println(MoneyUtil.toChinese("100"));
        System.out.println(MoneyUtil.toChinese("1"));
        System.out.println(MoneyUtil.toChinese("111111.01"));
        System.out.println(MoneyUtil.toChinese("9999999.11"));
        System.out.println(addLeftPadding("61",'0',3));
    }

    public static String addLeftPadding(String var0, char var1, int var2) {
        int var3 = var2 - var0.length();
        StringBuilder var4 = new StringBuilder();

        for(int var5 = 0; var5 < var3; ++var5) {
            var4.append(var1);
        }

        var4.append(var0);
        return var4.toString();
    }
}