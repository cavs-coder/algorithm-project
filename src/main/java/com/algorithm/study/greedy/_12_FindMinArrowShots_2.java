package com.algorithm.study.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 关键点：先按右边界升序，然后维护一个可以一箭射爆重叠气球的最小右边界rightBorder
 * 贪心：时间复杂度O(nlogn)，空间复杂度O(logn)
 */
public class _12_FindMinArrowShots_2 {

    public int findMinArrowShots(int[][] points) {
        //按右边界升序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int rightBorder = points[0][1];
        int arrow = 1;
        for (int i = 1; i < points.length; i++) {
            //排序已经保证后面的区间右侧必定大于当前区间右侧，
            //所以points[i][0] <= rightBorder时，不用更新rightBorder，rightBorder必定小于等于points[i][1]
            if (points[i][0] > rightBorder) {
                arrow++;
                rightBorder = points[i][1];
            }
        }
        return arrow;
    }
}
