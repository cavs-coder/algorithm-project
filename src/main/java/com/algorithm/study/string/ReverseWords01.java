package com.algorithm.study.string;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords01 {

    public static void main(String[] args) {
        String s = "  hello  world  ";
        System.out.println(new ReverseWords01().reverseWords(s));
    }

    /**
     * 解法一：                "  hello  world  "
     * 1、移除多余空格     "hello world"
     * 2、翻转整个字符串   "dlrow olleh"
     * 3、反转每一个单词   "world hello"
     */
    public String reverseWords(String s) {
        StringBuilder builder = removeSpace(s);
        reverseString(builder, 0, builder.length() - 1);
        reverseEachWord(builder);

        return builder.toString();
    }

    private StringBuilder removeSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        while (s.charAt(start) == ' ') {
            start++;
        }
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(c);
            }
            start++;
        }
        return builder;
    }

    private void reverseString(StringBuilder builder, int start, int end) {

        while (start < end) {
            char temp = builder.charAt(start);
            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder builder) {

        int l = 0;
        int r = 0;
        int len = builder.length();
        while (r < len) {

            while (r < len && builder.charAt(r) != ' ') {
                r++;
            }

            reverseString(builder, l, r - 1);
            l = r + 1;
            r = l;
        }
    }

    public String reverseWords01(String s) {
        if (s == null) return null;
        //先消除多余空格，再反转单词
        //消除空格：i--扫描  cur--标识放字符的位置
        char[] chars = s.toCharArray();
        int len = 0;
        int cur = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";
        //整体逆序，再单词逆序（调用）
        reverse(chars, 0, len);
        int previndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;

            reverse(chars, previndex + 1, i);
            previndex = i;

        }
        reverse(chars, previndex + 1, len);
        return new String(chars, 0, len);   //数组转换成字符串
    }

    private void reverse(char[] chars, int l, int r) {
        r--;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
