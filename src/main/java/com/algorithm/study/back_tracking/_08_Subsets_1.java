package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 按树的层次处理
 */
public class _08_Subsets_1 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, 0, i);
        }
        return result;
    }

    //1 ,2,3,4,5,6
    private void backtracking(int[] nums, int startIndex, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, k);
            path.removeLast();
        }
    }
}
