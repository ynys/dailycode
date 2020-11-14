package com.leetcode.stack;

import java.util.Stack;

public class Leet682 {
    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        String[] ops3 = {"1"};
        String[] ops4 = {"1","C","-62","-45","-68"};
        Leet682 leet = new Leet682();
        System.out.println(leet.calPoints(ops));
        System.out.println(leet.calPoints2(ops));
        System.out.println(leet.calPoints3(ops));
        System.out.println();

        System.out.println(leet.calPoints(ops2));
        System.out.println(leet.calPoints2(ops2));
        System.out.println(leet.calPoints3(ops2));
        System.out.println();

        System.out.println(leet.calPoints(ops3));
        System.out.println(leet.calPoints2(ops3));
        System.out.println(leet.calPoints3(ops3));
        System.out.println();

        System.out.println(leet.calPoints(ops4));
        System.out.println(leet.calPoints2(ops4));
        System.out.println(leet.calPoints3(ops4));
    }

    //S1: improved
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> s = new Stack<>();

        for(String op: ops){
            switch (op) {
                case "C":
                    s.pop();
                    break;
                case "D":
                    s.push(s.peek() * 2);
                    break;
                case "+":
                    int previousScore = s.pop();
                    int sum = previousScore + s.peek();
                    s.push(previousScore);
                    s.push(sum);
                    break;
                default:
                    s.push(Integer.parseInt(op));
                    break;
            }
        }

        for(int n: s){
            res+=n;
        }

        return res;
    }

    //S3: put res in one loop
    //T: O(n), n is the size of input array
    //S: O(n)
    public int calPoints2(String[] ops) {
        int res = 0;
        Stack<Integer> s = new Stack<>();

        for(String op: ops){
            switch (op) {
                case "C":
                    res-=s.peek();
                    s.pop();
                    break;
                case "D":
                    s.push(s.peek() * 2);
                    res+=s.peek();
                    break;
                case "+":
                    int previousScore = s.pop();
                    int sum = previousScore + s.peek();
                    s.push(previousScore);
                    s.push(sum);
                    res+=sum;
                    break;
                default:
                    s.push(Integer.parseInt(op));
                    res+= s.peek();
                    break;
            }
        }

        return res;
    }

        //S2: mine
    public int calPoints3(String[] ops) {
        int res = 0;
        Stack<Integer> s = new Stack<>();

        for(String op: ops){
            int len = op.length();
            if(len == 1){
                char c = op.charAt(0);
                if(Character.isDigit(c)){
                    s.push(Character.getNumericValue(c));
                }else{
                    if(c == 'C'){
                        s.pop();
                    }else if(c == 'D'){
                        s.push(s.peek() * 2);
                    }else if(c == '+'){
                        int previousScore = s.pop();
                        int sum = previousScore + s.peek();
                        s.push(previousScore);
                        s.push(sum);
                    }
                }
            }else if (len > 1){
                s.push(Integer.parseInt(op));
            }
        }

        for(int n: s){
            res+=n;
        }

        return res;
    }
}
