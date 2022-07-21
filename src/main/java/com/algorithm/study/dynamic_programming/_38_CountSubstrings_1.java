package com.algorithm.study.dynamic_programming;

/**
 * 647. 回文子串
 *
 * 双指针中心扩散法：时间复杂度O(n^2)，空间复杂度O(1)，忽略sCh
 *
 * 从回文子串的中心开始向两边扩散，查找个数，由于有回文子串可能有奇有偶，
 * 所以它的中心可能是一个数，也可能是两个数。中心是一个数的回文子串长度必是奇数，中心是两个数的回文子串长度必是偶数。
 * 中心为i的覆盖奇数长度回文数个数，中心为i和i+1的覆盖偶数长度回文数个数。
 */
public class _38_CountSubstrings_1 {

    int res = 0;

    public int countSubstrings(String s) {
        char[] sCh = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            extend(sCh, i, i);
            extend(sCh, i, i + 1);
        }
        return res;
    }

    public void extend(char[] sCh, int i, int j) {
        int len = sCh.length;
        while (i >= 0 && j < len && sCh[i] == sCh[j]) {
            i--;
            j++;
            res++;
        }
    }
}
