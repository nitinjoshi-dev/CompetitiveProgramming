package com.leetcode;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class MinDistanceBetweenBst {

    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        getMinMax(root);
        return minDiff;
    }

    private MinMax getMinMax(TreeNode node) {
        MinMax leftMinMax, rightMinMax;
        int leftDiff = Integer.MAX_VALUE, rightDif = Integer.MAX_VALUE;
        if (node.left == null) {
            leftMinMax = new MinMax(node.val, node.val);
        } else {
            leftMinMax = getMinMax(node.left);
            leftDiff = node.val - leftMinMax.max;
        }
        if (node.right == null) {
            rightMinMax = new MinMax(node.val, node.val);
        } else {
            rightMinMax = getMinMax(node.right);
            rightDif = rightMinMax.min - node.val;
        }
        minDiff = min(minDiff, leftDiff,  rightDif);
        return new MinMax(leftMinMax.min, rightMinMax.max);
    }

    int lastVal = -1;
    private void diffRec( TreeNode root ) {
        if ( root == null ) return;
        this.diffRec(root.left);
        if ( lastVal >= 0 ) minDiff = Math.min(minDiff, Math.abs(lastVal - root.val));
        lastVal = root.val;
        this.diffRec(root.right);
    }
    public int minDiffInBSTBetterSolution(TreeNode root) {
        this.diffRec(root);
        return minDiff;
    }

    private int min(int a, int b, int c) {
        if (a < b) {
            if (a < c)
                return a;
            return c;
        } else if (b < c) {
            return b;
        }
        return c;
    }




    class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
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
