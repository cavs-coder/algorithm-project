package com.algorithm.study.dynamic_programming;

import java.util.List;

/**
 * 139. 单词拆分
 * 记忆化回溯bfs：时间复杂度O(n^2)，n^2的s.substring()，n^2的backtracking()，空间复杂度O(n)，递归调用栈+缓存数组
 */
public class _18_WordBreak_1 {

    int[] cache;

    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new int[s.length()];
        return backtracking(s, 0, wordDict);
    }

    public boolean backtracking(String s, int startIndex, List<String> wordDict) {
        if (startIndex == s.length()) return true;
        if (cache[startIndex] == -1) return false;
        String sub;
        for (int i = startIndex; i < s.length(); i++) {
            sub = s.substring(startIndex, i + 1);
            if (!wordDict.contains(sub)) continue;
            if (backtracking(s, i + 1, wordDict)) return true;
        }

        //当前下标[startIndex,s.length()-1]不满足条件，返回false，加入缓存避免重复计算。
        cache[startIndex] = -1;
        return false;
    }
}
