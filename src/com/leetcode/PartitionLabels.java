package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static  List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        Map<Character, Integer> lastPositionOfAlphabet = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastPositionOfAlphabet.put(c, i);
        }

        int counter = lastPositionOfAlphabet.get(s.charAt(0));
        int previousCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            int lastPos = lastPositionOfAlphabet.get(s.charAt(i));
            if(lastPos > counter) {
                counter = lastPos;
            }
            if(counter == i) {
                partitions.add(i + 1 - previousCounter);
                previousCounter = i + 1;
            }
        }

        return partitions;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
