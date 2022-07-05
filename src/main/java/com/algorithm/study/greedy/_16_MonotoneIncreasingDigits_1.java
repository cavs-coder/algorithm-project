package com.algorithm.study.greedy;

/**
 * 738. 单调递增的数字
 * 用一个指针start维护用更新成9的索引位置。
 * 为什么从右往左遍历：因为当前元素值依赖于其后元素的值，若是当前元素的值减小，可能导致当前元素之前的元素也要发生变换，所以不能从前往后遍历。
 *                  从后往前遍历，在从前往后遍历场景下最可能频繁变换的索引0上的元素最终才确定，现考虑arr.length-1上的元素，再考虑arr.length-2上的元素，
 *                  符合思维逻辑。
 * 贪心：
 *      局部：从右往左遍历，取最后两位作为区间比较，若是arr.length-2处元素大于arr.length-1处元素，则arr.length-2处元素降1，arr.length-1处元素取9。
 *           保证这个区间是最大的单调递增整数。
 *           （例如：63 -> 59。然后将区间59作为整体与arr.length-3处元素比较，重复操作。例如：863 ->(763过渡)799）
 *      全局：局部推出全局，当比较到索引为0处的元素，并且将flag及其后的元素更换为9后，就得到了全局小于等于N的最大单调递增整数。
 * 时间复杂度O(n)、空间复杂度O(n) chars数组
 */
public class _16_MonotoneIncreasingDigits_1 {

    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int start = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
