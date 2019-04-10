package com.leetcode.du20190410twosum;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentThesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                StringBuffer parentThesis = new StringBuffer();
//                if (i > 1 && j == i) {
//                    continue;
//                }
                // 写到这里

                //1、拼接第N列完整（）
                //2、拼接左括号
                //3、拼接右括号
                //4、拼接尾部括号

                int index = 0;
                int count = 0;
                // 打印左括号
                while (index < i) {
                    parentThesis.append("(");
                    index++;
                }
                while (index >= i) {
                    parentThesis.append(")");
                    index--;
                    count++;
                }

                for (int c = 0; c < n - count; c++) {
                    parentThesis.append("()");
                }
                result.add(parentThesis.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentThesis g = new GenerateParentThesis();
        System.out.println(g.generateParenthesis(3).toString());
    }
}
