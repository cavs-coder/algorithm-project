package com.algorithm.study.array._1_binary_search;

/**
 * 704. 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3};
        System.out.println(new BinarySearch().search(nums,2));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println("l: "+l);
        System.out.println("r: "+r);
        return -1;
    }
}
