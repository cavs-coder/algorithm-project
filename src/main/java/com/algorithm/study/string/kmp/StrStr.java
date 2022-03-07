package com.algorithm.study.string.kmp;

public class StrStr {

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(new StrStr().strStr(haystack, needle));
    }

    /**
     * haystack = "hellollab", needle = "lla"
     */
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        /*
         * 通过模式串获取next数组
         */
        char[] pChars = needle.toCharArray();
        getNext(next, pChars);

        //主串
        char[] sChars = haystack.toCharArray();
        int i = 0;
        for (int j = 0; j < sChars.length; j++) {
            while (i > 0 && pChars[i] != sChars[j]) {
                i = next[i - 1];
            }

            if (pChars[i] == sChars[j]) {
                i++;
            }

            if (i == needle.length()) {
                return j - needle.length() + 1;
            }
        }

        return -1;
    }

    /*  ababab
     * 获取next数组
     *      i
     *      a d f g a d a a d f a
     *      0 1 2 3 4 5 6 7 8 9 10
     *                          j
     * next 0 0 0 0 1 2 1 1 2 3 1
     */
    private void getNext(int[] next,char[] pChars) {
        int i = 0;
        next[0] = 0;

        for (int j = 1; j < pChars.length; j++) {
            while (i > 0 && pChars[i] != pChars[j]) {
                i = next[i - 1];
            }

            if (pChars[i] == pChars[j]) {
                i++;
            }
            next[j] = i;
        }
    }
}
