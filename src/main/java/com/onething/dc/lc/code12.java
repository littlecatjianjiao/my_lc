package com.onething.dc.lc;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/3/28
 */
public class code12 {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans
                = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

    public String test(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num > nums[i]) {
                num = num - nums[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}
