package com.codechef;

import java.util.Stack;

//https://www.codechef.com/LRNDSA02/problems/COMPILER
public class CodeChefCOMPILER {

    static java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);
    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);

    static int readInt() throws Exception {
        int no = 0;
        //boolean minus = false;
        int a = 10;
        while (a == 10 || a == 32)
            a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            no = no * 10 + (a - '0');
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return no;
    }

    static String read() throws Exception {
        StringBuilder br = new StringBuilder("");
        int a = in.read();
        while (a != 10 && a != 32 && a != -1) {
            br.append((char)(a));
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return br + "";
    }

    public static void main(String[] args) {
        try {
            int testCase = readInt();
            do {
                int ans = 0;
                Stack<Character> parsingStack = new Stack<>();
                String expression = read();
                int length = expression.length();
                for(int i = 0; i < length ; i++) {
                    char inputChar = expression.charAt(i);
                    if(inputChar == '<') {
                        parsingStack.push('<');
                    }
                    if(inputChar == '>') {
                        if(parsingStack.isEmpty()) {
                            break;
                        } else {
                            parsingStack.pop();
                            if(parsingStack.isEmpty()) {
                                ans = i + 1;
                            }
                        }
                    }
                }
                out.write((ans + "\n").getBytes());
            }
            while (--testCase != 0);
            out.flush();
        } catch (Exception e) {
        }
    }
}
