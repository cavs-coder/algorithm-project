package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * 标记数组
 */
public class _05_CombinationSum2_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] flags;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        flags = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target; i++) {
            //如果是同一层( !flags[i - 1] )，并且当前值与排序后的前一值相同，
            //说明此结果已经包含在在上一个( candidates[i - 1] )的遍历中，所以跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !flags[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            flags[i] = true;
            //每个数字只能使用一次，所有 i + 1
            backtracking(candidates, target, i + 1);
            //回溯
            flags[i] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
