package com.onething.dc.lc;

/**
 * // 示例 1：
 * //输入：x = 121
 * //输出：true
 * // 示例 3：
 * //输入：x = 10
 * //输出：false
 * //解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class code9 {
    public static boolean isPalindrome(int x) { //121
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int num = x;
        int reverseRes = 0;
        while (num != 0) {
            reverseRes = reverseRes * 10 + num % 10; // 1 * 10 * 10 + 2 * 10 + 0 * 10 + 1
            num /= 10;
        }

        return reverseRes==x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public boolean isPalindrome1(int x) {
        if (x < 0 || x % 10 ==0) {
            return false;
        }
        int num = x;
        int res = 0;
        while (num!=0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        return x == res;
    }
}
