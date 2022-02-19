package com.algorithm.study.array._1_binary_search;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置 medium
 *  // TODO: 2022/02/16 00:00 二分法无思路。参考答案，利用两个二分法分别求左右边界完成。
 */
public class SearchRange_01 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new SearchRange_01().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {

        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);

        //1、target在数组两侧、不在数组范围内的情况
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }

        //2、target在数组范围内、但不是任一数组元素的情况
        if (rightBorder - leftBorder == 1) {
            return new int[]{-1, -1};
        }

        //3、target为数组内元素的情况
        return new int[]{leftBorder + 1, rightBorder - 1};
    }

    public int getLeftBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int leftBorder = -2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            //求左边界时、要朝左侧推进，所以target要小于nums[mid]，当相等时也要继续朝左侧推进。边界情况时 r=-1=leftBorder
            if (target <= nums[mid]) {
                r = mid - 1;
                leftBorder = r;
            } else {
                l = mid + 1;
            }
        }

        return leftBorder;
    }

    public int getRightBorder(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int rightBorder = -2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            //求右边界时、要朝右侧推进，所以target要大于nums[mid]，当相等时也要继续朝右侧推进。边界情况时 l=nums.length=rightBorder
            if (nums[mid] <= target) {
                l = mid + 1;
                rightBorder = l;
            } else {
                r = mid - 1;
            }
        }

        return rightBorder;
    }
}
