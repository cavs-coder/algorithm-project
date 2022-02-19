package com.algorithm.study.array._3_sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串 hard
 * // TODO: 2022/2/19 无思路  1、哈希表+滑动窗口(击败了15.51%的用户)
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBAANC";
        String t = "AABC";
        System.out.println(new MinWindow().minWindow01(s, t));
        System.out.println(new MinWindow().minWindow02(s, t));
    }

    /**
     * 方法一：哈希表+滑动窗口(击败了15.51%的用户)
     */
    public String minWindow01(String s, String t) {

        HashMap<Character, Integer> original = getOriginal(t);
        HashMap<Character, Integer> counter = new HashMap<>();

        int l = 0;
        int r = 0;
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int ansL = 0;
        int ansR = 0;
        while (r < n) {
            char sCh = s.charAt(r);
            if (original.containsKey(sCh)) {
                counter.put(sCh, counter.getOrDefault(sCh, 0) + 1);
            }

            while (check(original, counter) && l <= r) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    ansL = l;
                    ansR = l + minLen;
                }
                char lCh = s.charAt(l);
                if (counter.containsKey(lCh)) {
                    counter.put(lCh, counter.get(lCh) - 1);
                }
                l++;
            }
            r++;
        }
        return ansL == ansR ? "" : s.substring(ansL, ansR);
    }

    private HashMap<Character, Integer> getOriginal(String t) {
        HashMap<Character, Integer> original = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            original.put(c, original.getOrDefault(c, 0) + 1);
        }
        return original;
    }

    public boolean check(HashMap<Character, Integer> original, HashMap<Character, Integer> counter) {
        for (Map.Entry<Character, Integer> entry : original.entrySet()) {
            Character c = entry.getKey();
            Integer count = entry.getValue();
            if (counter.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二: 滑动窗口+数组做记账本
     */
    public String minWindow02(String s, String t) {

        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();

        //欠账的总帐本，每个子账本上的欠债数额累加，就是总帐本欠债数 all
        int[] map = new int[256];
        int all = tCh.length;
        for (int i = 0; i < tCh.length; i++) {
            map[tCh[i]]++;
        }

        int l = 0;
        int r = 0;
        int ansL = 0;
        int minLen = Integer.MAX_VALUE;

        while (r < s.length()) {
            map[sCh[r]]--;
            //开始还账
            if (map[sCh[r]] >= 0) {
                all--;
            }

            //r延申到此次最长位置，是本次滑动窗口最大下表，开始处理l的缩进
            if (all == 0) {

                //跳出while的l则是本次滑动窗口的最小下标
                while (map[sCh[l]] < 0) {
                    map[sCh[l]]++;
                    l++;
                }

                //本次有效滑动窗口为 [l,r]
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    ansL = l;
                }

                //l继续缩进一步，开始下一轮有效滑动窗口判断
                //l未进1时的元素就是新的子账本，记为 1，总额 all也记为 1
                map[sCh[l++]]++;
                all++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansL + minLen);
    }
}
