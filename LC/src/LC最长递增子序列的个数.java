import java.util.Arrays;

public class LC最长递增子序列的个数 {
    /**
     * 定义dp[i] 为 以i结尾的最长递增子序列的长度
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 1;
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] max = new int[nums.length];
        Arrays.fill(max,1);
        for (int i = 1; i < nums.length; i++) {
            int k = i - 1;
            dp[i] = 1;
            while (k >= 0) {  // 求出当前位置结尾的最长子序列长度
                if (nums[k] < nums[i]) {
                    int tempMaxLen = dp[k] + 1;  // 求出此时的最大长度
                    if (tempMaxLen == dp[i]) {
                        max[i] += max[k]; // 加上前面构成k的 max 中方式
                    } else if (tempMaxLen > dp[i]) {
                        max[i] = max[k];  // 大于的情况下直接等于前面的 组成方式
                        dp[i] = tempMaxLen;
                    }
                }
                k--;
            }
            if (dp[i] > maxLen) {
                res = max[i];
            } else if (dp[i] == maxLen) {
                res += max[i];
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        if(maxLen == 1) return nums.length;
        return res;
    }
}
