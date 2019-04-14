package com.leetcode.du20190410;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentThesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                if (j == 1 && i != 1) { // 去掉重复打印的组合
                    continue;
                }
                StringBuffer sb = new StringBuffer();

                //1、拼接第N列完整()
                int leftFullIndex = 0; // 记录打印几个完整的括号 i-1>0
                while (leftFullIndex < i - 1) {
                    sb.append("()");
                    leftFullIndex++;
                }

                //2、拼接左括号
                int leftParenthesis = 0;
                while (leftParenthesis < j) {
                    sb.append("(");
                    leftParenthesis++;
                }

                //3、拼接右括号
                int rightParenthesis = 0;
                while (rightParenthesis < j) {
                    sb.append(")");
                    rightParenthesis++;
                }

                //4、拼接尾部括号
                int rightFullIndex = n - leftFullIndex - leftParenthesis;
                while (rightFullIndex > 0) {
                    sb.append("()");
                    rightFullIndex--;
                }
                result.add(sb.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentThesis g = new GenerateParentThesis();
        System.out.println(g.generateParenthesis(5).toString());
    }
}
