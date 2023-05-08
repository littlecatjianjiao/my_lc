package com.onething.dc.lc;

import org.omg.PortableInterceptor.ObjectReferenceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/4/28
 */
public class code17 {
    public static void main(String[] args) {
        List<String> resList = letterCombinations("23");
        System.out.println(resList);
    }

    public static void test(String digits) {
        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> list = new ArrayList<>();
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index); //2        ->    3
            String letters = phoneMap.get(digit);// abc   ->    def
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i)); // a
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
