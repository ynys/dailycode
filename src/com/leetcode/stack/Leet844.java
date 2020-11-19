package com.leetcode.stack;

import java.util.Stack;

public class Leet844 {
    public static void main(String[] args) {
        Leet844 leet = new Leet844();

        String s01= "y#fo##f";
        String s02 = "y#f#o##f";
        System.out.println(leet.backspaceCompare(s01,s02));

        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(leet.backspaceCompare(s1,s2));

        String s11 = "ab##";
        String s22 = "c#d#";
        System.out.println(leet.backspaceCompare(s11,s22));


        String s111 = "a##c";
        String s222 = "#a#c";
        System.out.println(leet.backspaceCompare(s111,s222));


        String s1111 = "a#c";
        String s2222 = "b";
        System.out.println(leet.backspaceCompare(s1111,s2222));

    }
    public boolean backspaceCompare(String S, String T) {
        return executeBackspace(S).equals(executeBackspace(T));
    }

    private String executeBackspace(String s){
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if(!stack.empty()){
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
