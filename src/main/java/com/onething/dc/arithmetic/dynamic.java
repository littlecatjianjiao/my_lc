package com.onething.dc.arithmetic;

import scala.collection.mutable.Publisher$class;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * @ClassPath: com.onething.dc.arithmetic
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/8
 */
public class dynamic {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 讲解：https://blog.csdn.net/u010365819/article/details/121000532
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        //初始化边界
        dp[0] = 1;
//        dp[1] = 1或2
        int maxLen = 1;
        //自底向上遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0;j<i;j++){
                if (nums[j] < nums[i]) {
                    //状态转移方程
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            //求出dp[i]后，dp最大那个就是nums的最长递增子序列啦
            maxLen = Math.max(maxLen, dp[i]);
        }

        return 0;
    }
}
