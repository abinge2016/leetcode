package com.abinge.hello.algo.test.binaryTree;

import java.util.*;

public class BinaryTreeBreadthFirstTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = buildTreeNode();
        List<Integer> integers = breadthFirstTraversal(treeNode);
        System.out.println("breadthFirstTraversal:");
        System.out.println(integers);
        System.out.println("+++++++++++++++++++++++++++++++++");


        integers = preOrder(treeNode);
        System.out.println("preOrder:");
        System.out.println(integers);
        System.out.println("+++++++++++++++++++++++++++++++++");

        integers = inOrder(treeNode);
        System.out.println("inOrder:");
        System.out.println(integers);
        System.out.println("+++++++++++++++++++++++++++++++++");

        integers = postOrder(treeNode);
        System.out.println("postOrder:");
        System.out.println(integers);
        System.out.println("+++++++++++++++++++++++++++++++++");

    }

    /**
     * 「层序遍历 level-order traversal」从顶部到底部逐层遍历二叉树，并在每一层按照从左到右的顺序访问节点
     *  层序遍历本质上属于「广度优先遍历 breadth-first traversal」，它体现了一种“一圈一圈向外扩展”的逐层遍历方式
     *  广度优先遍历通常借助“队列”来实现。队列遵循“先进先出”的规则，而广度优先遍历则遵循“逐层推进”的规则，两者背后的思想是一致的。
     *
     *
     * 时间复杂度 O(n) ：所有节点被访问一次，使用O(n)时间，其中n为节点数量。
     * 空间复杂度O(n) ：在最差情况下，即满二叉树时，遍历到最底层之前，队列中最多同时存在(n+1)/2个节点，占用O(n)空间。
     *
     * @param root
     * @return
     */
    private static List<Integer> breadthFirstTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.getVal());
            if (Objects.nonNull(treeNode.getLeft())){
                queue.offer(treeNode.getLeft());
            }
            if (Objects.nonNull(treeNode.getRight())){
                queue.offer(treeNode.getRight());
            }
        }
        return list;
    }

    private static List<Integer> preOrder(TreeNode root){
        if (Objects.isNull(root)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.getVal());
        List<Integer> leftList = preOrder(root.getLeft());
        if (null != leftList){
            list.addAll(leftList);
        }
        List<Integer> rightList = preOrder(root.getRight());
        if (null != rightList){
            list.addAll(rightList);
        }
        return list;
    }

    private static List<Integer> inOrder(TreeNode root){
        if (Objects.isNull(root)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> leftList = inOrder(root.getLeft());
        if (null != leftList){
            list.addAll(leftList);
        }
        list.add(root.getVal());
        List<Integer> rightList = inOrder(root.getRight());
        if (null != rightList){
            list.addAll(rightList);
        }
        return list;
    }

    private static List<Integer> postOrder(TreeNode root){
        if (Objects.isNull(root)){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> leftList = postOrder(root.getLeft());
        if (null != leftList){
            list.addAll(leftList);
        }
        List<Integer> rightList = postOrder(root.getRight());
        if (null != rightList){
            list.addAll(rightList);
        }
        list.add(root.getVal());
        return list;
    }


    private static TreeNode buildTreeNode(){
        TreeNode root = new TreeNode(8);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(12);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(10);
        TreeNode root6 = new TreeNode(14);

        root.setLeft(root1);
        root.setRight(root2);

        root1.setLeft(root3);
        root1.setRight(root4);

        root2.setLeft(root5);
        root2.setRight(root6);

        return root;
    }

}
