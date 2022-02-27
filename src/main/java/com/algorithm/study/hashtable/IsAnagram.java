package com.algorithm.study.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new IsAnagram().isAnagram02(s,t));
    }

    /**
     * 解法一：map做哈希表
     */
    public boolean isAnagram01(String s, String t) {

        HashMap<Character, Integer> sMap = getMap(s);
        HashMap<Character, Integer> tMap = getMap(t);

        if (sMap.keySet().size() != tMap.keySet().size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character key = entry.getKey();
            if (!entry.getValue().equals(tMap.getOrDefault(key, 0))) {
                return false;
            }
        }

        return true;
    }

    private HashMap<Character, Integer> getMap(String str) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }
        return result;
    }
    /**
     * 解法二：数组做哈希表
     */
    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] record = new int[26];
        for (char ch : s.toCharArray()) {
            record[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            record[ch - 'a']--;
            if (record[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

}
