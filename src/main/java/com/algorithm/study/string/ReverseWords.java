package com.algorithm.study.string;

import java.util.Arrays;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello  world  ";
        System.out.println(new ReverseWords().reverseWords(s));
    }

    /**
     * s = "  hello  world  "
     */
    public String reverseWords(String s) {

        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (builder.length() == 0 || i > 0 && chars[i] == chars[i - 1]) {
                    continue;
                }
            }
            builder.append(chars[i]);
        }

        char[] words = builder.toString().toCharArray();
        int r = 0;
        StringBuilder wordsBuilder = new StringBuilder();
        int l = 0;
        while (r < words.length) {
            if (r == words.length - 1) {
                while (r >= l) {
                    wordsBuilder.append(chars[r--]);
                }
            }
            if (words[r + 1] == ' ') {
                while (l <= r) {
                    char temp = chars[l];
                    chars[l++] = chars[r];
                    chars[r--] = temp;
                }
            }
        }


        return Arrays.toString(words);
    }

    /**
     * s = "  hello  world  "
     */
    public String reverseWords01(String s) {

        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int slow = chars.length - 1;
        int cur = 0;
        for (int fast = chars.length - 1; fast >= 0; fast--) {
            if (chars[fast] == ' ') {
                cur = fast + 1;
                while (cur <= chars.length - 1 && cur <= slow) {
                    builder.append(chars[cur++]);
                }
                if (fast > 0 && chars[fast - 1] == ' ') {
                    continue;
                }
                slow = fast - 1;
            }
            builder.append(chars[fast]);
        }

        char[] words = builder.toString().toCharArray();
        int r = 0;
        StringBuilder wordsBuilder = new StringBuilder();
        int l = 0;
        while (r < words.length) {
            if (r == words.length - 1) {
                while (r >= l) {
                    wordsBuilder.append(chars[r--]);
                }
            }
            if (words[r + 1] == ' ') {
                while (l <= r) {
                    char temp = chars[l];
                    chars[l++] = chars[r];
                    chars[r--] = temp;
                }
            }
        }


        return Arrays.toString(words);
    }

}
