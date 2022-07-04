package com.algorithm.study.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 关键点：先按左边界升序，然后维护一个可以一箭射爆重叠气球的最小右边界rightBorder
 * 贪心：时间复杂度O(nlogn)，空间复杂度O(logn)
 *      局部：升序后，左边界小于等于rightBorder，那么可以一起射爆，不加箭矢数量，并且需要重置rightBorder
 *           若是左边界大于rightBorder，需要增加箭矢数量，并且以此气球右边界重置rightBorder，形成新的局部。
 *      全局：局部推出箭矢数量累加
 */
public class _12_FindMinArrowShots_1 {

    public int findMinArrowShots(int[][] points) {
        //按左边界升序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int rightBorder = points[0][1];
        int arrow = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightBorder) {
                rightBorder = Math.min(rightBorder, points[i][1]);
            } else {
                arrow++;
                rightBorder = points[i][1];
            }
        }
        return arrow;
    }

    public static void main(String[] args) {
        int[][] people = new int[4][2];
        people[0] = new int[]{10, 16};
        people[1] = new int[]{2, 8};
        people[2] = new int[]{1, 6};
        people[3] = new int[]{7, 12};
        new _12_FindMinArrowShots_1().findMinArrowShots(people);
    }
}
