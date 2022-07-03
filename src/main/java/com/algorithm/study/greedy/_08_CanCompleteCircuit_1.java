package com.algorithm.study.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 134. 加油站
 * 贪心：时间复杂度O(n)、空间复杂度O(1)
 * 局部：假设区间为[i,j]
 *      每个加油站的剩余油量记为rest += gas[x] - cost[x]，若是区间存在起点加油站，则rest从索引i到索引j加油站都会大于等于0。
 *      若是rest连续大于等于0在下一个索引j处不成立了，说明j处用光了i到j积累下来的所有油，
 *      而且局部[i,j]必不可能有起点，因为都会在j处终止，此时起点需要从j+1处算起。
 * 全局：
 *      若是存在满足条件的起点加油站，剩余总油量total必定大于等于0（此前的rest与每一步的（gas[x] - cost[x]）相加，
 *      得出新的rest需要大于等于0才能继续下一步，局部推全局）。
 *      若是total小于0，必定不满足条件，若是total大于等于0，返回记录的j+1
 */
public class _08_CanCompleteCircuit_1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int rest = 0;
        int startIndex = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            rest += gas[i] - cost[i];
            //rest和小于0，此局部区间不存在起点startIndex，从下个位置开始计算并重制rest和
            if (rest < 0) {
                startIndex = (i + 1) % n;
                rest = 0;
            }
        }

        //不满足条件
        if (total < 0) {
            return -1;
        }

        return startIndex;
    }
}
