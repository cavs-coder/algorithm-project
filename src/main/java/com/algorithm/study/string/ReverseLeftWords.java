package com.algorithm.study.string;

/**
 * 左旋转字符串
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(s);
//        System.out.println(new ReverseLeftWords().reverseLeftWords01(s, n));
        System.out.println(new ReverseLeftWords().reverseLeftWords02(s, n));
    }

    /**
     * 1、申请新数组
     */
    public String reverseLeftWords01(String s, int n) {

        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        int cur = 0;
        for (int i = n; i < chars.length; i++) {
            res[cur++] = chars[i];
        }

        for (int i = 0; i < n; i++) {
            res[cur++] = chars[i];
        }

        return new String(res, 0, chars.length);
    }

    /**
     * 2、原数组上实现，通过反转
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     */
    public String reverseLeftWords02(String s, int n) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - n - 1);
        reverse(chars, len - n, len - 1);

        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int l, int r) {

        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
