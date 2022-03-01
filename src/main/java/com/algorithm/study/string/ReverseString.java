package com.algorithm.study.string;

/**
 * 344. 反转字符串
 */
public class ReverseString {

    public void reverseString(char[] s) {

        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}
