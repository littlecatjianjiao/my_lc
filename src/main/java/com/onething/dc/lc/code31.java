package com.onething.dc.lc;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/5/9
 */
public class code31 {
    /**
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     * <p>
     * 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * a.在 尽可能靠右的低位 进行交换，需要 从后向前 查找
     * b.将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     * c.将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     * 第一次遍历从最右往左找到需要交换的左边的元素，第二次遍历从最右往左找到第一个比要交换的左边元素大的元素
     * 总结： 从右向左遍历，找出第一不满足递增的位置k，然后从右向左遍历，找到第一个大于k位置值的位置idx,k位置的值与idx位置的值交换，此时k + 1位置到最后是降序排列的，改为升序排列即可。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) { //123456 => 123465 => 123564/123546
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果一直没有找到说明从左到右依次递减，最后i为-1，在后续反转的时候需要从i+1开始反转
        // 如果i>=0说明找到了可以交换的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 交换位置后右半部分区间数组必然是降序的，对交换位置后的右半部分区间进行翻转（升序）
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    //123456 => 123465 => 123564/123546
    public void test(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }

        //将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i + 1);
    }
}
