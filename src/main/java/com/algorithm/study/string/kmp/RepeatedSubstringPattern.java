package com.algorithm.study.string.kmp;

/**
 * 459. 重复的子字符串
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern01(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /**
     * KMP
     * len%(len-(next[i])==0)
     */
    public boolean repeatedSubstringPattern02(String s) {

        char[] sArr = s.toCharArray();
        int len = s.length();
        int[] next = new int[len];
        getNext(next, sArr);

        return next[len - 1] > 0 && len % (len - next[len - 1]) == 0;
    }

    private void getNext(int[] next, char[] sArr) {
        int i = 0;
        next[0] = 0;

        for (int j = 1; j < next.length; j++) {
            while (i > 0 && sArr[i] != sArr[j]) {
                i = next[i - 1];
            }
            if (sArr[i] == sArr[j]) {
                i++;
            }
            next[j] = i;
        }
    }
}
