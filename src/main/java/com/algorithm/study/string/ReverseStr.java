package com.algorithm.study.string;

/**
 * 541. 反转字符串 II
 */
public class ReverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 4;
        System.out.println(new ReverseStr().reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i += k) {
            if (flag) {
                int end = Math.min(i + k - 1, chars.length - 1);
                swap(chars, i, end);
            }
            flag = !flag;
        }

        return String.valueOf(chars);
    }

    public void swap(char[] chars, int l, int r) {

        while (l < r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}
