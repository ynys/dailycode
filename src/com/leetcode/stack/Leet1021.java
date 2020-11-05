package com.leetcode.stack;

public class Leet1021 {
    public static void main(String[] args) {
        String[] tests = {
                "(()())(())",
                "(()())(())(()(()))",
                "()()"
        };

        Leet1021 leet = new Leet1021();
        for(String test: tests){
            System.out.println(leet.removeOuterParentheses(test));
        }
    }

    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);// 1st ( is not appended
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
