package com.algorithm.study.dynamic_programming;

/**
 * 5. 最长回文子串
 *    (647. 回文子串变形题)
 * 双指针中心扩散法：时间复杂度O(n^2)，空间复杂度O(1)，忽略sCh
 */
public class _39_LongestPalindrome_1 {

    int len = -1;
    int start = -1;

    public String longestPalindrome(String s) {
        char[] sCh = s.toCharArray();
        for (int i = 0; i < sCh.length; i++) {
            extend(sCh, i, i);
            extend(sCh, i, i + 1);
        }
        return new String(sCh, start, len);
    }

    public void extend(char[] sCh, int i, int j) {
        while (i >= 0 && j < sCh.length && sCh[i] == sCh[j]) {
            if (j - i + 1 > len) {
                len = j - i + 1;
                start = i;
            }
            i--;
            j++;
        }
    }
}
