package com.abinge.hello.algo.test.backtracking;

import com.abinge.hello.algo.test.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrace {
    public static void main(String[] args) {
        TreeNode treeNode = buildTreeNode();
        List<TreeNode> res = new ArrayList<>();
        preOrder(res, treeNode);
        System.out.println("例题一：给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表。");
        System.out.println("=======================================================");
        System.out.println("preOrder res：" + res);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("例题二：在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径。");
        System.out.println("=======================================================");
        TreeNode treeNode1 = buildTreeNode();
        List<List<TreeNode>> res1 = new ArrayList<>();
        List<TreeNode> path1 = new ArrayList<>();
        preOrderV1(res1, path1, treeNode1);
        System.out.println("preOrder res1：" + res1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题三：在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。");
        System.out.println("=======================================================");
        TreeNode treeNode2 = buildTreeNode();
        List<List<TreeNode>> res2 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        preOrderV2(res2, path2, treeNode2,3);
        System.out.println("preOrder res2：" + res2);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题三：在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。");
        System.out.println("=======================================================");
        TreeNode treeNode3 = buildTreeNode();
        List<List<TreeNode>> res3 = new ArrayList<>();
        List<TreeNode> path3 = new ArrayList<>();
        preOrderV3(path3, Arrays.asList(treeNode3),res3);
        System.out.println("preOrder res3：" + res3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题三：在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。");
        System.out.println("=======================================================");
        TreeNode treeNode4 = buildTreeNode();
        List<List<TreeNode>> res4 = new ArrayList<>();
        List<TreeNode> path4 = new ArrayList<>();
        preOrderV4(path4, Arrays.asList(treeNode4),res4);
        System.out.println("preOrder res4：" + res4);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");





    }


    public static void preOrder(List<TreeNode> res, TreeNode root){
        if (null == root){
            return;
        }
        if (root.getVal() == 7){
            res.add(root);
        }
        preOrder(res, root.getLeft());
        preOrder(res, root.getRight());
    }

    public static void preOrderV1(List<List<TreeNode>> res, List<TreeNode> path, TreeNode root){
        if (null == root){
            return;
        }
        path.add(root);
        if (root.getVal() == 7){
            res.add(new ArrayList<>(path));
        }

        preOrderV1(res, path, root.getLeft());
        preOrderV1(res, path, root.getRight());

        path.remove(path.size() -1);

    }


    public static void preOrderV2(List<List<TreeNode>> res, List<TreeNode> path, TreeNode root, int limitVal){
        if (null == root || root.getVal() == limitVal){
            return;
        }
        path.add(root);
        if (root.getVal() == 7){
            res.add(new ArrayList<>(path));
        }

        preOrderV2(res, path, root.getLeft(),limitVal);
        preOrderV2(res, path, root.getRight(),limitVal);

        path.remove(path.size() -1);
    }


    public static void preOrderV3(List<TreeNode> path, List<TreeNode> nodes, List<List<TreeNode>> res){
        for (TreeNode treeNode : nodes){
            if (null != treeNode && treeNode.getVal() != 3){
                path.add(treeNode);
                if (treeNode.getVal() == 7){
                    res.add(new ArrayList<>(path));
                }
                preOrderV3(path, Arrays.asList(treeNode.getLeft(), treeNode.getRight()), res);
                path.remove(path.size() -1);
            }
        }
    }

    /**
     * 使用递归的思路重新调整代码
     * 1、终止条件：暂时无，这里可以认为是满足条件，添加进入最终结果
     * 2、递归调用：满足怎样的条件才会调用递归
     * 3、返回结果：最终全部遍历完成后，自动返回
     * @param path
     * @param nodes
     * @param res
     */
    public static void preOrderV4(List<TreeNode> path, List<TreeNode> nodes, List<List<TreeNode>> res){
        if (!path.isEmpty() && path.get(path.size() - 1).getVal() == 7){
            res.add(new ArrayList<>(path));
        }
        for (TreeNode treeNode : nodes){
            if (null != treeNode && treeNode.getVal() != 3){
                path.add(treeNode);
                preOrderV4(path, Arrays.asList(treeNode.getLeft(), treeNode.getRight()), res);
                path.remove(path.size() -1);
            }
        }
    }

    /**
     * 进化为回溯算法模板
     *
     * @param state：表示问题当前的状态，也就是上面示例的path
     * @param choices：当前状态下可作出的选择，对应上面示例的TreeNode的集合（根路径或根路径下的左右子节点）
     * @param res
     */
    public static void backtrace(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res){
//        if (!path.isEmpty() && path.get(path.size() - 1).getVal() == 7){
//            res.add(new ArrayList<>(path));
//        }
        // 判断是否为解，也就是满足条件
        if (isSolution(state)){
            // 记录解
            recordSolution(state, res);
        }
        // 遍历所有选择
        for (TreeNode choice : choices){
            if (isValid(state, choice)){
                makeChoice(state, choice);
                backtrace(state, Arrays.asList(choice.getLeft(), choice.getRight()), res);
                undoChoice(state, choice);
            }
        }
    }


    /**
     * 判断当前状态是否为解
     * @param state
     * @return
     */
    private static boolean isSolution(List<TreeNode> state){
        return !state.isEmpty() && state.get(state.size() - 1).getVal() == 7;
    }

    /**
     * 记录解
     *
     * @param state
     * @param res
     */
    private static void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        res.add(new ArrayList<>(state));
    }

    /**
     * 判断在当前状态下，该选择是否合法
     * @return
     */
    private static boolean isValid(List<TreeNode> state, TreeNode choice){
        return null != choice && choice.getVal() != 3;
    }


    /**
     * 更新状态
     *
     * @param state
     * @param choice
     */
    private static void makeChoice(List<TreeNode> state, TreeNode choice){
        state.add(choice);
    }

    /**
     * 恢复状态
     *
     * @param state
     * @param choice
     */
    private static void undoChoice(List<TreeNode> state, TreeNode choice){
        state.remove(state.size() - 1);
    }


    private static TreeNode buildTreeNode(){
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);

        TreeNode root7 = new TreeNode(8);
        TreeNode root8 = new TreeNode(7);

        root.setLeft(root1);
        root.setRight(root2);

        root1.setLeft(root3);
        root1.setRight(root4);

        root2.setLeft(root5);
        root2.setRight(root6);


        root4.setLeft(root8);
        root4.setRight(root7);

        return root;
    }

}
