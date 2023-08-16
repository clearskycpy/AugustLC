import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC001矩阵中的和 {
    /**
     * 时间复杂度： nlgn
     *
     * @param nums
     * @return
     */
    public int matrixSum(int[][] nums) {
        int n = nums[0].length; // 数字的个数
        int res = 0;
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for(int[] arr : nums) {
            PriorityQueue<Integer> temp = new PriorityQueue<>((a,b) -> b - a);
            for(int i : arr) {
               temp.add(i);
            }
            list.add(temp);
        }
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for(PriorityQueue<Integer> priorityQueue : list) {
                Integer poll = priorityQueue.poll();
                max = Math.max(max,poll);
            }
            res += max;
        }
        return res;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int matrixSum2(int[][] nums) {
        for(int[] arr : nums) Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max,nums[j][i]);
            }
            res += max;
        }
        return res;
    }


}
