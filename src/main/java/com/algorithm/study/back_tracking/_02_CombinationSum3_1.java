package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 利用sum变量
 * sum与path都要回溯
 */
public class _02_CombinationSum3_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return result;
    }

    private void backtracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - k + 1 + path.size(); i++) {
            sum += i;

            //判断 sum <= n 为剪枝优化
            if (sum <= n) {
                path.add(i);
                backtracking(k, n, i + 1);
                path.removeLast();
            }
            // sum > < 或 = n 都需要减掉
            sum -= i;
        }
    }
}
