package com.abinge.hello.algo.test.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {14, 12, 15, 13, 11, 16};
        mergeSort(null, arr, 0, arr.length - 1);
        System.out.println("final sort arr：" + traversal(arr));
    }

    /* 合并左子数组和右子数组 */
// 左子数组区间 [left, mid]
// 右子数组区间 [mid + 1, right]
    public static void merge(String traceId, int[] nums, int left, int mid, int right) {
        // 初始化辅助数组
        int[] tmp = Arrays.copyOfRange(nums, left, right + 1);
        // 左子数组的起始索引和结束索引
        int leftStart = left - left, leftEnd = mid - left;
        // 右子数组的起始索引和结束索引
        int rightStart = mid + 1 - left, rightEnd = right - left;
        // i, j 分别指向左子数组、右子数组的首元素
        int i = leftStart, j = rightStart;
        System.out.println("mergeSort 合并 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid
                + ", tmp index:[" + left + "~" + (right + 1) + "), tmp:" + traversal(tmp)
                + ", left:(" + leftStart + "~" + leftEnd
                + "), right:(" + rightStart + "~" + rightEnd
                + "), leftStart=" + leftStart
                + ", rightStart=" + rightStart
                + ", i = " + i
                + ", j =" + j);
        // 通过覆盖原数组 nums 来合并左子数组和右子数组
        for (int k = left; k <= right; k++) {
            // 若“左子数组已全部合并完”，则选取右子数组元素，并且 j++
            if (i > leftEnd) {
                nums[k] = tmp[j++];
                System.out.println("mergeSort 合并 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid
                        + ", tmp index:[" + left + "~" + (right + 1) + "), tmp:" + traversal(tmp)
                        + ", left:(" + leftStart + "~" + leftEnd
                        + "), right:(" + rightStart + "~" + rightEnd
                        + "), leftStart=" + leftStart
                        + ", rightStart=" + rightStart
                        + ", i = " + i
                        + ", j =" + (j-1)
                        + ", k = " + k
                        + ", i=" + i + " > leftEnd=" + leftEnd + ": nums[" + k + "] = tmp[" + (j - 1) + "]" + ", nums[]:" + traversal(nums));
            } else if (j > rightEnd || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
                System.out.println("mergeSort 合并 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid
                        + ", tmp index:[" + left + "~" + (right + 1) + "), tmp:" + traversal(tmp)
                        + ", left:(" + leftStart + "~" + leftEnd
                        + "), right:(" + rightStart + "~" + rightEnd
                        + "), leftStart=" + leftStart
                        + ", rightStart=" + rightStart
                        + ", i = " + (i-1)
                        + ", j =" + j
                        + ", k = " + k
                        + ", j=" + j + " > rightEnd=" + rightEnd + " || tmp[" + (i-1) + "] <= tmp[" + j + "]: nums[" + k + "] = tmp[" + (i - 1) + "]" + ", nums[]:" + traversal(nums));
            }
            // 否则，若“左右子数组都未全部合并完”且“左子数组元素 > 右子数组元素”，则选取右子数组元素，并且 j++
            else {
                nums[k] = tmp[j++];
                System.out.println("mergeSort 合并 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid
                        + ", tmp index:[" + left + "~" + (right + 1) + "), tmp:" + traversal(tmp)
                        + ", left:(" + leftStart + "~" + leftEnd
                        + "), right:(" + rightStart + "~" + rightEnd
                        + "), leftStart=" + leftStart
                        + ", rightStart=" + rightStart
                        + ", i = " + i
                        + ", j =" + (j-1)
                        + ", k = " + k
                        + ", else nums[" + k + "] = tmp[" + (j - 1) + "]" + ", nums[]:" + traversal(nums));
            }
        }
    }

    /* 归并排序 */
    public static void mergeSort(String parentTraceId, int[] nums, int left, int right) {
        String traceId = buildTraceId();
        traceId = null != parentTraceId ? (parentTraceId + "__" + traceId) : traceId;
        System.out.println("mergeSort 划分 traceId:" + traceId + ", left:" + left + ", right:" + right);
        // 终止条件
        if (left >= right)
            return;                      // 当子数组长度为 1 时终止递归
        // 划分阶段
        int mid = (left + right) / 2;    // 计算中点
        System.out.println("mergeSort 划分 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid + ", 左子数组:(" + left + "~" + mid + "), 右子数组:(" + (mid + 1) + "~" + right + ")");
        mergeSort(traceId, nums, left, mid);      // 递归左子数组
        mergeSort(traceId, nums, mid + 1, right); // 递归右子数组
        // 合并阶段
        System.out.println("mergeSort 合并 traceId:" + traceId + ", left:" + left + ", right:" + right + ", mid:" + mid + ", 左子数组:(" + left + "~" + mid + "), 右子数组:(" + (mid + 1) + "~" + right + ")");
        merge(traceId, nums, left, mid, right);
    }

    public static String traversal(int[] arr) {
        if (Objects.isNull(arr)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i == arr.length - 1) {
                sb.append("]");
            } else {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static String buildTraceId() {
        int randomInt = (int) (Math.random() * (99999 - 10000 + 1));
        return String.valueOf(10000 + randomInt);
    }

}
