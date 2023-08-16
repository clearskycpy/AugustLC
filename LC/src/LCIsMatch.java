/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/16/016
 * @Copyright： https://clearskycpy.cn
 */
public class LCIsMatch {

    /**
     * 通配符匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int pn = p.length();
        boolean[][] dp = new boolean[pn + 1][n + 1];
        dp[0][0] = true;
        char[] charStr = s.toCharArray();
        char[] pChars = p.toCharArray();
//        初始化
        for (int i = 1; i < pn + 1; i++) {
            if (pChars[i - 1] == '*' && dp[i - 1][0]) dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {
                if (pChars[i - 1] == '*') {
                    for (int k = 0; k <= j && !dp[i][j]; k++) {
                        dp[i][j] = dp[i][j] || dp[i - 1][k];
                    }
                } else if (pChars[i - 1] == '?' || pChars[i - 1] == charStr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        for (boolean[] arr : dp) {
            for (boolean i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        return dp[pn][n];
    }
}
