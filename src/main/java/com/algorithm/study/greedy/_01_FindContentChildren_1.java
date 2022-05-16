package com.algorithm.study.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 455. 分发饼干
 * 菜鸡解法
 */
public class _01_FindContentChildren_1 {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }

        int count = 0;
        List<Integer> list = Arrays.stream(s).boxed().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        Arrays.sort(g);
        for (int i = g.length - 1; i >= 0; i--) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (g[i] <= iterator.next()) {
                    count++;
                    iterator.remove();
                    break;
                }
            }
        }

        return count;
    }
}
