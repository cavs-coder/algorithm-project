package com.algorithm.study.dynamic_programming;

/**
 * 392. 判断子序列
 * 二分法：时间复杂度O(m)，m是t的长度，空间复杂度O(1)
 */
public class _34_IsSubsequence_2 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        int sLen = sCh.length;
        int tLen = tCh.length;

        int i = 0;
        int j = 0;
        while (i < sLen && j < tLen) {
            if (sCh[i] == tCh[j]) {
                i++;
            }
            j++;
        }

        return i == sLen;
    }
}
