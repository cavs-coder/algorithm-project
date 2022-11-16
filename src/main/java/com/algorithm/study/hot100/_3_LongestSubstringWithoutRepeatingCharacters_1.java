package com.algorithm.study.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 哈希表解法
 *
 * @author fuguangwei
 * @date 2022-11-15
 */
public class _3_LongestSubstringWithoutRepeatingCharacters_1 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters_1().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int len = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}
