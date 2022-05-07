package com.algorithm.study.binary_tree;

/**
 * 450. 删除二叉搜索树中的节点
 * 普通二叉树的删除方式
 * 遍历整棵树
 * 1、第一次找到要删除的节点的val，将该val与它右子树的最左边节点的val交换
 * 2、第二次......重复1操作
 * 3、直到val处于叶子节点时，null覆盖给其父节点
 * (要删除节点为非叶子节点会被遍历多次)
 */
public class _26_DeleteNode_1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                //左右字数都不为null，需删除节点val与其左子树最左边节点val交换
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                int temp = root.val;
                root.val = cur.val;
                cur.val = temp;
            }
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }
}
