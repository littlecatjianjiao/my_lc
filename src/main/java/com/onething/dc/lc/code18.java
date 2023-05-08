package com.onething.dc.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/4
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
