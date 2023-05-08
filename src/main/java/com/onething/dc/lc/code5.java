package com.onething.dc.lc;

import akka.remote.artery.aeron.AeronSink;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class code5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int mx = 1, start = 0;
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i <= j; ++i) {
                if (j - i < 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && mx < j - i + 1) {
                    mx = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + mx);
    }


    public static void main(String[] args) {
        String s1 = "baabc";
        System.out.println(s1.substring(0, 2)); //[)
        System.out.println(longestPalindrome2("baabc"));
    }

    public static String longestPalindrome2(String s) {
        int left = 0, right = 0, maxlen = 0, start = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            //判断左边有没有相同的 aaabbb
            // i=1 left=0
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            //判断右边有没有相同的
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            //判断左边和右边有没有相同的
            //左边端点left-j，右边right+j
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left > maxlen) {
                maxlen = right - left;
                start = left;
            }
        }
        return s.substring(start + 1, start + maxlen);
    }

    public String test(String s) {
        int left = 0, right = 0, maxlen = 0;
        int start = 0;
        for (int index = 0; index < s.length(); index++) {
            left = index - 1;
            right = index + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(index)) {
                left--;
            }
            // abb
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left > maxlen) {
                maxlen = right - left;
                start = left;
            }
        }

        return s.substring(start + 1, start + maxlen); //[0,4)
    }


    public static String test1(String s) {
        int left = 0;
        int right = 0;

        int start = 0;
        int maxlen = 0;
        for (int index = 0; index < s.length(); index++) {
            left = index - 1;
            right = index + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(index)) {
                left--;
            }

            while (right <= s.length() && s.charAt(right) == s.charAt(index)) {
                right++;
            }

            while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left > maxlen) {
                maxlen = right - left;
                start = left;
            }
        }

        return s.substring(start + 1, start + maxlen);
    }
}
