package com.algorithm.study.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 三种可能情况：1、最终到 1
 * 2、最终进入循环
 * 3、值不循环，越来越大，接近无穷大
 * 证明不会出现第三种情况：9 -> 81、99 -> 81+81=81*2=162、999 ->243、9999 -> 364 因为 1 <= n <= 2^31 - 1
 * 2^31 - 1 = 21 4748 3647 < 99 9999 9999、而99 9999 9999的每位平方和为 81*10 = 810，下一次810会小于三位数999的平方和243
 * 所以最差情况是环长度为243(在1-243循环)，或者最终到 1 停止、也就是回归 1与 2情况。
 * <p>
 * 所以本题最终可以变为平方和数字是否重复出现过。
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
    }

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int sum;
        while (n != 1) {
            sum = 0;
            while (n > 0) {
                int a = n % 10;
                sum += a * a;
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }

        return true;
    }
}
