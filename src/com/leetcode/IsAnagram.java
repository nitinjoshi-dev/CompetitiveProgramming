package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://neetcode.io/problems/is-anagram
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Integer, Integer> charactersCountMap = new HashMap<>();
        s.chars().forEach(c -> charactersCountMap.put(c, charactersCountMap.getOrDefault(c, 0) + 1));

        for (int character : t.toCharArray()) {
            if (!charactersCountMap.containsKey(character)) return false;
            charactersCountMap.put(character, charactersCountMap.get(character) - 1);
        }

        for (int character : charactersCountMap.keySet()) {
            if (charactersCountMap.get(character) != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("racecar", "carrace"));
        System.out.println(isAnagram.isAnagram("rat", "car"));
    }
}
