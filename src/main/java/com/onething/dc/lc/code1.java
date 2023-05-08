package com.onething.dc.lc;

import akka.remote.artery.aeron.AeronSink;
import scala.reflect.macros.Universe;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * hashmap:{
 * 2,0
 * 7,1
 * 11,2
 * 15,3
 * }
 */
public class code1 {
    public int[] getSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; ; i++) {
            int x = nums[i];
            int y = target - nums[i];
            if (map.containsKey(y)) {
                return new int[]{map.get(y), i};
            }
            map.put(x, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        code1 code1 = new code1();
        int[] ints = code1.test(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * [2,7,10,11] target = 9
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] test(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; ; i++) {
            int x = nums[i];
            int y = target - nums[i];

            if (map.containsKey(y)) {
                return new int[]{i, map.get(y)};
            }
            map.put(x, i);
        }
    }
}
