package com.algorithm.study.hashtable;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams01(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
    public List<List<String>> groupAnagrams02(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] record = new int[26];
            for (char c : str.toCharArray()) {
                record[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < record.length; i++) {
                if (record[i] != 0) {
                    builder.append((char) ('a' + i)).append(record[i]);
                }
            }
            String key = builder.toString();

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

}
