package com.onething.dc.lc;

import java.util.HashSet;
import java.util.Set;

public class code3 {
    /**
     * 双指针法 ： 通过i作为初始指针，j作为结束指针
     * abcabcbb => abc
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            while (ss.contains(c)) {
                ss.remove(s.charAt(i++));
            }
            ss.add(c);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int len = new code3().lengthOfLongestSubstring("pwwkew");
//        int len1 = new code3().test("pwwkew");
        System.out.println(len);
//        System.out.println(len1);
    }


    public int test(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(i);
            while (charSet.contains(c)) {
                charSet.remove(c);
            }
            charSet.add(c);
            ans = Math.max(ans, j - i - 1);
        }
        return ans;
    }
}


/**
 * // pwwkew  => wke => 3
 * class Solution {
 * public int lengthOfLongestSubstring(String s) {
 * Set<Character> ss = new HashSet<>();
 * int i = 0, ans = 0;
 * for (int j = 0; j < s.length(); ++j) {
 * char c = s.charAt(j);
 * while (ss.contains(c)) {
 * ss.remove(s.charAt(i++));
 * }
 * ss.add(c);
 * ans = Math.max(ans, j - i + 1);
 * }
 * return ans;
 * }
 * }
 */
