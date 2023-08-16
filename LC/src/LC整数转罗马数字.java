public class LC整数转罗马数字 {
    class Solution {
//        罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//        字符          数值
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//        给你一个整数，将其转为罗马数字。
        public String intToRoman(int num) {  // 2990
//            查看是否有 m
            StringBuilder builder = new StringBuilder();
            while (num/1000 > 0) {
                num -= 1000;
                builder.append("M");  // MM
            }
            // num = 990  builder = MM
            // 对 查看是否有 900
            while(num/900 > 0) {
                num -= 900;
                builder.append("CM");
            }
            while (num/500 > 0) {
                num -= 500;
                builder.append("D");
            }
            while (num/400 > 0) {
                num -= 400;
                builder.append("CD");
            }
            while (num/100 > 0) {
                num -= 100;
                builder.append("C");
            }
            while(num/90 > 0) {
                num -= 90;
                builder.append("XC");
            }
            while (num/50 > 0) {
                num -= 50;
                builder.append("L");
            }
            while (num/40 > 0) {
                num -= 40;
                builder.append("XL");
            }

            while (num/10 > 0) {
                num -= 10;
                builder.append("X");
            }
            while(num/9 > 0) {
                num -= 9;
                builder.append("IX");
            }
            while (num/5 > 0) {
                num -= 5;
                builder.append("V");
            }
            while (num/4 > 0) {
                num -= 4;
                builder.append("IV");
            }
            while (num > 0) {
                num -= 1;
                builder.append("I");
            }
            return builder.toString();
        }
    }
}
