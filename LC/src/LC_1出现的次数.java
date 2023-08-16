public class LC_1出现的次数 {
    final static int[] ARR = {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) return n > 0 ? 1 : 0; // 只有一位的时候
        int[] fs = new int[m],ls = new int[m];  // fs : 当前位置前置数， ls 当前位置后置数
        ls[0] = Integer.parseInt(s.substring(1));
        fs[m - 1] = Integer.parseInt(s.substring(0,m - 1));
        for (int i = 1; i < m - 1; i++) {
            fs[i] = Integer.parseInt(s.substring(0,i));
            ls[i] = Integer.parseInt(s.substring(i + 1));
        }
//        遍历位置
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int temp = s.charAt(i) - '0';
            int len = m - i - 1;
            // 前面部分小于 fs[i] 此时后面部分的数可以任取，取i 为 1 后面有 一位的话 就是10种变化 2 位就是 100 以此类推
            ans += fs[i] * ARR[len];
            // 前面部分等于  判断当前数的具体情况 如果等于 1 那么就有后面的 ls种， 如果等于0 那么就是 0 中 如果大于 1 那么就有 ARR[m - i - 1]种
            if (temp > 1) {
                ans += ARR[len];
            } else if (temp == 1) {
                ans += ls[i] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_1出现的次数 lc = new LC_1出现的次数();
        System.out.println(lc.countDigitOne(1100));
    }
}
