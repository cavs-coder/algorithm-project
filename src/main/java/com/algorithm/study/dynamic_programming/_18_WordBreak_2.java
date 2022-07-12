package com.algorithm.study.dynamic_programming;

import java.util.List;

/**
 * 139. 单词拆分
 * 先遍历背包，再遍历物品
 * dp：时间复杂度O(n^3)，空间复杂度O(n)
 *
 * dp[i]：字符串长度为i，当dp[i]=true表示s在[0,i）范围的字符串可以被拆分为一个或多个字典中的单词。
 *
 * 初始化dp[0]为true，因为它是后续递推的基础。
 *
 * 举例：s = "leetcode", wordDict = ["leet", "code"] 返回true
 *
 *  i       0       1       2       3       4       5       6       7       8
 *  dp[i]  true    false   false   false   false   false   false   false   false
 */
public class _18_WordBreak_2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
