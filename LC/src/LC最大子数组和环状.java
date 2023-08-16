public class LC最大子数组和环状 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0], dpMax = nums[0], dpMin = nums[0],maxValue = nums[0], minValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dpMax = Math.max(dpMax + nums[i], nums[i]);
            dpMin = Math.min(dpMin + nums[i], nums[i]);
            maxValue = Math.max(dpMax, maxValue);
            minValue = Math.min(dpMin, minValue);
        }
        if (sum == minValue) return  maxValue;
        return Math.max(maxValue,sum - minValue);
    }
}
