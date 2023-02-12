package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt {

    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        findSum(root);
        return tiltSum;
    }

    public int findSum(TreeNode node) {
        if (node == null)
            return 0;
        int leftSum = findSum(node.left);
        int rightSum = findSum(node.right);

        tiltSum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
