package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
public class _07_RestoreIpAddresses_1 {

    List<String> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s.toCharArray(), 0);
        return result;
    }

    private void backtracking(char[] arr, int startIndex) {
        if (path.size() == 4) {
            if (startIndex == arr.length) {
                change();
            }
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            if ((arr[startIndex] == '0' && i > startIndex)) {
                break;
            }
            if ((i - startIndex == 2) && arr[startIndex] > '2') {
                break;
            }
            int ipPart = Integer.parseInt(String.valueOf(arr, startIndex, i - startIndex + 1));
            if (ipPart > 255) {
                break;
            }
            path.add(ipPart);
            backtracking(arr, i + 1);
            path.removeLast();
        }
    }

    private void change() {
        StringBuilder builder = new StringBuilder();
        for (Integer ipPart : path) {
            builder.append(ipPart).append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        result.add(builder.toString());
    }
}
