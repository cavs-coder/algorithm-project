package com.algorithm.study.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 关键点：按照身高从大到小排序，身高相同的k小的排前面
 *
 * 排序后，使用队列存储queue、采用贪心的思路：
 *      局部：从头开始插入queue，依据k的大小作为索引插入，每次插入操作后，queue都满足题目要求的队列属性。
 *           每次后续身高小的插入后可以改变前面身高高的顺序，但是前面身高大的k值关系不受影响。
 *      全局：排序后的元素全部插入queue后，整个队列满足题目要求的队列属性。
 *
 * 例子：
 *      初始：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 *      排序后：people =[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 *      插入过程：
 *          插入[7,0]：queue = [[7,0]]
 *          插入[7,1]：queue = [[7,0],[7,1]]
 *          插入[6,1]：queue = [[7,0],[6,1],[7,1]]
 *          插入[5,0]：queue = [[5,0],[7,0],[6,1],[7,1]]
 *          插入[5,2]：queue = [[5,0],[7,0],[5,2],[6,1],[7,1]]
 *          插入[4,4]：queue = [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 *
 * 时间复杂度：O(nlogn + n^2)、空间复杂度O(n)
 */
public class _11_ReconstructQueue_1 {

    public int[][] reconstructQueue(int[][] people) {
        //排序
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[6][2];
        people[0] = new int[]{7, 0};
        people[1] = new int[]{4, 4};
        people[2] = new int[]{7, 1};
        people[3] = new int[]{5, 0};
        people[4] = new int[]{6, 1};
        people[5] = new int[]{5, 2};
        int[][] result = new _11_ReconstructQueue_1().reconstructQueue(people);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
