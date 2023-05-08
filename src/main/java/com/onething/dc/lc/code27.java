package com.onething.dc.lc;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/6
 */
public class code27 {

    // 112233       2
    // 1133 -> 4
    public int test(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
//        nums[0:left] //有效数据
        return left;
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
