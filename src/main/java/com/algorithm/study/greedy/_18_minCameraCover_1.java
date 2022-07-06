package com.algorithm.study.greedy;

import com.algorithm.study.binary_tree.TreeNode;

/**
 * 968. 监控二叉树
 *
 * 一、每个节点都有三种状态：
 *                      0-节点未被未覆盖
 *                      1-节点上有摄像头
 *                      2-节点已被覆盖
 * 二、采用后序遍历：摄像头可以覆盖上中下三层，所以应该将摄像头放置叶子节点的父节点，比起放在叶子节点可以节省一层的摄像头。
 *                 如果采用从上往下遍历，头节点放不放摄像头也就节省一个节点，而从下往上，叶子节点可以节省叶子节点数量个摄像头。
 *
 * 三：叶子节点的左右子节点即null节点的状态：
 *                 叶子节点的左右子节点即null节点，状态不该为未被覆盖，这样叶子节点就要装摄像头了。也不该为有摄像头，这样叶子节点
 *                 就是被覆盖状态了，为节省摄像头，叶子节点的父节点可以不装摄像头，为未被覆盖状态，将摄像头装在叶子节点的爷爷节点上，
 *                 那么实际上叶子节点未被摄像头覆盖，是错误的。那么叶子节点的左右子节点即null节点只能是已被覆盖状态，为2。
 *  贪心：
 *      局部：叶子节点父节点安装摄像头，所用数量最少。
 *      全局：局部推全局，所有摄像头数量最少。
 *
 *  时间复杂度O(n)、n为节点个数
 *  空间复杂度O(h)、h为树的深度，即递归调用栈的深度
 *
 *  有四种情况：
 *            情况Ⅰ、若是左右子节点都被覆盖，为2、那么当前节点状态应为未被覆盖，为0
 *            情况Ⅱ、若是左右子节点至少有一个节点未被覆盖，那么当前节点状态应为有摄像头，覆盖子节点
 *            情况Ⅲ、若是左右子节点至少有一个摄像头，那么当前节点状态应为被覆盖。(III应该在Ⅱ后面，此时排除了子节点一个摄像头一个未被覆盖的情况)
 *            情况Ⅳ、若是头节点返回的是未被覆盖，因为头节点已经没有父节点给他加摄像头来覆盖，所以特殊判断，需加一个摄像头。
 */
public class _18_minCameraCover_1 {

    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        if (traversal(root) == 0) {
            //情况Ⅳ
            result++;
        }
        return result;
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 2;
        }

        int left = traversal(node.left);
        int right = traversal(node.right);

        //处理当前节点
        if (left == 2 && right == 2) {
            //情况Ⅰ
            return 0;
        } else if (left == 0 || right == 0) {
            //情况Ⅱ
            result++;
            return 1;
        } else {
            //情况Ⅲ
            return 2;
        }
    }
}
