package com.algorithm.study.hashtable;

import java.util.*;

/**
 * 349. 两个数组的交集
 */
public class Intersection {

    /**
     * 解法一：set做哈希表
     */
    public int[] intersection01(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer i : set2) {
            res[index++] = i;
        }

        return res;
    }

    /**
     * 解法二：数组做哈希表
     */
    public int[] intersection02(int[] nums1, int[] nums2) {

        boolean[] visible = new boolean[1001];
        for (int i : nums1) {
            visible[i] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (visible[i]) {
                list.add(i);
                //优化、后续相同的不再进来
                visible[i] = false;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
