package com.onething.dc;

/**
 * @ClassPath: com.onething.dc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/3/27
 */
public class test {
    private static volatile boolean stop = false;

    public static void main(String[] args) {
        String aa = "123456";
        System.out.println(aa.substring(0,2));

        int ans = 1 << 30;
        System.out.println(ans);
    }
    public void testaa(){
        int a = 0;
        {
            int b = 1;
            b = a+ 1;
        }
        long c = 3;
    }
}
