package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 * 1、利用 集合 add(int index, E element)特性
 */
public class _11_Permute_1 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtracking(list);
        return result;
    }

    private void backtracking(List<Integer> list) {
        if (list.size() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Integer cur = list.get(i);
            path.add(cur);
            list.remove(i);
            backtracking(list);
            list.add(i, cur);
            path.remove(cur);
        }
    }
}
