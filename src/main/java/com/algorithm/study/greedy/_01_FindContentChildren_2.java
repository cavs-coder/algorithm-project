package com.algorithm.study.greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 用两个指分别针控制饼干和孩子
 * 1、现存最大尺寸饼干满足不了现存胃口最大的孩子，只能换胃口更小的孩子
 * 2、一一对应能满足，同时减
 */
public class _01_FindContentChildren_2 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int sStart = s.length - 1;
        int gStart = g.length - 1;
        while (sStart >= 0 && gStart >= 0) {
            if (s[sStart] >= g[gStart]) {
                sStart--;
                count++;
            }
            //1、现存最大尺寸饼干满足不了现存胃口最大的孩子，只能换胃口更小的孩子
            //2、一一对应能满足，同时减
            gStart--;
        }

        return count;
    }
}
