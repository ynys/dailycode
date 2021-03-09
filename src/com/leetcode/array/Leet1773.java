package com.leetcode.array;

import java.util.List;
import java.util.Map;

public class Leet1773 {
    //S1
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> item: items){
            if(
                    "type".equals(ruleKey) && item.get(0).equals(ruleValue) ||
                    "color".equals(ruleKey) && item.get(1).equals(ruleValue) ||
                    "name".equals(ruleKey) && item.get(2).equals(ruleValue)
            ){
                count++;
            }
        }

        return count;
    }

    //S2
    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        String[] keys = {"type","color","name"};
        for(List<String> item: items){
            for(int i = 0; i < keys.length; i++){
                if(keys[i].equals(ruleKey) && item.get(i).equals(ruleValue))
                    count++;
            }
        }

        return count;
    }

    //S3: java 8 stream
    private static final Map<String, Integer> rule = Map.of("type", 0, "color", 1, "name", 2);
    public int countMatches3(List<List<String>> items, String ruleKey, String ruleValue) {
        return (int)items.stream()
                .filter(item -> item.get(rule.get(ruleKey)).equals(ruleValue))
                .count();
    }

    public static void main(String[] args) {
        List<String> item1 = List.of("phone","blue","pixel");
        List<String> item2 = List.of("computer","silver","lenovo");
        List<String> item3 = List.of("phone","gold","iphone");
        List<List<String>> items = List.of(item1,item2,item3);

        Leet1773 leet = new Leet1773();
        System.out.println(leet.countMatches(items, "color","silver"));
        System.out.println(leet.countMatches2(items, "color","silver"));
        System.out.println(leet.countMatches3(items, "color","silver"));

        List<List<String>> items2 = List.of(
                List.of("phone","blue","pixel"),
                List.of("computer","silver","phone"),
                List.of("phone","gold","iphone")
        );

        System.out.println(leet.countMatches(items2, "type","phone"));
        System.out.println(leet.countMatches2(items2, "type","phone"));
        System.out.println(leet.countMatches3(items2, "type","phone"));
    }
}

