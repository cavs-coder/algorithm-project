package com.algorithm.study.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new FindAnagrams().findAnagrams03(s, p));
    }

    /**
     * 解法一：数组作为哈希表，并且复制数组和数组长度解题
     */
    public List<Integer> findAnagrams01(String s, String p) {

        List<Integer> res = new ArrayList<>();

        int[] record = new int[26];
        int size = 0;
        for (char c : p.toCharArray()) {
            record[c - 'a']++;
            size++;
        }

        int l = 0;
        int r = 0;
        int[] copyArr;
        int arrSize;
        char[] arr = s.toCharArray();
        while (r < s.length()) {
            copyArr = Arrays.copyOf(record, record.length);
            arrSize = size;
            while (r < s.length()) {
                if (copyArr[arr[r] - 'a']-- > 0) {
                    arrSize--;
                }
                if (arrSize == 0) {
                    res.add(l);
                    l++;
                    r = l;
                    break;
                }
                if (copyArr[arr[r] - 'a'] < 0) {
                    if (p.contains(arr[r] + "")) {
                        l++;
                        r = l;
                    } else {
                        r++;
                        l = r;
                    }
                    break;
                }
                r++;
            }
        }

        return res;
    }

    /**
     * 解法二：滑动窗口
     */
    public List<Integer> findAnagrams02(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sL = s.length();
        int pL = p.length();
        if (sL < pL) {
            return res;
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pL; i++) {
            sCount[sArr[i] - 'a']++;
            pCount[pArr[i] - 'a']++;
        }

        for (int i = 0; i <= sL - pL; i++) {
            if (Arrays.equals(sCount, pCount)) {
                res.add(i);
            }
            if (i == sL - pL) {
                break;
            }

            sCount[sArr[i] - 'a']--;
            sCount[sArr[i + pL] - 'a']++;
        }

        return res;
    }

    /**
     * 解法三：滑动窗口优化
     */
    public List<Integer> findAnagrams03(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int sL = s.length();
        int pL = p.length();
        if (sL < pL) {
            return res;
        }

        //记账的总账本
        int[] counts = new int[26];
        //每个子账本加起来共欠多少
        int all = 0;
        for (char c : p.toCharArray()) {
            //c - 'a'即为子帐本
            counts[c - 'a']++;
            all++;
        }

        char[] sArr = s.toCharArray();
        int l = 0;
        int r = 0;

        //c b a e b a b a c d
        //0 1 2 3 4 5 6 7 8 9   a b c
        while (l <= sL - pL) {

            //在总帐本上有的子帐本开始还账
            //滑动窗口开始伸展 r++
            while (r < sL && counts[sArr[r] - 'a'] > 0) {
                all--;
                counts[sArr[r++] - 'a']--;
            }

            //连续索引还清账本，all才会为0、否则一直都有额外的帐(即不在字符串p初始counts数组里的子帐本)
            if (all == 0) {
                res.add(l);
            }

            //记账本开始记账，子帐本为 counts[sArr[l] - 'a']
            //滑动窗口开始收缩 l++
            all++;
            counts[sArr[l++] - 'a']++;
        }

        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        int[] counts = new int[26]; // 欠账表：欠的字符 -> 欠的个数
        int all = p.length(); // 总欠账数目
        // 统计欠账，生成欠账表:
        for (char c : p.toCharArray()) counts[c - 'a']++;
        // 【滑动窗口】还账：
        int l = 0, r = 0, n = s.length();
        char[] str = s.toCharArray();
        for (; l < n; l++) {
            // 窗口右边界字符进入窗口还账，如果不超额还账，就一直还：
            while (r < n && counts[str[r] - 'a'] > 0) {
                all--;
                counts[str[r++] - 'a']--;
            }
            // 还账结束，看当前窗口内是否还清了所有欠账：
            if (all == 0) ans.add(l);
            // 窗口左边界字符出窗口，重新赊账：
            counts[str[l] - 'a']++;
            all++;
        }
        return ans;
    }
}
