package com.algorithm.study.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 用两个指分别针控制饼干和孩子
 * 1、现存最小尺寸饼干不足以满足现存胃口最小的孩子，只能扩大饼干尺寸。
 * 2、一一对应能满足，同时加
 */
public class _01_FindContentChildren_3 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int sStart = 0;
        int gStart = 0;
        while (sStart < s.length && gStart < g.length) {
            if (s[sStart] >= g[gStart]) {
                gStart++;
                count++;
            }
            //1、现存最小尺寸饼干不足以满足现存胃口最小的孩子，只能扩大饼干尺寸。
            //2、一一对应能满足，同时加
            sStart++;
        }

        return count;
    }
}
