package com.onething.dc.lc;

import java.util.Arrays;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/6
 */
public class code26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    // 1122334455
    public int test(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[start] != nums[end]) {
                nums[start + 1] = nums[end];
                start++;
            }
            end++;
        }
        return start + 1;
    }
}
