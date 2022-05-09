package com.algorithm.study.back_tracking;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 回溯法剪枝优化
 * 每一层遍历 i 最大为 n - k + 1 + path.size()，后续都是无效遍历
 */
public class _01_Combine_2 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - k + 1 + path.size(); i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
