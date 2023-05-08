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
        StringBuffer sb = new StringBuffer();
        sb.append("aa").append("bb");
        System.out.println(sb.toString());
        sb.deleteCharAt(0);
        System.out.println(sb.toString());
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
