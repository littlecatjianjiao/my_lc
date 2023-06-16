package com.onething.dc.lc;

import java.util.HashSet;
import java.util.Set;

public class code3 {
    /**
     *
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
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
