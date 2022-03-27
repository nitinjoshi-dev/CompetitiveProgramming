package com.codechef;

//https://www.codechef.com/LRNDSA02/problems/PSHOT
public class CodeChefPSHOT {

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
            br.append((char) (a));
            a = in.read();
            if (a == 13) {
                a = in.read();
            }
        }
        return br + "";
    }

    public static void main(String[] args) throws Exception {
        int testCase = readInt();
        do {
            int numberOfShoots = readInt();
            int totalATeamChance = numberOfShoots, totalBTeamChance = numberOfShoots;
            String shoots = read();
            int teamAGoals = 0;
            int teamBGoals = 0;
            int length = shoots.length();
            int ans = length;
            for (int i = 0; i < length; i++) {
                if ((i & 1) == 0) {
                    totalATeamChance--;
                    teamAGoals = teamAGoals + shoots.charAt(i) - '0';
                } else {
                    totalBTeamChance--;
                    teamBGoals = teamBGoals + shoots.charAt(i) - '0';
                }
                if (teamAGoals > teamBGoals + totalBTeamChance || teamBGoals > teamAGoals + totalATeamChance) {
                    ans = i + 1;
                    break;
                }
            }
            out.write((ans + "\n").getBytes());
        }
        while (--testCase != 0);
        out.flush();
    }
}
