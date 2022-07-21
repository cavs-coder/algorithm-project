package com.algorithm.study.dynamic_programming;

/**
 * 72. 编辑距离
 *
 * dp的思想：通过二维数组，将两个维度的数据，细化拆分为每一种最小颗粒的组合，每次遍历i，j得到的dp[i][j]都是当前结果，
 *          从i -> m，j -> n，演化到最终结果。
 *
 * dp：时间复杂度O(mn)，空间复杂度O(mn)
 *
 * dp[i][j]：[0,i-1]下标的word1转换成[0,j-1]下标的word2所需要的最小操作数，一次编辑可选增、删、改其一。
 *
 * 情况一：若是s[i-1] == t[j-1]，则[0,i-2]下标的word1与[0,j-2]下标的word2末尾同时增加一个相同的数，此种情况不用增删改，
 *        所以操作数与此前已经匹配好的二维区间dp[i-1][j-1]保持一致。
 * 情况二：若是s[i-1] != t[j-1]，则有三种可能：
 *        1、从左面dp[i][j-1]方向来考虑当前最小操作数dp[i][j]
 *           例如：s=ab，t=abc，即：
 *              abc
 *            a ***
 *            b **？
 *            此时？位置左面的s=ab与t=ab已经匹配好，c是多余的，可以选择删除t[2]=c，也可以给s[2]位置加一个c，
 *            即增删操作，最小操作数：dp[i][j] = dp[i][j-1]+1
 *        2、从上面dp[i-1][j]方向来考虑当前最小操作数dp[i][j]
 *           例如：s=abc，t=ab，即：
 *              ab
 *            a **
 *            b **
 *            c *？
 *            此时？位置上面的s=ab与t=ab已经匹配好，c是多余的，可以选中删除s[2]=c，也可以给t[2]位置加一个c，
 *            即增删操作，最小操作数：dp[i][j] = dp[i-1][j]+1
 *        3、从左上方dp[i-1][j-1]方向来考虑当前最小操作数dp[i][j]
 *           例如：s=abc，t=abd，即
 *              abd
 *            a ***
 *            b ***
 *            c **？
 *            此时？位置斜上方s=ab与t=ab已经匹配好，c和d都是多余的，可以选择都删除，操作数为dp[i-1][j-1]+1+1，
 *            也可以选择替换将c换成d，或者将d换成c，操作数为dp[i-1][j-1]+1，小于删两个值。
 *            即替换操作，最小操作数：dp[i][j] = dp[i-1][j-1] + 1
 * 所以状态转换方程为：
 *  if (s[i - 1] == t[j - 1]) {
 *      dp[i][j] = dp[i - 1][j - 1];
 *    } else {
 *      dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
 *    }
 *
 * 初始化：dp[i][0]表示将纵列转化为空串，则长度为多少就该删除多少，即dp[i][0] = i
 *        dp[0][j]同理，dp[0][j] = j
 *
 * 举例推导：word1 = "horse", word2 = "ros"
 *          r   o   s
 *      0   1   2   3
 *  h   1   1   2   3
 *  o   2   2   1   2
 *  r   3   2   2   2
 *  s   4   3   3   2
 *  e   5   4   4   3
 */
public class _37_MinDistance_1 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
