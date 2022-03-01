package com.algorithm.study.string;

/**
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {

        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
