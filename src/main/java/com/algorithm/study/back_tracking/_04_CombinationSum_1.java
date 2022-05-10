package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class _04_CombinationSum_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝优化，大于直接跳过，小于一直递归，等于就加入结果集
            if (candidates[i] <= target - sum) {
                sum += candidates[i];
                path.add(candidates[i]);
                backtracking(candidates, target, i);
                path.removeLast();
                sum -= candidates[i];
            }
        }
    }
}
