package com.leetcode.stack;

import java.util.Stack;

public class Leet1598 {
    public static void main(String[] args) {
        String[] t1 = {"d1/","d2/","../","d21/","./"};
        String[] t2 = {"d1/","d2/","./","d3/","../","d31/"};
        String[] t3 = {"d1/","../","../","../"};
        String[] t4 = {"./","../","./"};

        Leet1598 leet = new Leet1598();
        System.out.println(leet.minOperations(t1));
        System.out.println(leet.minOperations(t2));
        System.out.println(leet.minOperations(t3));
        System.out.println(leet.minOperations(t4));
    }

    //No stack
    //T:O(n)
    //S:O(1)
    public int minOperations(String[] logs) {
        int min = 0;
        for(String log: logs){
            if(log.equals("../") && min != 0){
                min--;
            }else if(!log.equals("./") && !log.equals("../")){
                min++;
            }
        }

        return min;
    }

    //Stack
    //T: O(n)
    //S: O(n)
    public int minOperations2(String[] logs) {
        Stack<String> s = new Stack<>();

        for(String log: logs){
            if(log.equals("../") && !s.isEmpty()){
                s.pop();
            }else if(!log.equals("./") && !log.equals("../")){
                s.push(log);
            }
        }

        return s.size();
    }


}
