package com.algorithm.study.array._1_binary_search;

/**
 * 704. 二分查找
 * 感悟：1、若是target在有序数组最小值的左侧时： l 保持不变为 0、而 r=l-1 为 -1
 *      2、若是target在有序数组最大值的右侧时： r 保持不变为 nums.length-1、而 l=r+1为 nums.length
 *      3、若是target在有序数组范围内、但不是任一数组元素时：l与r最终会相邻并交换位置。
 *          例如nums为{-1, 0, 3},target为2时，最终 l=2，r=1
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
