package com.onething.dc.lc;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/5
 */
public class code20 {
    public boolean test(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek()!= map.get(c)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
