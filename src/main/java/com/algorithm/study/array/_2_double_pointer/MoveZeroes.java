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
        int l = 0;
        int r = 0;
        while(r < nums.length){
            if(nums[r] != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
    }
}
