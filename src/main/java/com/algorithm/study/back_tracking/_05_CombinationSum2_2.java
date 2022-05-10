package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * 不使用标记数组
 */
public class _05_CombinationSum2_2 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && 0 <= (target - candidates[i]); i++) {
            //如果是同一层，并且当前值与排序后的前一值相同，
            //说明此结果已经包含在在上一个( candidates[i - 1] )的遍历中，所以跳过
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            target -= candidates[i];
            path.add(candidates[i]);
            //每个数字只能使用一次，所有 i + 1
            backtracking(candidates, target, i + 1);
            //回溯
            path.removeLast();
            target += candidates[i];
        }
    }
}
