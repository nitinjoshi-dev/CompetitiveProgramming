package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.codechef.com/LRNDSA03/problems/SAVKONO
public class CodeChefSAVKONO {

    static java.io.OutputStream out = new java.io.BufferedOutputStream(System.out);

    static class FastReader {
        final String del;
        private final BufferedReader input;
        private StringTokenizer tokenizer;

        public FastReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
            del = " ";
        }

        public FastReader(String delimiter) {
            input = new BufferedReader(new InputStreamReader(System.in));
            del = delimiter;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens())
                try {
                    tokenizer = new StringTokenizer(input.readLine(), del);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() {
            String res = null;
            try {
                res = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int testCases = fastReader.nextInt();
        PriorityQueue<Integer> strengthOfSoldiers = new PriorityQueue<>(Collections.reverseOrder());
        do {
            int numberOfSoldiers = fastReader.nextInt();
            int powerOfPain = fastReader.nextInt();
            int numberOfAttacks = 0;
            strengthOfSoldiers.clear();
            for(int i = 0; i< numberOfSoldiers; i++) {
                strengthOfSoldiers.add(fastReader.nextInt());
            }
            while(!strengthOfSoldiers.isEmpty() && powerOfPain > 0) {
                int highestSoldierStrength = strengthOfSoldiers.poll();
                powerOfPain -= highestSoldierStrength;
                numberOfAttacks++;
                highestSoldierStrength = highestSoldierStrength >> 1;
                if(highestSoldierStrength != 0) {
                    strengthOfSoldiers.add(highestSoldierStrength);
                }
            }
            if(powerOfPain > 0) {
                out.write(("Evacuate\n").getBytes());
            } else {
                out.write((numberOfAttacks + "\n").getBytes());
            }
        } while(--testCases != 0);
        out.flush();
    }
}
