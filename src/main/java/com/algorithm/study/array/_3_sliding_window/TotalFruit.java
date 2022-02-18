package com.algorithm.study.array._3_sliding_window;

import java.util.HashMap;

/**
 * 904. 水果成篮 medium
 * // TODO: 2022/2/18 2022/02/18 15:20 无思路、哈希表+滑动窗口实现
 */
public class TotalFruit {

    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(new TotalFruit().totalFruit01(fruits));
        System.out.println(new TotalFruit().totalFruit02(fruits));
        System.out.println(new TotalFruit().totalFruit03(fruits));
    }

    /**
     * 方法一：哈希表+滑动窗口实现。  43 ms, 在所有 Java 提交中击败了58.71%的用户
     */
    public int totalFruit01(int[] fruits) {

        int maxLen = 0;
        int i = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int j = 0; j < fruits.length; j++) {
            counter.put(fruits[j], counter.getOrDefault(fruits[j], 0) + 1);
            while (counter.size() >= 3) {
                counter.put(fruits[i], counter.get(fruits[i]) - 1);
                if (counter.get(fruits[i]) == 0) {
                    counter.remove(fruits[i]);
                }
                i++;
            }

            int curLen = j - i + 1;
            maxLen = curLen > maxLen ? curLen : maxLen;
        }

        return maxLen;
    }

    /**
     * 方法二：双指针法实现、关键用两个type标记水果类型
     *      找到两颗不同果树交界处，分别从左、从右查找到第一颗第三种类型的树，计算下标得到长度。
     */
    public int totalFruit02(int[] fruits) {

        int maxLen = 0;
        int left = 0;
        int right = 1;
        int type1;
        int type2;

        //3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4
        while (right < fruits.length) {
            //求两颗不同果树 a和 b的交接位置
            if (fruits[right - 1] != fruits[right]) {
                type1 = fruits[right - 1];
                type2 = fruits[right];

                //求第一颗树 a 的下标
                left = right - 1;
                while (left > 0) {
                    left--;
                    //往前查找直到找到第三种树
                    if (fruits[left] != type1 && fruits[left] != type2) {
                        left++;
                        break;
                    }
                }

                //求第二棵树 b 的下标
                while (right < fruits.length - 1) {
                    right++;
                    //往后查找直到找到第三种树
                    if (fruits[right] != type1 && fruits[right] != type2) {
                        right--;
                        break;
                    }
                }

                int curLen = right - left + 1;
                maxLen = curLen > maxLen ? curLen : maxLen;
            }
            right++;
        }

        //没变化、说明果树都一样
        return maxLen == 0 ? fruits.length : maxLen;
    }

    public int totalFruit03(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        // 下面的情况果树数量均大于2
        int left = 0;
        int right = 1;
        int maxSize = 0;
        // 用来标识果树的种类
        int type1;
        int type2;
        // {1,2,2,2,2,1,1,1,3,3,4}
        //3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4
        while (right < fruits.length) {
            /**
             * 首先移动right指针，让其移动到一个right和right-1果树种类不同的位置
             * {3,3,3,1,2,1,1,2,3,3,4}
             * 然后left从right-1位置开始遍历，right从right位置开始遍历，两边都直到出现第三种水果后停止
             * 或者运行到边界位置停止
             * 如果没有运行到边界，将第三种水果的位置记为right，left从right-1位置开始向左遍历
             * right从当前位置开始向右遍历
             */
            if (fruits[right] != fruits[right - 1]) { // 如果找到了两颗不同的果树
                type1 = fruits[right - 1];
                type2 = fruits[right];

                // 向左遍历查找水果
                left = right - 1;
                while (left > 0) {
                    left--;
                    // 如果出现第三种水果就停止
                    if (fruits[left] != type1 && fruits[left] != type2) {
                        left++;
                        break;
                    }
                }

                // 向右遍历查找水果
                while (right < fruits.length - 1) {
                    right++;
                    // 如果出现第三种水果就停止
                    if (fruits[right] != type1 && fruits[right] != type2) {
                        right--;
                        break;
                    }
                }
                // 比较数量
                maxSize = Math.max(maxSize, right - left + 1);
            }
            right++;
        }
        // 如果最大值为0都没变化，说明果树都一样
        return maxSize == 0 ? fruits.length : maxSize;
    }

}
