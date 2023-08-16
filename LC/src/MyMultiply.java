/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/11/011
 * @Copyright： https://clearskycpy.cn
 */
public class MyMultiply {
    /**
     *   123
     *    23
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if( "0".equals(num1) || "0".equals(num2)) return "0"; // 为 0 直接返回
        String res = "0";
        String zero = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
//            取每一位和num1相乘
            String temp = multiply1(num1,num2.charAt(i) - '0');
            temp += zero;
            res = sum(res, temp);
            zero += "0";
        }
        return res;
    }

    /**
     *乘法转换为加法 // 下面是直接进行的乘法计算，也可以用加法替换

     * @param num1
     * @param i
     * @return
     */
    private String multiply1(String num1, int i) {
        if (i == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int n = num1.length() - 1,temp = 0;
        while (n != -1) {
            int nu = temp;
            int t = num1.charAt(n) - '0';
            nu += t * i;
            temp = nu/10;
            sb.append(nu & 10);
            n--;
        }
        if (temp != 0) sb.append(temp);
        return sb.reverse().toString();
    }

    private String sum(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while(n1 != -1 || n2 != -1) {
            int nu = temp;
            if (n1 >= 0) {
                nu += num1.charAt(n1) - '0';
                n1--;
            }
            if (n2 >= 0) {
                nu += num2.charAt(n2) - '0';
                n2--;
            }
            temp = (nu) / 10;
            sb.append(nu % 10);
        }
        if ( temp != 0 )sb.append(temp);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MyMultiply m = new MyMultiply();
        System.out.println(m.multiply("9", "9"));
    }
}
