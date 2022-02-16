package com.algorithm.study.array._1_binary_search;

/**
 * 69. x 的平方根
 * 二分法，数组下标为 0-x、target为 x、若是target在有序数组范围内、但不是任一数组元素时，则 跳出while时 [r,l], r<target<l的小数
 * <p>
 * (若是target在有序数组范围内、但不是任一数组元素时：l与r最终会相邻并交换位置。例如nums为{-1, 0, 3},target为2时，最终 l=2，r=1)
 * <p>
 * // TODO: 2022/02/16 15:11 二分法无思路。参考答案解析后自己写出
 */
public class MySqrt {

    public static void main(String[] args) {
        int x = 0;
        System.out.println(new MySqrt().mySqrt(x));
    }

    public int mySqrt(int x) {

        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            //mid * mid < x 改为除法防溢出mid < x / mid
            if ((long) mid * mid < x) {
                l = mid + 1;
            } else if (x < (long) mid * mid) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return r;
    }
}
