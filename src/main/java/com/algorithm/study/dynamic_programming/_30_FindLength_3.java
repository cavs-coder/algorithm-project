package com.algorithm.study.dynamic_programming;

/**
 * 718. 最长重复子数组
 * 滑动窗口：时间复杂度O((m+n)*min(m,n))，空间复杂度O(1)
 */
public class _30_FindLength_3 {

    public int findLength(int[] nums1, int[] nums2) {
        //区分哪个长度更小，方便后续计算边界与子数组长度
        return nums1.length <= nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
    }

    public int findMax(int[] a, int[] b) {
        /*
         *  三种阶段计算边界，a固定不动，b从左往右滑动
         *             * * * *              * * * *          * * * *            * * * *
         *   * * * * * *          ===>  * * * * * *    ===>  * * * * * *   ===>       * * * * * *
         */
        int m = a.length;
        int n = b.length;
        int maxLength = 0;
        //阶段一：b的右边界对齐a的左边界，滑动到b的右边界对齐a的右边界，此时b滑动，相交区域逐渐增大
        for (int len = 1; len <= m; len++) {
            maxLength = Math.max(maxLength, maxLength(a, 0, b, n - len, len));
        }

        //阶段二：b的右边界对齐a的右边界，滑动到b的左边界对齐a的左边界，此时b滑动，相交区域为整个a，a被全包含
        //i为n - m的情况，阶段一已经计算过
        for (int i = n - m - 1; i >= 0; i--) {
            maxLength = Math.max(maxLength, maxLength(a, 0, b, i, m));
        }

        //阶段三：b的左边界对齐a的左边界，滑动到b的左边界对齐a的右边界，此时b滑动，相交区域逐渐减小
        //i=0的情况，阶段二已经计算过
        for (int i = 1; i < m; i++) {
            maxLength = Math.max(maxLength, maxLength(a, i, b, 0, m - i));
        }

        return maxLength;
    }

    /**
     * 两个数组分别从下标i，j开始后，长度为len的两个子数组，计算他们的最长公共连续子数组长度
     */
    public int maxLength(int[] a, int i, int[] b, int j, int len) {
        int maxLength = 0;
        int count = 0;
        for (int k = 0; k < len; k++) {
            count = a[i + k] == b[j + k] ? count + 1 : 0;
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
