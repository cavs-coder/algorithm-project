package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 回溯+判断回文串
 */
public class _06_Partition_2 {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s.toCharArray(), 0);
        return result;
    }

    private void backtracking(char[] arr, int startIndex) {
        if (startIndex == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            if (!isPalindrome(arr, startIndex, i)) {
                continue;
            }
            path.add(new String(arr, startIndex, i - startIndex + 1));
            backtracking(arr, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(char[] arr, int l, int r) {
        for (; l <= r; l++, r--) {
            if (arr[l] != arr[r]) {
                return false;
            }
        }
        return true;
    }
}
