package com.leetcode.stack;

import java.util.Stack;

public class Leet227 {
    public static void main(String[] args) {
        String[] tests = {
                "3+2*2",
                " 3/2 ",
                " 3+5 / 2 "
        };

        for(String test: tests){
            //System.out.println(calculate(test));
            System.out.println(calculateNoStack(test));
        }
    }

    //S1: stack
    public static int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();
        int num = 0;
        int result = 0;
        char lastSign = '+';
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            //if the current char is digit, then convert it to number
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = num * 10 + (cur - '0');// the reason we need * 10, it is because the number might be more than 1 digit
            }

            //handle sign + calculation pushed to stack
            //skip whitespace and only consider operators
            ////cur is current sign in this case if the 1st half meets
            //i == len - 1: to handle the last char is a number, we still need to do the calculation
            if(!Character.isDigit(cur) && cur != ' ' || i == len - 1){
                switch (lastSign) {//newest sign to calc
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }

                lastSign = cur; // update cur sign to sign
                num = 0; // reset num
            }
        }

        //calculate result
        for(int n: stack){
            result+=n;
        }

        return result;
    }

    //S2: no stack
    public static int calculateNoStack(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();
        int num = 0;
        int result = 0;
        int tempSum = 0;//temp result with last sign
        char lastSign = '+';

        for(int i = 0; i < len; i++) {
            //if the current char is digit, then convert it to number
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');// the reason we need * 10, it is because the number might be more than 1 digit
            }

            if(!Character.isDigit(cur) && cur != ' ' || i == len - 1){
                switch (lastSign) {//newest sign to calc
                    case '-':
                        result += tempSum;
                        tempSum = -num;
                        break;
                    case '+':
                        result += tempSum;
                        tempSum = num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }

                lastSign = cur;
                num = 0;
            }
        }

        result += tempSum;
        return result;
    }
}
