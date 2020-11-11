package com.leetcode.stack;

import java.util.Stack;

public class Leet1544 {

    public static void main(String[] args) {
        String[] tests = {"leEeetcode","abBAcC"};
        Leet1544 leet = new Leet1544();

        for(String t: tests){
            System.out.println(leet.makeGood(t));
        }
    }

    String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32)//diff between upper & lower
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        for(Character c: stack){
            sb.append(c);
        }

        return sb.toString();
    }
}
