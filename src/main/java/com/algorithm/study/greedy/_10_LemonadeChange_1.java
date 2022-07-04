package com.algorithm.study.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. 柠檬水找零
 * 暴力法：时间复杂度O(n)、空间复杂度O(n)
 */
public class _10_LemonadeChange_1 {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            Integer fiveCount = map.getOrDefault(5, 0);
            Integer tenCount = map.getOrDefault(10, 0);
            if (bill == 5) {
                map.put(5, fiveCount + 1);
            }
            if (bill == 10) {
                fiveCount--;
                if (fiveCount < 0) {
                    return false;
                }
                map.put(5, fiveCount);
                map.put(10, tenCount + 1);
            }
            if (bill == 20) {
                if (tenCount > 0) {
                    fiveCount--;
                    if (fiveCount < 0) {
                        return false;
                    }
                    map.put(5, fiveCount);

                    tenCount--;
                    if (tenCount < 0) {
                        return false;
                    }
                    map.put(10, tenCount);
                } else {
                    fiveCount -= 3;
                    if (fiveCount < 0) {
                        return false;
                    }
                    map.put(5, fiveCount);
                }
            }
        }

        return true;
    }
}
