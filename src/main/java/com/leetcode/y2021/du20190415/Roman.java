package com.leetcode.y2021.du20190415;

import java.util.HashMap;
import java.util.Map;

public class Roman {
    private static Map<String, Integer> CODE_TABLE = new HashMap<String, Integer>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public int romanToInt(String s) {
        String[] romans = s.split("");
        int[] nums = new int[romans.length];
        for (int i = 0; i < romans.length; i++) {
            nums[i] = CODE_TABLE.get(romans[i]);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 >= nums.length) {
                sum += nums[i];
                break;
            }
            if (nums[i] >= nums[i + 1]) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Roman r = new Roman();
        System.out.println(r.romanToInt("MCMXCIV"));
    }

}

