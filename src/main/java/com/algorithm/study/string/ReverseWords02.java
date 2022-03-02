package com.algorithm.study.string;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords02 {

    public static void main(String[] args) {
        String s = "  hello  world";
        System.out.println(new ReverseWords02().reverseWords(s));
    }

    /**
     * 解法一：                "  hello  world  "
     * 1、移除多余空格     "hello world"
     * 2、翻转整个字符串   "dlrow olleh"
     * 3、反转每一个单词   "world hello"
     */
    public String reverseWords(String s) {

        /*
         * 1、移除多余空格
         */
        char[] chars = s.toCharArray();
        int cur = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (!space) {
                //只补充第一个空格
                chars[cur++] = ' ';
                space = true;
            }
        }
        //移除最后一位多余的空格
        int len = space ? cur - 1 : cur;

        /*
         * 2、翻转整个字符串
         */
        reverse(chars, 0, len - 1);
        System.out.println(new String(chars, 0, len));
        /*
         * 3、反转每一个单词
         */
        int l = 0;
        int r = 0;
        while (r < len) {
            while (r < len && chars[r] != ' ') {
                r++;
            }

            reverse(chars, l, r - 1);
            l = r + 1;
            r = l;

        }

        return new String(chars, 0, len);
    }

    private void reverse(char[] chars, int l, int r) {

        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
