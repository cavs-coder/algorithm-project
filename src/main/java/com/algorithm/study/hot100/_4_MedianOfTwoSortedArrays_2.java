package com.algorithm.study.hot100;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author fuguangwei
 * @date 2022-11-18
 */
public class _4_MedianOfTwoSortedArrays_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int cur = -1;
        int last = -1;
        int remainder = (m + n) % 2;
        int mid = (m + n) / 2;
        int i = 0;
        int j = 0;
        int index = 0;
        double result = -1;
        while (index < m + n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i < m) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }

            if (index == mid) {
                if (remainder == 0) {
                    result = (last + cur) / 2.0;
                } else {
                    result = cur;
                }
            }
            last = cur;
            index++;
        }
        return result;
    }
}
