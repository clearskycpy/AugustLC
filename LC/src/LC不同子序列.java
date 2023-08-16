public class LC不同子序列 {
    /**
     * s的子序列得到t的方法数
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[][] dp = new int[tChar.length][sChar.length];
        dp[0][0] = sChar[0] == tChar[0] ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = dp[0][i-1];
            if (tChar[0] == sChar[i]) dp[0][i]++;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (sChar[j] == tChar[i]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
