package com.algorithm.study.string;

/**
 * 28. 实现 strStr()
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0) {
            return -1;
        }

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i < haystackArr.length; i++) {
            int l = i;
            int r = 0;
            boolean flag = true;
            if (haystackArr.length - l < needleArr.length) {
                return -1;
            }
            while (l < haystackArr.length && r < needleArr.length) {
                if (haystackArr[l] != needleArr[r]) {
                    flag = false;
                    break;
                }
                l++;
                r++;
            }

            if (flag) {
                return i;
            }
        }

        return -1;
    }
}
