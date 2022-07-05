package com.algorithm.study.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 思路：
 *      1、先遍历一遍，找到每一个字母的最后出现下标
 *      2、维护一个右边界right变量，right在区间内不断被更新为当前字母的最后出现下标，当前下标等于right时即为一个满足条件的片段。
 *  贪心：
 *      局部：因为right是当前片段所有字母筛选出的最后出现下标，所以它一定是符合要求的最短片段。若是比这还短，那么一定会出现一个字母出现
 *           在两个不同的片段，不符合要求。
 *      全局：由于每次取的都是符合要求的最短片段，那么推出这时的片段数一定是最多的。
 *
 * 时间复杂度O(n)、空间复杂度O(1)、数组长度是固定大小O(26)
 */
public class _14_PartitionLabels_1 {

    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //同一个字母，前面出现的会被后面出现的索引覆盖
            hash[chars[i] - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, hash[chars[i] - 'a']);
            if (i == right) {
                result.add(right - left + 1);
                left = right + 1;
            }
        }

        return result;
    }
}
