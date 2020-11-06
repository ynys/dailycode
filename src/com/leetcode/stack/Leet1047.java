package com.leetcode.stack;

import java.util.Stack;

public class Leet1047 {
    public static void main(String[] args) {
        Leet1047 leet = new Leet1047();
        String t1 = "abbaca";
        String t2 = "abbac";

        System.out.println(leet.removeDuplicates(t1));
        System.out.println(leet.removeDuplicates(t2));

        System.out.println(leet.removeDuplicates2(t1));
        System.out.println(leet.removeDuplicates2(t2));
    }

    //S1: Use an actual stack
    //T: O(n), n is len of s
    //S: O(n), save chars in s
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(stack.isEmpty() || c != stack.peek()){
                stack.push(c);
            }else {
                stack.pop();
            }
        }

        for(char c: stack){
            sb.append(c);
        }

        return sb.toString();
    }

    //S2: use a StringBuilder to act like a stack
    //T: O(n), n is len of s
    //S: O(n), save chars in s
    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int size = sb.length();
            if (size == 0 || sb.charAt(size - 1) != c) {
                sb.append(c);
            } else {
                sb.deleteCharAt(size - 1);
            }
        }
        return sb.toString();
    }
}
