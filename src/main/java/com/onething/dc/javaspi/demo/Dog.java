package com.onething.dc.javaspi.demo;

/**
 * @ClassPath: com.onething.dc.javaspi.demo
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/4/23
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
