package com.algorithm.study.array._1_binary_search;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        int num = 0;
        System.out.println(new IsPerfectSquare().isPerfectSquare(num));
    }

    public boolean isPerfectSquare(int num) {

        int l = 0;
        int r = num;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid < num) {
                l = mid + 1;
            } else if (num < (long) mid * mid) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
