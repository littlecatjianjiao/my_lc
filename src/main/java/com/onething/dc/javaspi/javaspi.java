package com.onething.dc.javaspi;

import com.onething.dc.javaspi.demo.IShout;

import java.util.ServiceLoader;

/**
 * @ClassPath: com.onething.dc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/4/23
 */
public class javaspi {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts  = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}