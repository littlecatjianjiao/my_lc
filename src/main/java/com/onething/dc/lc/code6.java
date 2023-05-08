package com.onething.dc.lc;

import akka.util.Index;
import scala.tools.nsc.typechecker.Infer;

/**
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class code6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int group = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            int interval = i == numRows ? group : 2 * numRows - 2 * i; //确定每行的间隔
            int idx = i - 1;
            while (idx < s.length()) {
                ans.append(s.charAt(idx));
                idx += interval;
                interval = group - interval;
                if (interval == 0) {
                    interval = group;
                }
            }
        }
        return ans.toString();
    }

    public String test(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int group = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            //interval是跳变的
            int interval = i == numRows ? group : 2 * numRows - 2 * i;
            int index = i - 1;
            while (index < s.length()) {
                ans.append(s.charAt(index)); //p    --  A
                index += interval; //I + N          -- L
                interval = group - interval;
                if (interval == 0) {
                    interval = group;
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
