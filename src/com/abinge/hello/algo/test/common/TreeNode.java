package com.abinge.hello.algo.test.common;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (null == left ? null: left.getVal()) +
                ", right=" + (null == right ? null: right.getVal())  +
                '}';
    }
}