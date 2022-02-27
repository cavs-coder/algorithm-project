package com.algorithm.study.hashtable;

/**
 * 383. 赎金信
 */
public class CanConstruct {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(new CanConstruct().canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] record = new int[26];
        for (char ch : magazine.toCharArray()) {
            record[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            record[ch - 'a']--;
            if (record[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
