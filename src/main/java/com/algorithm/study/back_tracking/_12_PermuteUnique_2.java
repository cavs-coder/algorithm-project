package com.algorithm.study.back_tracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 */
public class _12_PermuteUnique_2 {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, used);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //同一树层跳过
            if (usedSet.contains(nums[i])) {
                continue;
            }
            //同一树枝使用过的元素不再使用
            if (used[i]) {
                continue;
            }
            usedSet.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }


}
