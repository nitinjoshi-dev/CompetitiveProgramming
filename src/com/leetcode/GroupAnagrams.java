package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Integer, Integer>, String> wordCount = new HashMap<>(); // character -> count -> word
        Map<String, List<String>> wordList = new HashMap<>(); // word -> list of anagrams

        for (String word : strs) {
            Map<Integer, Integer> charactersCountMap = new HashMap<>();
            word.chars().forEach(c -> charactersCountMap.put(c, charactersCountMap.getOrDefault(c, 0) + 1));

            if (wordCount.containsKey(charactersCountMap)) {
                wordList.get(wordCount.get(charactersCountMap)).add(word);
            } else {
                List<String> anagrams = wordList.getOrDefault(word, new ArrayList<>());
                anagrams.add(word); // add the word to the list of anagrams
                wordList.put(word, anagrams);
                wordCount.put(charactersCountMap, word);
            }
        }
        return wordList.values().stream().collect(Collectors.toList());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> output = obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        printOutput(output);

        output = obj.groupAnagrams(new String[]{""});
        printOutput(output);

        output = obj.groupAnagrams(new String[]{"a"});
        printOutput(output);
    }

    private static void printOutput(List<List<String>> output) {
        for (List<String> list : output) {
            System.out.print("[");
            for (String str : list) {
                System.out.print(str + ",");
            }
            System.out.println("]");
        }
    }
}
