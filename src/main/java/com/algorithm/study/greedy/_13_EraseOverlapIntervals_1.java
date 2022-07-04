package com.algorithm.study.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 方法一：计算需要移除的区间数量
 * 贪心：
 *      局部：按照右边界升序，当下个区间左边界小于当前区间右边界，移除，不是真正移除，而是removeCount加1
 *      全局：局部推出的removeCount总数
 * 时间复杂度O(nlogn)、空间复杂度O(logn)
 */
public class _13_EraseOverlapIntervals_1 {

    public int eraseOverlapIntervals(int[][] intervals) {
        //按照右边界升序，若是多个右边界相同的情况不用特殊处理他们的顺序，因为最终只能留下一个。
        //效率高于Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        //需要移除的区间数量
        int removeCount = 0;
        int rightBorder = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < rightBorder) {
                removeCount++;
                continue;
            }
            rightBorder = intervals[i][1];
        }
        return removeCount;
    }
}
