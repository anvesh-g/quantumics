package com.quantumics.quantumics.logics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicateCharacterInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = sc.next();
        String duplicateCharacters = getDuplicateCharacters(inputString);
        System.out.println("Duplicate characters are "+duplicateCharacters);

    }

    public static String getDuplicateCharacters(String inputString) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: inputString.toLowerCase().toCharArray()) {
            if(map.get(c) == null) {
                map.put(c,1);
            } else {
                Integer count  = map.get(c);
                map.put(c, count+1);
            }
        }

        return   map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(record -> record.getKey()+"")
                .collect(Collectors.joining(","));
    }
}
