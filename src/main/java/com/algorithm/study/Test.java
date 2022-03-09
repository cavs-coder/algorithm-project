package com.algorithm.study;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(new Test().isHappy(19));
    }

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int sum;
        while (n != 1) {
            sum = 0;
            while (n > 0) {
                int a = n % 10;
                sum += a * a;
                n /= 10;
            }

            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }

        return true;
    }
}
