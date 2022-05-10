package com.algorithm.study.back_tracking;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class _03_LetterCombinations_1 {

    Map<Character, List<String>> map;
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return result;
        }
        initMap();
        backtracking(digits, 0);
        return result;
    }

    private void backtracking(String digits, int startIndex) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        List<String> list = map.get(digits.charAt(startIndex));
        for (String letter : list) {
            path.append(letter);
            backtracking(digits, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private void initMap() {
        map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }
}
