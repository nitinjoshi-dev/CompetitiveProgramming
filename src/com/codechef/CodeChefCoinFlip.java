package com.codechef;

//https://www.codechef.com/LRNDSA01/problems/CONFLIP
public class CodeChefCoinFlip {

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

    public static void main(String[] args) {
        try {
            int testCase = readInt();
            do {
                int numberOfGames = readInt();
                for (int gameNumber = 0; gameNumber < numberOfGames; gameNumber++) {
                    int initialPosition = readInt();
                    int numberOfCoins = readInt();
                    int positionToFind = readInt();
                    int ans = 0;
                    if(numberOfCoins % 2 == 0 || initialPosition == positionToFind) {
                        ans = numberOfCoins / 2;
                    } else {
                        ans = (numberOfCoins + 1) / 2;
                    }
                    out.write((ans + "\n").getBytes());
                }
            }
            while (--testCase != 0);
            out.flush();
        } catch (Exception e) {
        }
    }
}
