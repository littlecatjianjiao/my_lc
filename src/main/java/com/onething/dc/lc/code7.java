package com.onething.dc.lc;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class code7 {
//    //  123 = 3 * 100 + 2 * 10 + 1
//    public int reverse(int x) {
//        long res = 0;
//
//        while (x != 0) {
//            res = res * 10 + x % 10;
//            x /= 10;
//        }
//        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res;
//    }
//
//


    public static int reverseNum(int x) {
        int res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
}

