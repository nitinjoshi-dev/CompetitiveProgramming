package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://neetcode.io/problems/string-encode-and-decode
public class StringEncodeAndDecode {
    public String encode(List<String> strs) {
        String encodedString = "";
        for (String str : strs) {
            encodedString += str.length() + "#" + str;
        }

        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            int j = i;
            StringBuilder stringifiedLength = new StringBuilder();
            while (str.charAt(j) != '#') {
                stringifiedLength.append(str.charAt(j));
                j++;
            }
            i = ++j;
            int length = Integer.parseInt(stringifiedLength.toString());
            StringBuilder decodedString = new StringBuilder();
            while (j < i + length) {
                decodedString.append(str.charAt(j));
                j++;
            }
            decodedStrings.add(decodedString.toString());
            i = j;
        }

        return decodedStrings;
    }

    public static void main(String[] args) {
        StringEncodeAndDecode obj = new StringEncodeAndDecode();
        List<String> input = List.of("Hello", "World");
        String encodedString = obj.encode(input);
        System.out.println(encodedString);
        List<String> decodedStrings = obj.decode(encodedString);
        System.out.println(decodedStrings);

        input = List.of("Hello", "World", "Java", "Programming");
        encodedString = obj.encode(input);
        System.out.println(encodedString);
        decodedStrings = obj.decode(encodedString);
        System.out.println(decodedStrings);
    }
}
