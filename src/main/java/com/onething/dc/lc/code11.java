package com.onething.dc.lc;

/**
 * 盛水最多的容器
 * [1,8,6,2,5,4,8,3,7]
 * (8 - 1) * 7 = 49 //8,7
 * (5 -1 ) * 9 = 36 //8,8
 */
public class code11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int t = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, t);
            if (height[i] < height[j])
                ++i;
            else
                --j;
        }
        return res;
    }

    public int test(int[] height) {
        int maxarea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxarea = Math.max(area, maxarea);
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return maxarea;
    }
}
