package com.algorithm.study.array._2_double_pointer;

/**
 * 844. 比较含退格的字符串
 * // TODO: 2022/02/17 15:12 双指针法无思路，看答案思路写出
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        String s = "###ab#kmn#c";
        // akmc
        String t = "ad#c";
        System.out.println(new BackspaceCompare().backspaceCompare01(s, t));
        System.out.println(new BackspaceCompare().backspaceCompare01(s, t));
    }

    /**
     * 方法一: 字符串做法
     */
    public boolean backspaceCompare01(String s, String t) {
        return builder(s).equals(builder(t));
    }

    private String builder(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('#' == s.charAt(i)) {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(s.charAt(i));
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    /**
     * 方法二: 双指针法   关键：1、从后开始比较。2、定义一个 skip变量来记录 # 个数、通过 skip的增减来计算满足条件元素下标
     */
    public boolean backspaceCompare02(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkip++;
                    i--;
                } else if (sSkip > 0) {
                    sSkip--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkip++;
                    j--;
                } else if (tSkip > 0) {
                    tSkip--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }


}
