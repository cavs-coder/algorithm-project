package com.algorithm.study.array._2_double_pointer;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new RemoveDuplicates().removeDuplicates01(nums));
        System.out.println(new RemoveDuplicates().removeDuplicates02(nums));
    }

    /**
     * 双指针一:
     *          比较的是nums[slowIndex] != nums[fastIndex]、
     *          当快指针和慢指针位置元素不同时，将快指针元素赋值至慢指针后一索引处
     */
    public int removeDuplicates01(int[] nums) {

        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex] != nums[fastIndex]) {
                nums[++slowIndex] = nums[fastIndex];
            }
        }

        return slowIndex + 1;
    }

    /**
     * 双指针二:
     *          比较的是nums[fastIndex - 1] != nums[fastIndex]、
     *          当快指针和它千一元素不同时，将快指针元素赋值至慢指针元素处
     */
    public int removeDuplicates02(int[] nums) {

        int slowIndex = 1;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex - 1] != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        return slowIndex;
    }
}
