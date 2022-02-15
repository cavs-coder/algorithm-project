package com.algorithm.study.array._1_binary_search;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(new SearchInsert().searchInsert01(nums, target));
        System.out.println(new SearchInsert().searchInsert02(nums, target));
    }

    /**
     * 方法一
     */
    public int searchInsert01(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 方法二: 二分法
     */
    public int searchInsert02(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        if (target <= nums[l]) {
            return 0;
        }

        if (target > nums[r]) {
            return nums.length;
        }

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return target < nums[mid] ? mid : mid + 1;
    }

    /**
     * 方法二: 二分法。
     * 参考答案改进
     */
    public int searchInsert03(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return r + 1;
    }
}
