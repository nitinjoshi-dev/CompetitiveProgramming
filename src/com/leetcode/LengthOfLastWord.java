package com.leetcode;

//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean isStarted = false;
        for (int i = s.length() - 1; i > -1 ; i--) {
            if(s.charAt(i) != ' ') {
                length++;
                isStarted = true;
            } else if (isStarted){
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();

        String s = "Hello World";
        System.out.println(obj.lengthOfLastWord(s));

        s = "   fly me   to   the moon  ";
        System.out.println(obj.lengthOfLastWord(s));

        s = "luffy is still joyboy";
        System.out.println(obj.lengthOfLastWord(s));

    }

}
