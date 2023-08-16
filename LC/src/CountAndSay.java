/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/11/011
 * @Copyright： https://clearskycpy.cn
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            int start = 0, end = res.length();
            StringBuilder sb = new StringBuilder();
            while (start < end) {
                int cnt = 1;
                char temp = res.charAt(start);
                start++;
                while(start < end && res.charAt(start) == temp) {
                    start++;
                    cnt++;
                }
                sb.append(cnt).append(temp);
            }
            res = sb.toString();
        }
        return res;
    }
}
