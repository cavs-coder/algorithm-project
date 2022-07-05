package com.algorithm.study.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 贪心：
 *      局部：按左边界升序，若是当前左边界小于等于上一个右边界，那么采取合并操作，延申右边界right，得到一个合并后的区间[left,right]。
 *      全局：局部合并了所有重叠区间，此时返回不重叠的区间就行了。
 *
 * 时间复杂度O(nlogn)、空间复杂度O(logn)
 */
public class _15_Merge_1 {

    //intervals = [[1,3],[2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                //两个区间有相交
                right = Math.max(intervals[i][1], right);
            } else {
                //两个区间不想交，收集结果，重置区间边界
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        //最后一个一定是不重叠的
        result.add(new int[]{left, right});

        return result.toArray(new int[result.size()][]);
    }
}
