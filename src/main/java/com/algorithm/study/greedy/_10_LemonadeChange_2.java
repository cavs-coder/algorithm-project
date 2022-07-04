package com.algorithm.study.greedy;

/**
 * 860. 柠檬水找零
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 *      情况一：账单为5，只接收下
 *      情况二：账单为10，消耗一个5，增加一个10
 *      情况三：账单为20，先消耗一个5和一个10，不够的话再消耗三个5。
 *      这是贪心的思路，10只能用于20找零，而5能用于10和20的找零，范围更广。
 *      若是优先使用三个5找零，若数组后续仍是为20找零，那没有区别，
 *      但若是为10找零，就会存在5消耗完毕，只有面值10的，无法为10找零的情况。
 */
public class _10_LemonadeChange_2 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five <= 0) return false;
                five--;
                ten++;
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
