package com.quantumics.quantumics.logics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCountOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = sc.nextLine();
        Map<String, Integer> wordCountMap = getCountOfStrings(inputString);
        wordCountMap.entrySet().forEach(x -> System.out.println(x.getKey()+" ," +x.getValue()));

    }

    public static Map<String, Integer> getCountOfStrings(String inputString) {
        Map<String, Integer> map = new HashMap<>();
        for(String c: inputString.toLowerCase().split(" ")) {
            if(map.get(c) == null) {
                map.put(c,1);
            } else {
                Integer count  = map.get(c);
                map.put(c, count+1);
            }
        }
        return   map;
    }
}
