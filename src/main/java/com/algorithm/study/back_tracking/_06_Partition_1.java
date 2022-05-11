package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 回溯+判断回文串
 */
public class _06_Partition_1 {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        for (; l <= r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
