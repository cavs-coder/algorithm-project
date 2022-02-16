package com.algorithm.study.array._1_binary_search;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * // TODO: 2022/02/16 11:18 通过参考答案方法一，由求左右边界转化为求右右边界解题
 */
public class SearchRange_02 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new SearchRange_02().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {

        int leftIndex = binarySearch(nums, target - 1);
        int rightIndex = binarySearch(nums, target) - 1;

        if (leftIndex <= rightIndex && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }

        return new int[]{-1, -1};
    }

    /**
     * 求出第一个比 target 大的元素的索引
     * 求右边界时、要朝右侧推进，所以target要大于nums[mid]，当相等时也要继续朝右侧推进。边界情况时 l=nums.length
     */
    public int binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
