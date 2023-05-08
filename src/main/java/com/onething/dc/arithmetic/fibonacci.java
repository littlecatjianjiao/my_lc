package com.onething.dc.arithmetic;

import java.util.HashMap;

/**
 * @ClassPath: com.onething.dc.arithmetic
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/8
 */
public class fibonacci {
    public static void main(String[] args) {
        int i = fibonacci_1(4);
        System.out.println(i);
    }
    /**
     * 斐波那契数列求和 ： 暴力版
     * 时间复杂度：O（2^n）
     * @param n
     * @return
     */
    public static int fibonacci_1(int n){
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return fibonacci_1(n - 1) + fibonacci_1(n - 2);
    }

    /**
     * 使用动态规划来将重复计算的结果具有"记忆性",就可以将时间复杂度降低为O(n).
     * @param n
     * @return
     */
    public static int fibonacci_2(int n){
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 判断当前n的结果是否已经被计算,如果map存在n则代表该结果已经计算过了
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int value = fibonacci_2(n - 1) + fibonacci_2(n - 2);
        map.put(n, value);
        return value;
    }

    /**
     * 通过观察斐波那契数列的规律,发现n只依赖于前2种状态,所以我们可以自底向上地迭代实现.
     * 遍历迭代实现,不仅时间复杂度得到了优化,也不需要额外的空间复杂度.
     * @param n
     * @return
     */
    public static int fibonacci_3(int n){
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a =1;
        int b = 2;
        int temp = 0;
        for (int i=0;i<n;i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
