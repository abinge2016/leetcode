package com.abinge.hello.algo.test.backtracking;

import java.util.*;

public class BackTrace2 {
    public static void main(String[] args) {
        System.out.println("例题一：给定一个正整数数组 nums 和一个目标正整数 target ，请找出所有可能的组合，使得组合中的元素和等于 target 。给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。");
        System.out.println("=======================================================");
        List<Integer> state1 = new ArrayList<>();
        List<Integer> choices1 = Arrays.asList(3,3,4,5);

        List<List<Integer>> res1 = new ArrayList<>();
        backtraceV1(state1, choices1, res1, 9);
        System.out.println("backtrace res1：" + res1);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题二：给定一个正整数数组 nums 和一个目标正整数 target ，请找出所有可能的组合，使得组合中的元素和等于 target 。给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。");
        System.out.println("=======================================================");
        List<Integer> state2 = new ArrayList<>();
        List<Integer> choices2 = Arrays.asList(3,3,4,5);

        List<List<Integer>> res2 = new ArrayList<>();
        backtraceV2(state2, choices2, res2, 9,0);
        System.out.println("backtrace res2：" + res2);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题三：给定一个正整数数组 nums 和一个目标正整数 target ，请找出所有可能的组合，使得组合中的元素和等于 target 。给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。");
        System.out.println("=======================================================");
        List<Integer> state3 = new ArrayList<>();
        List<Integer> choices3 = Arrays.asList(3,3,4,5);

        List<List<Integer>> res3 = new ArrayList<>();
        backtraceV3(state3, choices3, res3, 9,0);
        System.out.println("backtrace res3：" + res3);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("例题三：给定一个正整数数组 nums 和一个目标正整数 target ，请找出所有可能的组合，使得组合中的元素和等于 target 。给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。");
        System.out.println("=======================================================");
        List<Integer> state4 = new ArrayList<>();
        List<Integer> choices4 = Arrays.asList(3,3,4,5);

        List<List<Integer>> res4 = new ArrayList<>();
        backtraceV4(state4, choices4, res4, 9,0);
        System.out.println("backtrace res4：" + res4);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * 数据传入时（不能存在重复数据）
     * @param state
     * @param choices
     * @param res
     * @param target
     */
    public static void backtraceV1(List<Integer> state, List<Integer> choices, List<List<Integer>> res, Integer target){
        if(isSolutionV1(state,target)){
            recordSolution(state,res);
        }
        for (int i=0; i<choices.size();i++){
            Integer choice = choices.get(i);
            if (isValidV1(state,choice, target)){
                makeChoice(state, choice);
                backtraceV1(state, choices, res, target);
                undoChoice(state,choice);
            }
        }
    }

    /**
     * 数据传入时（不能存在重复数据）
     * @param state
     * @param choices
     * @param res
     * @param target
     */
    public static void backtraceV2(List<Integer> state, List<Integer> choices, List<List<Integer>> res, Integer target, Integer sum){
        if(isSolutionV2(sum,target)){
            recordSolution(state,res);
        }
        for (int i=0; i<choices.size();i++){
            Integer choice = choices.get(i);
            if (isValidV2(sum,choice, target)){
                makeChoice(state, choice);
                backtraceV2(state, choices, res, target, sum + choice);
                undoChoice(state,choice);
            }
        }
    }

    /**
     * 数据传入时（不能存在重复数据），需要实现排序好
     * @param state
     * @param choices
     * @param res
     * @param target
     * @param start
     */
    public static void backtraceV3(List<Integer> state, List<Integer> choices, List<List<Integer>> res, Integer target, Integer start){
        if(isSolutionV3(target)){
            recordSolution(state,res);
        }
        for (int i = start; i<choices.size();i++){
            Integer choice = choices.get(i);
            if (isValidV3(choice, target)){
                makeChoice(state, choice);
                backtraceV3(state, choices, res, target - choice, i);
                undoChoice(state,choice);
            }
        }
    }

    /**
     * 数据传入时（可能存在重复数据），需要实现排序好
     * @param state
     * @param choices
     * @param res
     * @param target
     * @param start
     */
    public static void backtraceV4(List<Integer> state, List<Integer> choices, List<List<Integer>> res, Integer target, Integer start){
        if(isSolutionV3(target)){
            recordSolution(state,res);
        }
        for (int i = start; i<choices.size();i++){
            Integer choice = choices.get(i);
            if (isValidV3(choice, target)){
                if (i > start && choices.get(i) == choices.get(i - 1)){
                    continue;
                }
                makeChoice(state, choice);
                backtraceV3(state, choices, res, target - choice, i + 1);
                undoChoice(state,choice);
            }
        }
    }

    private static boolean isValidV3(Integer choice, Integer target) {
        return target - choice >= 0;
    }

    private static boolean isSolutionV3(Integer target) {
        return target == 0;
    }

    private static boolean isValidV2(Integer sum, Integer choice, Integer target) {
        return (sum + choice) <= target;
    }

    private static boolean isSolutionV2(Integer sum, Integer target) {
        return sum == target;
    }

    private static void undoChoice(List<Integer> state, Integer choice) {
        state.remove(state.size() -1);
    }

    private static void makeChoice(List<Integer> state, Integer choice) {
        state.add(choice);
    }

    private static boolean isValidV1(List<Integer> state, Integer choice, Integer target) {
        return state.parallelStream().mapToInt(Integer::intValue).sum() + choice <= target;
    }

    private static void recordSolution(List<Integer> state, List<List<Integer>> res) {
        res.add(new ArrayList<>(state));
    }

    private static boolean isSolutionV1(List<Integer> state, Integer target) {
        return state.parallelStream().mapToInt(Integer::intValue).sum() == target;
    }

}
