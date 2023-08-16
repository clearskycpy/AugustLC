public class LC最大子数组和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // dp数组
        dp[0] = nums[0]; // 第一个没有前置项可以依赖
        int res = nums[0]; // 为了不重复遍历，所以采用一边计算的方式统计 dp0 就是nums[0]
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0],dp = nums[0]; // 为了不重复遍历，所以采用一边计算的方式统计 dp0 就是nums[0]
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }
        return res;
    }

    /**
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return  -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l =  0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >=nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }




}
