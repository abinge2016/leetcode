package com.abinge.hello.algo.test.backtracking;

import java.util.*;

/**
 * 全排列问题
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println("例题一：输入一个整数数组，其中不包含重复元素，返回所有可能的排列。");
        System.out.println("=======================================================");

        List<Integer> state1 = new ArrayList<>();
        List<Integer> choices1 = Arrays.asList(1,2,3,3);
        boolean[] selected1 = new boolean[choices1.size()];

        List<List<Integer>> res1 = new ArrayList<>();
        backtraceV1(state1, choices1, selected1, res1);
        System.out.println("backtrace res1：" + res1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");



        System.out.println("例题二：输入一个整数数组，其中包含重复元素，返回所有可能的排列。");
        System.out.println("=======================================================");

        List<Integer> state2 = new ArrayList<>();
        List<Integer> choices2 = Arrays.asList(1,2,3,3);
        boolean[] selected2 = new boolean[choices2.size()];

        List<List<Integer>> res2 = new ArrayList<>();
        backtraceV2(state2, choices2, selected2, res2);
        System.out.println("backtrace res2：" + res2);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


    /**
     * 不重复元素
     * @param state
     * @param choices
     * @param selected
     * @param res
     */
    public static void backtraceV1(List<Integer> state, List<Integer> choices, boolean[] selected, List<List<Integer>> res) {
        if (isSolution(state, choices)) {
            recordSolution(state, res);
        }
        for (int i = 0; i < choices.size(); i++) {
            Integer choice = choices.get(i);
            if (isValid1(selected, i)) {
                makeChoice1(state, choice, selected, i);
                backtraceV1(state, choices, selected, res);
                undoChoice1(state, choice, selected, i);
            }
        }
    }

    /**
     * 不重复元素
     * @param state
     * @param choices
     * @param selected
     * @param res
     */
    public static void backtraceV2(List<Integer> state, List<Integer> choices, boolean[] selected, List<List<Integer>> res) {
        if (isSolution(state, choices)) {
            recordSolution(state, res);
        }
        // 遍历所有选择
        Set<Integer> duplicated = new HashSet<>();
        for (int i = 0; i < choices.size(); i++) {
            Integer choice = choices.get(i);
            if (isValid2(selected, i, duplicated, choice)) {
                makeChoice2(state, choice, selected, i, duplicated);
                backtraceV2(state, choices, selected, res);
                undoChoice2(state, choice, selected, i);
            }
        }
    }

    private static void recordSolution(List<Integer> state, List<List<Integer>> res) {
        res.add(new ArrayList<>(state));
    }

    private static boolean isSolution(List<Integer> state, List<Integer> choices) {
        return null != state && null != choices && state.size() == choices.size();
    }

    private static void undoChoice1(List<Integer> state, Integer choice, boolean[] selected, int index) {
        state.remove(choice);
        selected[index] = false;
    }

    private static void makeChoice1(List<Integer> state, Integer choice, boolean[] selected, int index) {
        state.add(choice);
        selected[index] = true;
    }

    private static boolean isValid1(boolean[] selected, int index) {
        return !selected[index];
    }




    private static void undoChoice2(List<Integer> state, Integer choice, boolean[] selected, int index) {
        state.remove(state.size() - 1);
        selected[index] = false;
    }

    private static void makeChoice2(List<Integer> state, Integer choice, boolean[] selected, int index, Set<Integer> duplicated) {
        state.add(choice);
        selected[index] = true;
        duplicated.add(choice);
    }

    private static boolean isValid2(boolean[] selected, int index, Set<Integer> duplicated, Integer choice) {
        return !selected[index] && !duplicated.contains(choice);
    }


}
