package com.algorithm.study.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 回溯 + 判断ip段是否有效
 */
public class _07_RestoreIpAddresses_2 {

    List<String> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backtracking(s.toCharArray(), 0);
        return result;
    }

    private void backtracking(char[] arr, int startIndex) {
        //只要 path 大小到达 4，无论满不满足条件都是递归出口
        if (path.size() == 4) {
            if (startIndex == arr.length) {
                change();
            }
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            //剪枝优化，ip最多255为三位数
            if (i - startIndex > 2) {
                break;
            }
            int ipPart = Integer.parseInt(String.valueOf(arr, startIndex, i - startIndex + 1));
            //只要该部分ip无效，则出栈，返回上一个栈帧，将上一个ip右加一位继续判断
            if (!isValid(arr, startIndex, i, ipPart)) {
                break;
            }

            path.add(ipPart);
            backtracking(arr, i + 1);
            //回溯
            path.removeLast();
        }
    }

    //判断该部分ip是否有效
    private boolean isValid(char[] arr, int left, int right, int ipPart) {
        //多位数以 0 开头无效
        if ((arr[left] == '0' && right > left)) {
            return false;
        }
        //三位数不以 1、2 开头无效
        if ((right - left == 2) && arr[left] > '2') {
            return false;
        }
        //小于等于 255 有效
        return ipPart <= 255;
    }

    //转换结果集
    private void change() {
        StringBuilder builder = new StringBuilder();
        for (Integer ipPart : path) {
            builder.append(ipPart).append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        result.add(builder.toString());
    }
}
