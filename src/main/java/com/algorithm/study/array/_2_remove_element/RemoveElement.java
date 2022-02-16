package com.algorithm.study.array._2_remove_element;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 双指针法：通过一个快指针和一个慢指针在一个for循环里完成两个for循环的工作
 */
public class RemoveElement {

    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(new RemoveElement().removeElement04(nums, val));
        System.out.println(Arrays.toString(nums));
        System.out.println("count: " + RemoveElement.count);
    }

    /**
     * 1.1、暴力法1、数组中存在val，并且val每次和val后面不为val的元素互换位置
     */
    public int removeElement01(int[] nums, int val) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == val) {
                    continue;
                }
                swap(nums, i, j);
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 1.2、暴力法2、提升效率。
     * 数组中存在val，并且val每次和倒数第一个不为val的值互换位置
     */
    public int removeElement02(int[] nums, int val) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                continue;
            }

            Integer notEqualVal = null;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == val) {
                    continue;
                }
                notEqualVal = j;
            }

            //后续元素全是val
            if (null == notEqualVal) {
                return i;
            }

            swap(nums, i, notEqualVal);
        }

        return nums.length;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        count++;
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 2.1、双指针法
     *      本题：不需要考虑数组中超出新长度后面的元素、新长度元素一一被数组中不为val的元素依次覆盖
     * // TODO: 2022/02/16 18:07  双指针法无思路，参考答案写出
     */
    public int removeElement03(int[] nums, int val) {

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }

        return slowIndex;
    }

    /**
     * 2.2、双指针法优化、前后同时遍历、避免了需要保留的元素的重复赋值操作
     */
    public int removeElement04(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }

        }

        //left和right指针相遇时，若该下标元素为val，则right-1、left不变==最后一个不为val的索引+1、即为新数组长度
        //                      若该下标元素不为val，则right不变、left+1==新数组最后一个不为val的索引+1、即为新数组长度
        return left;
    }
}
