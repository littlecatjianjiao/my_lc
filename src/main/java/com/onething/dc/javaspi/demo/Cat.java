package com.onething.dc.javaspi.demo;

/**
 * @ClassPath: com.onething.dc.javaspi.demo
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/4/23
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}