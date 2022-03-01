package com.algorithm.study.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 */
public class Intersect {

    /**
     * 解法一：map做哈希表
     */
    public int[] intersect01(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            Integer val = map.getOrDefault(i, 0);
            if (val > 0) {
                list.add(i);
                map.put(i, val - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * 解法二：数组做哈希表
     */
    public int[] intersect02(int[] nums1, int[] nums2) {

        byte[] bytes = new byte[1001];
        for (int i : nums1) {
            bytes[i]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (bytes[i] > 0) {
                list.add(i);
                bytes[i]--;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
