package com.algorithm.study.array._2_double_pointer;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println("original: "+Arrays.toString(nums));
        new MoveZeroes().moveZeroes(nums);
        System.out.println("now: "+Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int val = 0;

        moveValue(nums, val);
    }

    private void moveValue(int[] nums, int val) {

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
                nums[fast] = 0;
            }
        }
    }
}
