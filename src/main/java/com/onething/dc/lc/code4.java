package com.onething.dc.lc;

/**
 * @ClassPath: com.onething.dc.lc
 * @Description:
 * @Author: jiangchunyang
 * @Date: 2023/3/22
 */
public class code4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int leftval = findKth(nums1, 0, nums2, 0, left);
        int rightval = findKth(nums1, 0, nums2, 0, right);
        return (leftval + rightval) / 2.0;
        // return (left + right) /2 ;
    }

    private static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            int x = i + k / 2;
            int y = k - k / 2;
            return findKth(nums1, x, nums2, j, y);
        }
        return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
//        System.out.println(test(nums1, nums2));
    }


    public static double test(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums1.length;
        // 获取 m+n+1/2 和 m+n+2/2 的位置的值在nums1还是nums2，并且找到在哪里   => num[leftIndex] + num[rightIndex] /2.0
        int leftIndex = x + y + 1 / 2;
        int rightIndex = x + y + 2 / 2;
        return (findval(nums1, 0, nums2, 0, leftIndex) + findval(nums1, 0, nums2, 0, rightIndex)) / 2.0;
    }

    private static int findval(int[] nums1, int startindex1, int[] nums2, int startindex2, int targetIndex) {
        if (startindex1 >= nums1.length) {
            return nums2[startindex2 + targetIndex - 1];
        }

        if (startindex2 >= nums1.length) {
            return nums1[startindex1 + targetIndex - 1];
        }

        if (targetIndex == 1){
            return Math.min(nums1[1], nums2[1]);
        }

        // 找targetIndex ，先找targetIndex/2
        int midval1 = startindex1 + targetIndex / 2 - 1 < nums1.length ? nums1[startindex1 + targetIndex / 2 - 1] : Integer.MAX_VALUE;
        int midval2 = startindex2 + targetIndex / 2 - 1 < nums2.length ? nums1[startindex2 + targetIndex / 2 - 1] : Integer.MAX_VALUE;

        return 0;
    }
}
