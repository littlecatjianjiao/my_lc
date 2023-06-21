package com.onething.dc.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class code18 {
    public List<List<Integer>> test(int[] nums, int target) {
        ArrayList<List<Integer>> resList = new ArrayList<>();

        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            //相同的数据跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 筛减
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if (nums[first] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }

            for (int second = first + 1; second < nums.length - 2; second++) {
                //相同的数据跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 筛减
                if (nums[second] + nums[second + 1] + nums[second + 2] + nums[second + 3] > target) {
                    break;
                }
                if (nums[second] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                    continue;
                }
                int leftpoint = second + 1;
                int rightpoint = nums.length - 1;

                while (leftpoint < rightpoint) {
                    int tmp = nums[first] + nums[second] + nums[leftpoint] + nums[rightpoint];
                    if (tmp == target) {
                        resList.add(Arrays.asList(nums[first], nums[second], nums[leftpoint], nums[rightpoint]));
                        while (leftpoint < rightpoint && nums[leftpoint] == nums[leftpoint + 1]) {
                            leftpoint++;
                        }
                        leftpoint++;
                        while (leftpoint < rightpoint && nums[rightpoint] == nums[rightpoint - 1]) {
                            rightpoint--;
                        }
                        rightpoint--;

                    } else if (tmp < target) {
                        leftpoint++;
                    } else {
                        rightpoint--;
                    }
                }
            }
        }

        return resList;
    }


    public List<List<Integer>> test1(int[] nums, int target) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return resList;
        }
        Arrays.sort(nums);
        int len = nums.length;
        //首次
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] + nums[len - 1] + nums[len - 2] + nums[len - 3] > target) {
                break;
            }

            if (nums[first] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }

            for (int second = first + 1; second < nums.length - 2; second++) {
                //相同的数据跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 筛减
                if (nums[second] + nums[second + 1] + nums[second + 2] + nums[second + 3] > target) {
                    break;
                }
                if (nums[second] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                    continue;
                }
                int thrid = second + 1;
                int fourth = len - 1;
                while (thrid < fourth) {
                    int t = nums[first] + nums[second] + nums[thrid] + nums[fourth];
                    if (t == target) {
                        resList.add(Arrays.asList(nums[first], nums[second], nums[thrid], nums[fourth]));
                        while (thrid < fourth && nums[thrid] == nums[fourth]) {
                            thrid++;
                        }
                        thrid++;
                        while (thrid < fourth && nums[fourth] == nums[fourth - 1]) {
                            fourth--;
                        }
                        fourth--;
                    } else if (t < target) {
                        thrid++;
                    } else {
                        fourth--;
                    }
                }
            }
        }
        return resList;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
