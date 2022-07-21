package com.algorithm.study.dynamic_programming;

/**
 * 647. 回文子串
 *
 * dp：时间复杂度O(n^2)，空间复杂度O(n^2)
 *
 * dp[i][j]：以[i,j]截取s，此字符串若是回文子串则：dp[i][j] = 1，不是回文子串则：dp[i][j] = 0
 *
 * char[] sCh = s.toCharArray()
 * i和j为边界，初始判断sCh[i]与sCh[j]的值：
 *      若是sCh[i] != sCh[j]，则以[i,j]截取的s必不是回文串，所以dp[i][j] = 0
 *      若是sCh[i] == sCh[j]，则以[i,j]截取的s有以下几种可能：
 *          1、i == j，单个字母，如a，为回文子串，dp[i][j] = 1
 *          2、j-i == 1，两个字母，如aa，为回文子串，dp[i][j] = 1
 *          3、j-i == 2，三个字母，如aba，因为首位相同，中间值不论是什么都是回文子串，dp[i][j] = 1，而不用去计算dp[i+1][j-1]
 *          4、j-i > 2，这时候就要进一步判断，去掉首位相等的值，判断以[i+1,j-1]截取的s是否为回文子串，若是，则以[i,j]截取的s也是，
 *             若否，则以[i,j]截取的s也否。例如ababa，去掉首位，剩下bab，它是回文串，所以ababa也是回文串。
 *            即：dp[i][j] = dp[i+1][j-1]
 *
 * 遍历顺序：因为dp[i][j]依赖dp[i+1][j-1]，所以应该采取先外层从头遍历，然后从头开始取每个值j最为尾巴，用另一个指针i从0
 *          开始遍历，比如ababa
 *          j
 *          0   [0,0]
 *          1   [0,1],[1,1]
 *          2   [0,2],[1,2],[2,2]
 *          3   [0,3],[1,3],[2,3],[3,3]
 *          4   [0,4],[1,4],[2,4],[3,4],[4,4]
 *          此时假设到[0,4]，sCh[0] == sCh[4]，需要依赖dp[i + 1][j - 1]即dp[1,3]的结果，已经计算出来了
 *
 *  举例推导：s=ababa
 *      a   b   a   b   a
 *  a   1   0   1   0   1
 *  b       1   0   1   0
 *  a           1   0   1
 *  b               1   0
 *  a                   1
 *
 *  空白处都在初始化的时候赋值为0了，并且不相同的时候值本来就是0，所以不用再次赋值，所以可以忽略sCh[i] != sCh[j]情况
 *
 *
 */
public class _38_CountSubstrings_2 {

    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        int res = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j) == s.charAt(i) && ((j - i <= 2) || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    res++;
                }
            }
        }

        return res;
    }
}
