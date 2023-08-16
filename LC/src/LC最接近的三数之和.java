import java.util.Arrays;

public class LC最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        int res = -1;
        Arrays.sort(nums);
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) { // 第一个数
            for (int j = i + 1; j < nums.length; j++) {  //第二个数
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < len) {
                        len = sum - target;
                        System.out.println(len);
                        res = sum;
                    }

                }
            }

        }
        return res;
    }
}
