package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 所有树枝路径（根到叶树枝路径可以重复） + 每层路径不重复计算（同一树层不可以重复）
 *
 */
public class _09_SubsetsWithDup_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
