package com.leetcode.du20190416;

public class ReverseInt {
    public int reverse(int x) {
        if (x > Integer.MIN_VALUE && x < Integer.MAX_VALUE) {
            StringBuffer sb = new StringBuffer();
            sb.append(x);
            sb.reverse();
            int idx = sb.indexOf("-");
            try {
                if (idx > 0) {
                    return Integer.valueOf("-" + sb.substring(0, idx));
                } else {
                    return Integer.valueOf(sb.toString());
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ReverseInt r = new ReverseInt();
        System.out.println(r.reverse(1534236469));
    }
}
