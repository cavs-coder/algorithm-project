package com.algorithm.study.greedy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * candy数组记录糖果数量
 * 两次贪心的策略：
 * 局部：
 *      第一次从前往后遍历，只考虑相邻右边大于左边的情况，此时右边糖果数量要更多，即右边糖果数量candy[i]为相邻左边的糖果数量candy[i-1]+1
 *      第二次从后往前遍历，只考虑相邻左边大于右边的情况，此时左边糖果数量要更多，即左边糖果数量candy[i]为：相邻右边的糖果数量candy[i+1]+1
 *      与第一次遍历得到的candy[i]值比较的较大值，这样才能保证此位置新的糖果数量candy[i]值既大于相邻的左边又大于相邻的右边。
 * 全局：
 *      两次局部最优推出全局最优，即相邻孩子中，评分高的孩子获得更多的糖果。
 *
 * 为什么第二次需要从前往后遍历？ 因为此时考虑左边大于右边，需要考虑前一次的结果candy[i+1]，若是从前往后，那么前面的结果不是最终结果，
 * 比如在后续出现分数小的情况，可能前面所有的值都要递增加1。
 */
public class _09_Candy_1 {

    public int candy(int[] ratings) {
        //初始化糖果数组
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        //从前往后遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        //从后往前遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        //计算总和
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
