package com.onething.dc.lc;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/4/27
 */
public class code16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == target) {
                    return t;
                }
                if (Math.abs(t - target) < Math.abs(ans - target)) {
                    ans = t;
                }
                if (t > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return ans;
    }

    public int test(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int first = 0; first < nums.length; first++) {
            int sec = first + 1;
            int third = nums.length - 1;
            while (sec < third) {
                int tmp = nums[first] + nums[sec] + nums[third];
                if (tmp == target) {
                    return tmp;
                }

                res = Math.min(res,Math.abs(target - tmp));

                if (tmp > target) third--;
                if (tmp < target) sec++;
            }
        }
        return res;
    }


    public int test1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i =0;i<nums.length ;i++){
            int j = i+1;
            int k = nums.length -1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp == target) {
                    return tmp;
                }
                res = Math.min(res, Math.abs(target - tmp));
                if (tmp > target) k--;
                if (tmp < target) j++;
            }
        }

        return res;
    }
}
