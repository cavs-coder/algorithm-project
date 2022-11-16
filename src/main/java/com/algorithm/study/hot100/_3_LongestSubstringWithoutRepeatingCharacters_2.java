package com.algorithm.study.hot100;

/**
 * 3. 无重复字符的最长子串
 * 数组解法
 *
 * @author fuguangwei
 * @date 2022-11-15
 */
public class _3_LongestSubstringWithoutRepeatingCharacters_2 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters_2().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int len = 0;
        //ASCII码128个字符
        int[] leftArr = new int[128];
        char[] chars = s.toCharArray();

        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            //有重复从leftArr取出最新左边界索引
            left = Math.max(left, leftArr[c]);
            len = Math.max(len, right - left + 1);
            //用于后续重置左边界
            leftArr[c] = right + 1;
        }

        return len;
    }
}
