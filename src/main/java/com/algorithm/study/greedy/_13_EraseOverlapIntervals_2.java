package com.algorithm.study.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 方法二：计算不重叠的区间数量、然后用总区间减去计算不重叠的区间数量，即得到需要移除的区间数量
 * 贪心：
 *      局部：按照右边界升序，当下个区间左边界大于等于当前区间右边界，即此两区间不重叠，不重叠的区间数量count加1
 *      全局：局部推出不重叠的区间数量count、用总区间intervals.length - count得出结果
 * 时间复杂度O(nlogn)、空间复杂度O(logn)
 */
public class _13_EraseOverlapIntervals_2 {

    public int eraseOverlapIntervals(int[][] intervals) {
        //按照右边界升序
        //效率高于Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        //不重叠的区间数量，第一个区间开始算起
        int count = 1;
        int rightBorder = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (rightBorder <= intervals[i][0]) {
                count++;
                rightBorder = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
