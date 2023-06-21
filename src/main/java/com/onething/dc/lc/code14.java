package com.onething.dc.lc;

import akka.remote.artery.aeron.AeronSink;
import org.apache.kafka.common.metrics.stats.Max;
import scala.reflect.api.Trees;

import java.beans.IndexedPropertyDescriptor;

/**
 * 获取公共前缀
 * <p>
 * //输入：strs = ["flower","flow","flight"]
 * //输出："fl"
 * //输入：strs = ["dog","racecar","car"]
 * //输出：""
 * //解释：输入不存在公共前缀。
 *
 * @Author: jiangchunyang
 * @Date: 2023/4/27
 */
public class code14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    //strs = ["flower","flow","flight"]
    public String test(String[] arr) {
        if (arr == null || arr.length == 0) return "";
        String first = arr[0];
        String common = "";
        // arr[0] = flower
        // arr[1] = flow
        // arr[2] = flight
        for (int i = 1;i < arr.length;i++){
            String other = arr[i];
            common = getcommon(first, arr[i]);
        }
        return common;
    }

    public String getcommon(String str1,String str2){
        int index = 0;
        int len = Math.min(str1.length(), str2.length());
        while (index < len && str1.charAt(index) == str2.charAt(index) ) {
            index++;
        }

        return str1.substring(0, index + 1);
    }
}
