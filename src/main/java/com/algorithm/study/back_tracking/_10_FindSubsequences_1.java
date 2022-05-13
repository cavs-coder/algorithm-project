package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 491. 递增子序列
 * set记录树同一层数据
 */
public class _10_FindSubsequences_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> usedSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //1、同树层不能重复
            if (usedSet.contains(nums[i])) {
                continue;
            }

            //2、同树枝要大于等于前一个数，小于跳过
            if (!path.isEmpty() && path.getLast() > nums[i]) {
                continue;
            }

            usedSet.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
